package com.xu.jetpacklearn.bindingadapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.xu.jetpacklearn.R;

/**
 * author : xujianbo
 * date : 2/19/21 5:17 PM
 * description :
 */
public class ImageViewBindingAdapter {
    @BindingAdapter(value = {"imageUrl", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String imageUrl, Drawable defaultImageResource) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
        } else {
            Picasso.get()
                    .load(R.drawable.ic_launcher_background)
                    .into(imageView);
        }
    }

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("mode")
    public static void setMode(TextView tv, String mode) {
        tv.setTextColor(tv.getContext().getResources().getColor(R.color.colorAccent));
    }
}
