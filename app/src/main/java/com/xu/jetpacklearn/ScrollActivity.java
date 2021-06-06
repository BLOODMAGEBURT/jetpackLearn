package com.xu.jetpacklearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.xu.jetpacklearn.adapter.ComFragmentAdapter;
import com.xu.jetpacklearn.databinding.ActivityScrollBinding;
import com.xu.jetpacklearn.fragment.ItemFragment;
import com.xu.jetpacklearn.fragment.TextViewFragment;
import com.xu.jetpacklearn.utils.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

public class ScrollActivity extends AppCompatActivity {

    private ActivityScrollBinding binding;
    int toolBarPositionY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scroll);

        binding.toolBar.post(new Runnable() {
            @Override
            public void run() {
                dealWithViewPager();
            }
        });


        binding.viewPager.setAdapter(new ComFragmentAdapter(getSupportFragmentManager(), getFragments()));

        binding.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int[] location = new int[2];
                binding.magicIndicator.getLocationOnScreen(location);
                int yPosition = location[1];

                if (yPosition < toolBarPositionY) {
                    binding.indicatorTitle.setVisibility(View.VISIBLE);
                    binding.scrollView.setNeedScroll(false);
                } else {
                    binding.indicatorTitle.setVisibility(View.GONE);
                    binding.scrollView.setNeedScroll(true);
                }

            }
        });

    }

    private void dealWithViewPager() {
        toolBarPositionY = binding.toolBar.getHeight();
        ViewGroup.LayoutParams params = binding.viewPager.getLayoutParams();
        params.height = ScreenUtil.getScreenHeightPx(getApplicationContext()) - toolBarPositionY - binding.magicIndicator.getHeight() + 1;
        binding.viewPager.setLayoutParams(params);
    }

    private List<Fragment> getFragments() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ItemFragment.newInstance(1));
        fragments.add(TextViewFragment.newInstance());
        return fragments;
    }
}