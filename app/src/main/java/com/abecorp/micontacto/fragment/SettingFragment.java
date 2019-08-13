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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abecorp.micontacto.AboutActivity;
import com.abecorp.micontacto.MainActivity;
import com.abecorp.micontacto.R;
import com.abecorp.micontacto.model.User;
import com.abecorp.micontacto.presenter.SettingPresenter;
import com.abecorp.micontacto.view.SettingView;

import java.util.Objects;

public class SettingFragment extends Fragment implements SettingView {

    SettingPresenter presenter;
    TextView tvUser;
    Button btnSignOut, btnAboutUs;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void showUser(User user) {
        String username = user.getNane() + " (" + user.getUsername() +")";
        tvUser.setText(username);
    }

    @Override
    public void onSignOut() {
        Intent i = new Intent(getContext(), MainActivity.class);
        startActivity(i);
        Toast.makeText(getContext(), "Signed Out", Toast.LENGTH_SHORT).show();
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public void onAboutUs() {
        Intent about = new Intent(getContext(), AboutActivity.class);
        startActivity(about);
        //Objects.requireNonNull(getActivity()).finish();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        tvUser = view.findViewById(R.id.tvUser);
        btnSignOut = view.findViewById(R.id.btnSignOut);
        btnAboutUs = view.findViewById(R.id.btnAboutUs);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new SettingPresenter(getContext(), this);
        presenter.getUserData(this);



        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signOut();
            }
        });


        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.aboutUs();
            }
        });
    }
}
