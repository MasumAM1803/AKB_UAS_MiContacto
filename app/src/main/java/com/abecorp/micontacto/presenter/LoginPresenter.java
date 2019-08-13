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
import android.widget.EditText;

import com.abecorp.micontacto.UserPreference;
import com.abecorp.micontacto.model.User;
import com.abecorp.micontacto.repo.UserRepository;
import com.abecorp.micontacto.view.LoginView;


public class LoginPresenter {

    private LoginView view;
    private UserRepository repo;
    private UserPreference prefs;

    public LoginPresenter(Context context, LoginView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void login(LifecycleOwner owner, final String username, final String pass) {
        repo.selectUser(username, pass).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    prefs.setIsLogin(username, pass);
                    view.loginSuccess();
                } else view.loginFail();
            }
        });
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

}
