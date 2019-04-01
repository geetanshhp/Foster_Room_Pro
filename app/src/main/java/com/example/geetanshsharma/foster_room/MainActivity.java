package com.example.geetanshsharma.foster_room;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.navigationview);
        drawerLayout =findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView=findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        Fragment selected =null;

        switch (item.getItemId())
        {
            case R.id.aabout_us:
                selected =new About_us();
                break;
            case R.id.id_get_help:
                selected =new Help_Frag();
                break;
            case R.id.id_notification:
                selected =new Notification_fragment();
                break;
            case R.id.feedback:
                selected =new Help_Frag();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frames,selected).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
