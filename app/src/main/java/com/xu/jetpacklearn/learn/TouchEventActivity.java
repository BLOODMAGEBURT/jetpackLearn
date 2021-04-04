package com.xu.jetpacklearn.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xu.jetpacklearn.R;

public class TouchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        Button hit = findViewById(R.id.btn_hit);
        Button too = findViewById(R.id.btn_too);


        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchEventActivity.this, "HIT HIT", Toast.LENGTH_SHORT).show();
            }
        });

        too.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchEventActivity.this, "TOOO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xu", "Activity dispatchTouchEvent----" + ev.getAction());


        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("xu", "Activity onTouchEvent----" + event.getAction());
        return super.onTouchEvent(event);
    }
}