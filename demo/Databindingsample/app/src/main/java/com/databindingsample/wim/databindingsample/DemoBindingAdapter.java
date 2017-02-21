package com.databindingsample.wim.databindingsample;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by cwm02 on 2017/2/21.
 */

public class DemoBindingAdapter {

    @BindingAdapter({"app:imageUrl","app:placeholder"})
    public static void loadImageFromUrl(ImageView view, String url, Drawable drawable){

        Glide.with(view.getContext())
                .load(url)
                .placeholder(drawable)
                .into(view);

    }
}
