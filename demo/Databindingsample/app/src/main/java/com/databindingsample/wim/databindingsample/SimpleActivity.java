package com.databindingsample.wim.databindingsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.databindingsample.wim.databindingsample.databinding.ActivitySimpleBinding;

public class SimpleActivity extends AppCompatActivity {

    User user = new User("chen","wim",false);
    ActivitySimpleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simple);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_simple);
//        binding.firstName.setText(user.getFirstName());
//        binding.lastName.setText(user.getLastName());

        binding.setUser(user);
//        binding.setVariable(com.databindingsample.wim.databindingsample.BR.user,user);

        binding.setPresenter(new Presenter());
        binding.viewStub.getViewStub().inflate();

    }
    public class Presenter{
        public  void onTextChanged(CharSequence s, int start, int before, int count){
            user.setFirstName(s.toString());
            user.setFired(!user.isAdult.get());
//          binding.setUser(user);
        }
        public void onClick(View view){
            Toast.makeText(SimpleActivity.this,"点到了",Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(User user){
            Toast.makeText(SimpleActivity.this,user.getLastName(),Toast.LENGTH_SHORT).show();
        }

    }
}
