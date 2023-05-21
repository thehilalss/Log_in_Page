package com.example.hilalloginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView mBottomBar;

    private MovieFragment movieFragment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mBottomBar = (BottomNavigationView) findViewById(R.id.home_activity_bottomNavigationView);
        movieFragment = new MovieFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();

        setFragment(movieFragment);

        mBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottombar_menu_movie:
                        setFragment(movieFragment);
                        return true;

                    case R.id.bottombar_menu_search:
                        setFragment(searchFragment);
                        return true;

                    case R.id.bottombar_menu_profile:
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_activity_framelayout,fragment);
        transaction.commit();
    }
}