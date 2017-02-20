package com.databindingsample.wim.databindingsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cwm02 on 2017/2/20.
 */

public class UserAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;
    private List<User> mUserList;

    public interface OnItemClickListener{
        void onUserClick(User user);
    }

    public UserAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUserList = new ArrayList<>();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if(viewType == ITEM_VIEW_TYPE_ON){
            binding = DataBindingUtil.inflate(mLayoutInflater,R.layout.item_user,parent,false);
        }else{
            binding = DataBindingUtil.inflate(mLayoutInflater,R.layout.item_user_off,parent,false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        final User user = mUserList.get(position);
        if(user.isAdult.get()){
            return ITEM_VIEW_TYPE_ON;
        }else{
            return ITEM_VIEW_TYPE_OFF;
        }
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

        final User user = mUserList.get(position);
        holder.getBinding().setVariable(com.databindingsample.wim.databindingsample.BR.item,user);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mListener!=null) {
                    mListener.onUserClick(user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public void setListener(OnItemClickListener listener){
                mListener = listener;
    }

    public void addAll(List<User> users){
        mUserList.addAll(users);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(User user){
        int position = mRandom.nextInt(mUserList.size()+1);
        mUserList.add(user);
        notifyItemInserted(mUserList.size());
    }
    public void remove(){
        if(mUserList.size()==0){
            return;
        }
        int position = mRandom.nextInt(mUserList.size());
        mUserList.remove(0);
        notifyItemRemoved(0);
    }




}
