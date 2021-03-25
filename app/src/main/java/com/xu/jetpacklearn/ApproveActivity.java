package com.xu.jetpacklearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.xu.jetpacklearn.adapter.ApproveAdapter;
import com.xu.jetpacklearn.adapter.NewsAdapter;
import com.xu.jetpacklearn.api.RetrofitClient;
import com.xu.jetpacklearn.base.BaseObserver;
import com.xu.jetpacklearn.base.BaseResponse;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.databinding.ActivityApproveBinding;
import com.xu.jetpacklearn.decoration.DividerDecoration;
import com.xu.jetpacklearn.model.ApproveNode;
import com.xu.jetpacklearn.model.BasicInfo;
import com.xu.jetpacklearn.model.BudgetBean;
import com.xu.jetpacklearn.model.FactorBean;
import com.xu.jetpacklearn.model.FactorRequest;
import com.xu.jetpacklearn.views.basicinfoview.BasicInfoViewModel;
import com.xu.jetpacklearn.views.budgetexpendview.BudgetExpendViewModel;
import com.xu.jetpacklearn.views.factor.FactorItemViewModel;
import com.xu.jetpacklearn.views.sp.AlreadyViewModel;
import com.xu.jetpacklearn.views.sp.ApprovingViewModel;
import com.xu.jetpacklearn.views.sp.WaitingViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ApproveActivity extends AppCompatActivity {
    private List<BaseViewModel> models = new ArrayList<>();
    private ApproveAdapter adapter;
    private ApprovingViewModel approvingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_approve);

        ActivityApproveBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_approve);

        adapter = new ApproveAdapter();
        binding.rvApprove.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvApprove.addItemDecoration(new DividerDecoration());
        binding.rvApprove.setAdapter(adapter);


        netWork();


    }

    private void netWork() {
        // 获取基本信息
        /*RetrofitClient.getInstance().getApi().getBasicInfo("1372072907257245697")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse<BasicInfo>>() {
                    @Override
                    public void onSuccess(BaseResponse<BasicInfo> basicInfo) {
                        BasicInfo info = basicInfo.getResult();

                        BasicInfoViewModel basicInfoViewModel = new BasicInfoViewModel();
                        basicInfoViewModel.departName = info.getApplyDeptName();
                        basicInfoViewModel.amount = info.getReimburseAmount();
                        basicInfoViewModel.personName = info.getHandlerUserName();
                        basicInfoViewModel.reason = info.getApplyReason();

                        models.add(basicInfoViewModel);
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });*/

        // 获取预算-支出事项
        /*RetrofitClient.getInstance().getApi().getBudgets("1372072907257245697")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse<List<BudgetBean>>>() {
                    @Override
                    public void onSuccess(BaseResponse<List<BudgetBean>> listBaseResponse) {
                        List<BudgetBean> budgetBeans = listBaseResponse.getResult();

                        for (BudgetBean budgetBean : budgetBeans) {
                            BudgetExpendViewModel budgetExpendViewModel = new BudgetExpendViewModel();
                            budgetExpendViewModel.expendName = budgetBean.getExpendItemName();
                            budgetExpendViewModel.budgetName = budgetBean.getTargetName();
                            budgetExpendViewModel.availableAmount = budgetBean.getAvailableAmount();
                            budgetExpendViewModel.applyAmount = budgetBean.getApplyAmount();
                            models.add(budgetExpendViewModel);
                        }
                        // 设置数据
                        adapter.setData(models);

                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });*/

        // 获取审批流程

        int taskId = 2157510;
        HashMap<String, Integer> approveQuery = new HashMap<>();


        approveQuery.put("procInstId", 2157501);
        approveQuery.put("taskId", taskId);

        RetrofitClient.getInstance().getApi().getApproveNodes(approveQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse<List<ApproveNode>>>() {
                    @Override
                    public void onSuccess(BaseResponse<List<ApproveNode>> listBaseResponse) {
                        //根据不同的阶段创建不同的model
                        List<ApproveNode> approveNodes = listBaseResponse.getResult();
                        for (int i = 0; i < approveNodes.size(); i++) {
                            ApproveNode approveNode = approveNodes.get(i);
                            if (approveNode.getTaskStatus() != 0) {
                                // 已审核
                                AlreadyViewModel alreadyViewModel = new AlreadyViewModel();
                                alreadyViewModel.orderNum = String.valueOf(i + 1);
                                alreadyViewModel.processName = approveNode.getNodeName();
                                alreadyViewModel.checkUserName = approveNode.getTaskUser().get(0).getUserName();
                                alreadyViewModel.checkTime = approveNode.getCheckTime();
                                alreadyViewModel.checkResult = approveNode.getTaskStatusDesc();

                                models.add(alreadyViewModel);
                            } else {
                                // 待审核
                                if (null != approveNode.getTaskId()) {
                                    approvingViewModel = new ApprovingViewModel();
                                    approvingViewModel.orderNum = String.valueOf(i + 1);
                                    approvingViewModel.processName = approveNode.getNodeName();
                                    approvingViewModel.checkUserName = "本地获取name";
                                    approvingViewModel.checkTime = approveNode.getStartTime();
                                    approvingViewModel.checkResult = "正在审核";
                                    models.add(approvingViewModel);
                                } else {
                                    // 未审核
                                    WaitingViewModel waitingViewModel = new WaitingViewModel();
                                    waitingViewModel.orderNum = String.valueOf(i + 1);
                                    waitingViewModel.nodeName = approveNode.getNodeName();
                                    waitingViewModel.taskStatusDesc = approveNode.getTaskStatusDesc();
                                    models.add(waitingViewModel);
                                }
                            }
                        }


                        // 获取审批要素
                        FactorRequest factorRequest = new FactorRequest();
                        factorRequest.setBillTypeCode("501");
                        factorRequest.setMainId("1374625007012339713");
                        factorRequest.setTaskId("2157510");
                        factorRequest.setUnitCode("003");
                        factorRequest.setYearly(2021);
                        RetrofitClient.getInstance().getApi().getFactorBeans(factorRequest)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new BaseObserver<BaseResponse<List<FactorBean>>>() {
                                    @Override
                                    public void onSuccess(BaseResponse<List<FactorBean>> listBaseResponse) {
                                        List<FactorItemViewModel> factorItemViewModels = new ArrayList<>();
                                        for (FactorBean factorBean : listBaseResponse.getResult()) {
                                            factorItemViewModels.add(new FactorItemViewModel(factorBean.getIsSelect() != 0, factorBean.getFactorContent()));
                                        }

                                        if (approvingViewModel != null) {

                                            approvingViewModel.factorItemViewModels = factorItemViewModels;
                                        }
                                        adapter.setData(models);
                                    }

                                    @Override
                                    public void onFailure(Throwable e) {

                                    }
                                });


                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });


    }
}