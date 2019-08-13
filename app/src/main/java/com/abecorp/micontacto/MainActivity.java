/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.abecorp.micontacto.fragment.ContactFragment;
import com.abecorp.micontacto.fragment.FriendsListFragment;
import com.abecorp.micontacto.fragment.ProfileFragment;
import com.abecorp.micontacto.fragment.SettingFragment;
import com.abecorp.micontacto.presenter.MainPresenter;
import com.abecorp.micontacto.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    FragmentManager fm = getSupportFragmentManager();
    final Fragment profil = new ProfileFragment();
    final Fragment contact = new ContactFragment();
    final Fragment friendlist = new FriendsListFragment();
    final Fragment setting  = new SettingFragment();
    Fragment active = profil;
    Fragment[] fragment = {setting, friendlist, contact, profil};


    @Override
    public void showView(Fragment fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit();
        active = fragment;
    }

    @Override
    public void addView() {
        for (int i = 0; i<4; i++) {
            fm.beginTransaction().add(R.id.content, fragment[i]).hide(fragment[i]).commit();
        }
    }

    @Override
    public void toLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    presenter.changeView(profil);
                    return true;
                case R.id.navigation_mycontact:
                    presenter.changeView(contact);
                    return true;
                case R.id.navigation_friend_list:
                    presenter.changeView(friendlist);
                    return true;
                case R.id.navigation_setting:
                    presenter.changeView(setting);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenter = new MainPresenter(this,this);
        presenter.isLogin();
        presenter.addView();
        presenter.changeView(profil);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
