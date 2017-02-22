package com.databindingsample.wim.databindingsample;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.TransitionRes;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.databindingsample.wim.databindingsample.databinding.ActivityAnimationBinding;

/**
 * Created by cwm02 on 2017/2/22.
 */

public class AnimationActivity extends AppCompatActivity {

    ActivityAnimationBinding  mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_animation);
        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup view = (ViewGroup) binding.getRoot();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(view);
                }
                return true;
            }
        });



        mBinding.setPresenter(new Presenter());
    }

        public class  Presenter{
            public void onCheckedChanged(View buttonView, boolean isChecked){
                mBinding.setShowImage(isChecked);
            }
        }

}
