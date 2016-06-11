package com.example.vivek.assignment103;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("TAG:", "Activity start");

        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT) {
            Log.d("TAG:", "Portrait");
            ListFragment listFragment = new ListFragment();
            Log.d("TAG:", "Portait ListF");
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Log.d("TAG:", "Portrait Going to replace");
            fragmentTransaction.replace(R.id.singleFrame, listFragment);
            fragmentTransaction.commit();
        }
        else if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("TAG:", "Landscape");
            ListFragment listFragment = new ListFragment();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.listFrame, listFragment);

            CircleFragment circleFragment = new CircleFragment();
            fragmentTransaction.replace(R.id.detailFrame, circleFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {

        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT) {
            Log.d("TAG:", "Portrait");
            ListFragment listFragment = new ListFragment();
            Log.d("TAG:", "Portait ListF");
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Log.d("TAG:", "Portrait Going to replace");
            fragmentTransaction.replace(R.id.singleFrame, listFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
