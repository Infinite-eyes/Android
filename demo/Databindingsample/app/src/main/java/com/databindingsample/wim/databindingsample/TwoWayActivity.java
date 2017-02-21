package com.databindingsample.wim.databindingsample;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.databindingsample.wim.databindingsample.databinding.ActivityTwoWayBinding;

/**
 * Created by cwm02 on 2017/2/21.
 */

public class TwoWayActivity extends AppCompatActivity {

    ActivityTwoWayBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_two_way);
        mBinding.setModel(new FormModel("wim","123456"));

    }
}
