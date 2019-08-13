package com.abecorp.micontacto.view;

import com.abecorp.micontacto.model.Friends;


public interface FriendsDetailView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void actionFacebook();
    void onFriendDeleted();
}
