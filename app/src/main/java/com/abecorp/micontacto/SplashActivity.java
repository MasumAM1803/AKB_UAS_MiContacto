/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.model.FriendsData;
import com.abecorp.micontacto.repo.FriendsRepository;


public class SplashActivity extends AppCompatActivity {

    FriendsRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        repo = new FriendsRepository(this);
        prefs = new UserPreference(this);

        //int SPLASH_TIME_OUT = 600;


        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Friends friends;
            for (String[] aData : FriendsData.initFriendsData) {
                friends = new Friends(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5], aData[6], aData[7]);
                repo.insertFriend(friends);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
