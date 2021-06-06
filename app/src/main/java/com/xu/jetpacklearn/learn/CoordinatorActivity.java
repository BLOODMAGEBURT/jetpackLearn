package com.xu.jetpacklearn.learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cordinator);


        RecyclerView rv = findViewById(R.id.recyclerview);
        AppBarLayout appbar = findViewById(R.id.appbar);

        rv.setLayoutManager(new LinearLayoutManager(this));

        String[] arrayName = {"孙悟空", "牛魔王", "猪八戒", "哪吒", "江流儿"};
        String[] arrayNames = {};

        CustomAdapter customAdapter = new CustomAdapter(arrayName);

        rv.setAdapter(customAdapter);

        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)appbar.getChildAt(1).getLayoutParams();

        layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL);
    }
}