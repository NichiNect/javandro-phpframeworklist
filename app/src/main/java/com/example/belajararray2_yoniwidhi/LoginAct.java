package com.example.belajararray2_yoniwidhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAct extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login to List PHP Framework");

        this.edtUsername = findViewById(R.id.username);
        this.edtPassword = findViewById(R.id.password);
        this.btnLogin = findViewById(R.id.btn_login);

        //instance SessionManager
        sessionManager = new SessionManager(getApplicationContext());

        if(sessionManager.getLogin()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            String inputUsername = edtUsername.getText().toString().trim();
            String inputPassword = edtPassword.getText().toString().trim();
            boolean isEmptyField = false;
            boolean isWrongUsername = false;
            boolean isWrongPassword = false;

            //Validasi username dan password
            if (!inputUsername.equals("yoniwidhi")) {
                isWrongUsername = true;
                edtUsername.setError("Username Salah!");
            } else {
                isWrongUsername = false;
            }
            if (!inputPassword.equals("widhi")) {
                isWrongPassword = true;
                edtPassword.setError("Password Salah!");
            } else {
                isWrongPassword = false;
            }

            //Validasi input kosong
            if (TextUtils.isEmpty(inputUsername)) {
                isEmptyField = true;
                this.edtUsername.setError("Username is required!");
            } else {
                isEmptyField = false;
            }
            if (TextUtils.isEmpty(inputPassword)) {
                isEmptyField = true;
                this.edtPassword.setError("Password is required");
            } else {
                isEmptyField = false;
            }

            if (!isEmptyField && !isWrongUsername && !isWrongPassword) {
                sessionManager.setLogin(true);
                sessionManager.setUsername(inputUsername);
                Intent isLogin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(isLogin);
            }

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu m) {
//        m.findItem(R.id.option2).setEnabled(false);
        if(this.sessionManager.getLogin() == false) {
            m.findItem(R.id.option1).setEnabled(false);
            m.findItem(R.id.option2).setEnabled(false);
            m.findItem(R.id.option3).setEnabled(false);
            m.findItem(R.id.btn_logout).setVisible(false);
        }
        m.findItem(R.id.btn_logout).setTitle("Logout (" + this.sessionManager.getUsername() + ")");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.option4:
                Intent i = new Intent(LoginAct.this, AboutMe.class);
                startActivity(i);
                break;
        }
        return true;
    }
}