/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */
package com.abecorp.micontacto.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.abecorp.micontacto.presenter.ContactPresenter;
import com.abecorp.micontacto.view.ContactView;
import com.abecorp.micontacto.R;


public class ContactFragment extends Fragment implements ContactView, View.OnClickListener {

    RelativeLayout lytPhone, lytEmail, lytIG, lytTwitter, lytFacebook;
    ContactPresenter presenter;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        lytPhone = view.findViewById(R.id.lytPhone);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);
        lytTwitter = view.findViewById(R.id.lytTwitter);
        lytFacebook = view.findViewById(R.id.lytFacebook);

        lytPhone.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);
        lytTwitter.setOnClickListener(this);
        lytFacebook.setOnClickListener(this);

        presenter = new ContactPresenter(this);

        return view;
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","6281313873670", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s={"child.masum@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT,"I Need Your Help");
        i.putExtra(Intent.EXTRA_TEXT,"Hi Ma'sum, Can You help Me. This is important");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Send Email");
        startActivity(chooser);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/abdulgallery/"));
        startActivity(i);
    }

    @Override
    public void actionTwitter() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ShinNear18"));
        startActivity(i);
    }

    @Override
    public void actionFacebook(){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nam.shin.921"));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
            case R.id.lytTwitter:
                presenter.openTwitter();
                break;
            case R.id.lytFacebook:
                presenter.openFacebook();
                break;
        }
    }
}
