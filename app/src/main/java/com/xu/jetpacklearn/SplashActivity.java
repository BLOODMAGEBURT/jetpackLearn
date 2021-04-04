package com.xu.jetpacklearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xu.jetpacklearn.learn.HandlerLearnActivity;
import com.xu.jetpacklearn.learn.TouchEventActivity;
import com.xu.jetpacklearn.views.factor.FactorItemView;
import com.xu.jetpacklearn.views.factor.FactorItemViewModel;
import com.xu.jetpacklearn.views.factor.FactorView;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View togo = findViewById(R.id.tv_togo);

        togo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                startActivity(new Intent(SplashActivity.this, TouchEventActivity.class));
            }
        });


        FactorView fv = findViewById(R.id.fv);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.leftMargin = 2;

        List<FactorItemViewModel> factorItemViewModels = new ArrayList<>();

        FactorItemViewModel factorItemViewModel = new FactorItemViewModel(true, "处室-核对信息--冀志红测试");
        FactorItemViewModel factorItemViewModel1 = new FactorItemViewModel(false, "核对基本信息---冀志红");
        FactorItemViewModel factorItemViewModel2 = new FactorItemViewModel(false, "人事确认");
        FactorItemViewModel factorItemViewModel3 = new FactorItemViewModel(true, "认真审核");


        factorItemViewModels.add(factorItemViewModel);
        factorItemViewModels.add(factorItemViewModel1);
        factorItemViewModels.add(factorItemViewModel2);
        factorItemViewModels.add(factorItemViewModel3);

        fv.setFactorItemModels(factorItemViewModels);

    }

}