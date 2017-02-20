package com.databindingsample.wim.databindingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.databindingsample.wim.databindingsample.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwm02 on 2017/2/20.
 */

public class ListActivity extends AppCompatActivity {

    ActivityListBinding mBinding;
    UserAdapter mUserAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        mBinding.setPresenter(new Presenter());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserAdapter = new UserAdapter(this);
        mBinding.recyclerView.setAdapter(mUserAdapter);
        mUserAdapter.setListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onUserClick(User user) {
                Toast.makeText(ListActivity.this,user.getFirstName(),Toast.LENGTH_SHORT).show();
            }
        });
        List<User> demoList = new ArrayList<>();
        demoList.add(new User("first_name1","last_name1",false));
        demoList.add(new User("first_name2","last_name2",true));
        demoList.add(new User("first_name3","last_name3",false));
        mUserAdapter.addAll(demoList);

    }

    public class Presenter{

        public void OnClickAddItem(View view){
            mUserAdapter.add(new User("haha","1",false));
        }
        public void onClickRemoveItem(View view){
            mUserAdapter.remove();
        }
    }


}
