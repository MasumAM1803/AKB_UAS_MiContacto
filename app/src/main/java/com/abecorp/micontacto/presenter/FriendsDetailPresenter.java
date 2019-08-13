/*
Tanggal Pengerjaan : 07 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */
package com.abecorp.micontacto.presenter;

import android.content.Context;

import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.repo.FriendsRepository;
import com.abecorp.micontacto.view.FriendsDetailView;


public class FriendsDetailPresenter {

    private FriendsDetailView view;
    private FriendsRepository repo;

    public FriendsDetailPresenter(Context context, FriendsDetailView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getFriendsDetail(Friends fr) {
        view.showDetail(fr);
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void openFacebook(){
        view.actionFacebook();
    }

    public void removeFriend(Friends friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
