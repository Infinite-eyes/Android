package com.databindingsample.wim.databindingsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by cwm02 on 2017/2/21.
 */

public class FormModel extends BaseObservable{

    private String mName;

    private String mPassword;

    public FormModel(String name, String password) {
        this.mName = name;
        this.mPassword = password;
    }
    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
        notifyPropertyChanged(com.databindingsample.wim.databindingsample.BR.name);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
        notifyPropertyChanged(com.databindingsample.wim.databindingsample.BR.password);
    }
}
