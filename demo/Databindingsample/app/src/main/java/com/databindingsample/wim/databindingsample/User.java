package com.databindingsample.wim.databindingsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;
import android.view.View;

/**
 * Created by cwm02 on 2017/2/20.
 */

public class User  extends BaseObservable{
    private  String firstName;
    private  String lastName;
    private String displayName;

    private String avatar;

    public ObservableArrayMap<String, String> user = new ObservableArrayMap<>();
    public ObservableBoolean isAdult=new ObservableBoolean();

    public User(String firstName,String lastName,boolean bool) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdult.set(bool);
        user.put("key1","value1");
        user.put("key2","value2");
        user.put("key3","value3");

    }



    public void setFirstName(String firstName){
        this.firstName = firstName;
        notifyPropertyChanged(com.databindingsample.wim.databindingsample.BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
//        notifyChange();
        notifyPropertyChanged(com.databindingsample.wim.databindingsample.BR.lastName);
    }
    @Bindable
    public String getFirstName() {
        return firstName;
    }
    @Bindable
    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return firstName + "" + lastName;
    }

    public void setAdult(boolean isAdult){
        this.isAdult.set(isAdult);
//        notifyChange();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
