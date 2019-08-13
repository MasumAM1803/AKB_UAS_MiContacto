/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abecorp.micontacto.presenter.LoginPresenter;
import com.abecorp.micontacto.view.LoginView;


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    LoginPresenter presenter;
    EditText etUsername, etPassword;
    TextView tvWrong, tvSignUp;
    Button btnLogin;

    @Override
    public void loginSuccess() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void loginFail() {
        tvWrong.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        presenter = new LoginPresenter(this, this);
        btnLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) login();
        else if (v.getId() == R.id.tvSignUp) {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvWrong = findViewById(R.id.tvWrong);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
    }

    private void login() {
        if (!etUsername.getText().toString().isEmpty()) {
            if (!etPassword.getText().toString().isEmpty()){

                presenter.login(this, etUsername.getText().toString(), etPassword.getText().toString());

            } else presenter.setError(etPassword);
        } else presenter.setError(etUsername);
    }
}
