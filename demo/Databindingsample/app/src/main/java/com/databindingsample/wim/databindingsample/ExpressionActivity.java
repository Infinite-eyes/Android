package com.databindingsample.wim.databindingsample;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.databindingsample.wim.databindingsample.databinding.ActivityExpressionBinding;

/**
 * Created by cwm02 on 2017/2/21.
 */

public class ExpressionActivity  extends AppCompatActivity{

    ActivityExpressionBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = new User("firstname","lastname",false);
        user.setAvatar("https://avatars2.githubusercontent.com/u/17283337?v=3&s=460");
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_expression);
        mBinding.setUser(user);
    }
}
