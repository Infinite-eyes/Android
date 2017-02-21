package com.databindingsample.wim.databindingsample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.databindingsample.wim.databindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setPresenter(new Presenter());
    }

    public class Presenter{
        public void onClick(View view){
            Intent intent;
            switch (view.getId()){
                case R.id.btn_simple:
                    intent  = new Intent(MainActivity.this,SimpleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_list:
                    intent  = new Intent(MainActivity.this,ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_expression:
                    intent  = new Intent(MainActivity.this,ExpressionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_twoway:
                    intent  = new Intent(MainActivity.this,TwoWayActivity.class);
                    startActivity(intent);
                    break;

            }
        }

    }



}
