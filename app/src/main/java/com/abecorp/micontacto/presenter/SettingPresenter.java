/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.abecorp.micontacto.UserPreference;
import com.abecorp.micontacto.model.User;
import com.abecorp.micontacto.repo.UserRepository;
import com.abecorp.micontacto.view.SettingView;


public class SettingPresenter {

    private SettingView view;
    private UserRepository repo;
    private UserPreference prefs;

    public SettingPresenter(Context context, SettingView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }


    public void getUserData(LifecycleOwner owner) {
        String username = prefs.userLogin();
        String password = prefs.passwordLogin();

        repo.selectUser(username, password).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.showUser(user);
            }
        });
    }


    public void signOut() {
        prefs.setIsLogin(null, null);
        view.onSignOut();
    }

    public void aboutUs(){
        view.onAboutUs();
    }
}
