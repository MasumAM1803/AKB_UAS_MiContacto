/*
Tanggal Pengerjaan : 07 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.repo.FriendsRepository;
import com.abecorp.micontacto.view.FriendsListView;

import java.util.List;


public class FriendsListPresenter {

    private FriendsRepository repo;
    private FriendsListView view;
    private LiveData<List<Friends>> allFriends;

    public FriendsListPresenter(Context context, FriendsListView view) {
        this.view = view;
        repo = new FriendsRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<Friends>>() {
            @Override
            public void onChanged(@Nullable List<Friends> friends) {
                view.showFriendsList(friends);
            }
        });
    }
}
