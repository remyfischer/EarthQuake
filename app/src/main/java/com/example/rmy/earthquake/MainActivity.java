package com.example.rmy.earthquake;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        if(networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(this, "Connexion établie",
                    Toast.LENGTH_LONG).show();
            TestAsyncTask testAsyncTask = new TestAsyncTask(MainActivity.this, "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_day.geojson");
            testAsyncTask.execute();

        } else {
            Toast.makeText(this, "Connexion non établie",
                    Toast.LENGTH_LONG).show();
        }
    }

}
