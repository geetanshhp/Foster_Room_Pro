package com.example.geetanshsharma.foster_room;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected =null;
            switch (item.getItemId())
            {
                case R.id.home:
                    selected =new HomeFragment();
                    break;
                case R.id.search:
                    selected =new SearchFragment();
                    break;
                case R.id.saved:
                    selected =new Saved_Fragement();
                    break;
                case R.id.account:
                    selected =new Account_Fragment();
                    break;
                case R.id.booking:
                    selected =new Booking_Fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frames,selected).commit();
            return true;
        }
    };
}
