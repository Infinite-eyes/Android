package com.databindingsample.wim.databindingsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.databindingsample.wim.databindingsample.databinding.ActivityLambdaBinding;
import com.databindingsample.wim.databindingsample.databinding.ActivityListBinding;
import com.databindingsample.wim.databindingsample.databinding.ActivitySimpleBinding;

/**
 * Created by cwm02 on 2017/2/22.
 */

public class LambdaActivity extends AppCompatActivity {

    private ActivityLambdaBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        mBinding.setUser(new User("chen","wim",false));
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter{
        public void onUserClick(User user){
            Toast.makeText(LambdaActivity.this, "onUserClick", Toast.LENGTH_SHORT).show();
        }
        public void onUserLongClick(User user, Context context){
            Toast.makeText(LambdaActivity.this,"onUserLongClick",Toast.LENGTH_SHORT).show();
        }
        public void onFocusChange(User user){
            Toast.makeText(LambdaActivity.this,"onFocusChange",Toast.LENGTH_SHORT).show();
        }
    }

}
