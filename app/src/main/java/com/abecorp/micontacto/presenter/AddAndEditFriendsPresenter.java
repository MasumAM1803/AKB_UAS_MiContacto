/*
Tanggal Pengerjaan : 10 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */
package com.abecorp.micontacto.presenter;

import android.content.Context;
import android.widget.EditText;

import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.repo.FriendsRepository;
import com.abecorp.micontacto.view.AddAndEditFriendsView;


public class AddAndEditFriendsPresenter {

    private FriendsRepository repo;
    private AddAndEditFriendsView view;

    public AddAndEditFriendsPresenter(Context context, AddAndEditFriendsView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(Friends friend) {
        try {
            repo.insertFriend(friend);
            view.onFriendAdded();
        } catch (Exception ex) {
            view.showFailed("Failed to add friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void updateFriend(Friends friend) {
        try {
            repo.updateFriend(friend);
            view.onFriendUpdated(friend);
        } catch (Exception ex) {
            view.showFailed("Failed to update friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
