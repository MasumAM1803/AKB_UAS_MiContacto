/*
Tanggal Pengerjaan : 07 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.presenter.FriendsDetailPresenter;
import com.abecorp.micontacto.view.FriendsDetailView;

import java.util.Objects;
import java.util.Random;



public class FriendsDetailActivity extends AppCompatActivity implements FriendsDetailView, View.OnClickListener {

    Toolbar toolbar;
    ImageView imgAva;
    TextView tvName, tvNIM, tvClass, tvUniv, tvPhone, tvEmail, tvIg, tvFacebook;
    FriendsDetailPresenter presenter;
    Friends friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detail);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        presenter = new FriendsDetailPresenter(this, this);
        friends = getIntent().getParcelableExtra("friend");
    }


    private void initView() {
        toolbar = findViewById(R.id.toolbarDetail);
        imgAva = findViewById(R.id.imgFriendAva);
        tvName = findViewById(R.id.tvFriendName);
        tvNIM = findViewById(R.id.tvFriendNIM);
        tvClass = findViewById(R.id.tvFriendClass);
        tvUniv = findViewById(R.id.tvFriendUniv);
        tvPhone = findViewById(R.id.tvFriendPhone);
        tvEmail = findViewById(R.id.tvFriendEmail);
        tvIg = findViewById(R.id.tvFriendIg);
        tvFacebook = findViewById(R.id.tvFriendFacebook);
    }


    private String data(String value) {
        String newValue = "N/A";
        if (!value.isEmpty()) newValue = value;

        return newValue;
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.getFriendsDetail(friends);
    }

    @Override
    public void showDetail(Friends fr) {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int i = ran.nextInt(ava.length);

        imgAva.setImageResource(ava[i]);

        tvName.setText(friends.getName());
        tvNIM.setText(friends.getNim());
        tvClass.setText(friends.getClass_());
        tvUniv.setText(friends.getUniv());
        tvPhone.setText(data(friends.getPhone()));
        tvEmail.setText(data(friends.getEmail()));
        tvIg.setText(data(friends.getIg()));
        tvFacebook.setText(friends.getFb());
    }

    @Override
    public void actionCall() {
        if (!friends.getPhone().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", friends.getPhone(), null));
            startActivity(i);
        }
    }

    @Override
    public void actionEmail() {
        if (!friends.getEmail().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + friends.getEmail()));
            startActivity(i);
        }
    }

    @Override
    public void actionInstagram() {
        if (!friends.getIg().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + friends.getIg().replace("@", "")));
            startActivity(i);
        }
    }

    @Override
    public void actionFacebook() {
        if (!friends.getIg().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/" + friends.getIg()));
            startActivity(i);
        }
    }

    @Override
    public void onFriendDeleted() {
        Toast.makeText(this, "Friend Deleted", Toast.LENGTH_SHORT).show();
        finish();
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
            case R.id.lytFacebook:
                presenter.openFacebook();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.nav_delete:
                presenter.removeFriend(friends);
                break;

            case R.id.nav_edit:
                Intent i = new Intent(FriendsDetailActivity.this, AddAndEditFriendsActivity.class);
                i.putExtra("type", 1);
                i.putExtra("friend", friends);
                startActivityForResult(i, 1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                friends = data.getParcelableExtra("newData");
            }
        }
    }
}
