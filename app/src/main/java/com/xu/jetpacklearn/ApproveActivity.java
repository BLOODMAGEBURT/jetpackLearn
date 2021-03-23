package com.xu.jetpacklearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.xu.jetpacklearn.adapter.NewsAdapter;
import com.xu.jetpacklearn.api.RetrofitClient;
import com.xu.jetpacklearn.base.BaseObserver;
import com.xu.jetpacklearn.base.BaseResponse;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.databinding.ActivityApproveBinding;
import com.xu.jetpacklearn.model.BasicInfo;
import com.xu.jetpacklearn.views.basicinfoview.BasicInfoViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ApproveActivity extends AppCompatActivity {
    private List<BaseViewModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_approve);

        ActivityApproveBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_approve);

        NewsAdapter newsAdapter = new NewsAdapter();
        binding.rvApprove.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvApprove.setAdapter(newsAdapter);


        netWork();


    }

    private void netWork() {
        // 获取基本信息
        RetrofitClient.getInstance().getApi().getBasicInfo("1372072907257245697")
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
                });

        // 获取支出事项
        RetrofitClient.getInstance().getApi().getExpense("1372072907257245697");



    }
}