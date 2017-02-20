package com.databindingsample.wim.databindingsample;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by cwm02 on 2017/2/20.
 */

public class BindingViewHolder <T extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding(){
        return mBinding;
    }


}
