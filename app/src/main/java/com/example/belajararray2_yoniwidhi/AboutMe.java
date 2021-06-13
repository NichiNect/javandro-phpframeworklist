package com.example.belajararray2_yoniwidhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutMe extends AppCompatActivity {
    SessionManager sessionManager;
    MainActivity mainActivity;
    String title = "Belajar Array";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        this.sessionManager = new SessionManager(getApplicationContext());
        getSupportActionBar().setTitle("About Me");

        this.mainActivity = new MainActivity();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu m) {
        m.findItem(R.id.option1).setVisible(false);
        m.findItem(R.id.option2).setVisible(false);
        m.findItem(R.id.option3).setEnabled(false);
        if(this.sessionManager.getLogin() == false) {
            // tidak login (guest)
            m.findItem(R.id.option3).setTitle("Main Menu");
            m.findItem(R.id.option4).setTitle("Login");
            m.findItem(R.id.btn_logout).setVisible(false);
        } else {
            // telah login (auth)
            m.findItem(R.id.option3).setVisible(false);
            m.findItem(R.id.option4).setTitle("Main Menu");
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
//            case R.id.option1:
//                this.title = "Array Adapter - Yoni Widhi";
//                startActivity(new Intent(AboutMe.this, MainActivity.class));
//                break;
//            case R.id.option2:
//                this.title = "Gambar Adapter - Yoni Widhi";
//                mainActivity.showGambarAdapter();
//                startActivity(new Intent(AboutMe.this, MainActivity.class));
//                break;
//            case R.id.option3:
//                this.title = "Card Adapter - Yoni Widhi";
//                break;
            case R.id.option4:
                Intent i = new Intent(AboutMe.this, LoginAct.class);
                startActivity(i);
                break;
            case R.id.btn_logout:
                sessionManager.setLogin(false);
                sessionManager.setUsername("");
                startActivity(new Intent(getApplicationContext(), LoginAct.class));
        }
        setActionBarTitle(this.title);
        return true;
    }

    private void setActionBarTitle(String judul) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(judul);
        }
    }
}