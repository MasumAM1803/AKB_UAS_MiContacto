package com.abecorp.micontacto.view;

import android.widget.EditText;

import com.abecorp.micontacto.model.Friends;



public interface AddAndEditFriendsView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
