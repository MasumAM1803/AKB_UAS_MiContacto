/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.abecorp.micontacto.AboutActivity;
import com.abecorp.micontacto.MainActivity;
import com.abecorp.micontacto.R;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    /*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.viewpager_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                // do stuff
                Intent i = new Intent(getContext(), AboutActivity.class);
                startActivity(i);
                return true;
        }

        return false;
    }
    */
}
