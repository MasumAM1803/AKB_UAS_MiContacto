/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.abecorp.micontacto.UserPreference;
import com.abecorp.micontacto.view.MainView;


public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) {
            view.toLogin();
        }
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
