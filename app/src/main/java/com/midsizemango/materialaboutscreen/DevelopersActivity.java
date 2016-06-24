package com.midsizemango.materialaboutscreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Prasad Shirvandkar on 24/06/16.
 */
 
public class DevelopersActivity extends AppCompatActivity implements View.OnClickListener{
    
    Button buttongp1, buttongp2, buttongp3, buttong1, buttong2, buttong3, buttona1, buttona2, buttona3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        toolbar = (Toolbar) findViewById(R.id.toolbar_about1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        buttongp1 = (Button) findViewById(R.id.buttongp1);
        buttongp2 = (Button) findViewById(R.id.buttongp2);
        buttongp3 = (Button) findViewById(R.id.buttongp3);
        buttong1 = (Button) findViewById(R.id.buttong1);
        buttong2 = (Button) findViewById(R.id.buttong2);
        buttong3 = (Button) findViewById(R.id.buttong3);
        buttona1 = (Button) findViewById(R.id.buttona1);
        buttona2 = (Button) findViewById(R.id.buttona2);
        buttona3 = (Button) findViewById(R.id.buttona3);

        buttongp1.setOnClickListener(this);
        buttongp2.setOnClickListener(this);
        buttongp3.setOnClickListener(this);
        buttong1.setOnClickListener(this);
        buttong2.setOnClickListener(this);
        buttong3.setOnClickListener(this);
        buttona1.setOnClickListener(this);
        buttona2.setOnClickListener(this);
        buttona3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId()){

            //You can Delete any of the button by deleting layouts

            //Google Plus Link for First Card
            case R.id.buttongp1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com")));
                break;

            //Google Plus Link for Second Card
            case R.id.buttongp2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com")));
                break;

            //Google Plus Link for Third Card
            case R.id.buttongp3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com")));
                break;

            //Github Link for First Card
            case R.id.buttong1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com")));
                break;

            //Github Link for Second Card
            case R.id.buttong2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com")));
                break;

            //Github Link for Third Card
            case R.id.buttong3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com")));
                break;

            //MyApps Link for First Card
            case R.id.buttona1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com")));
                break;

            //MyApps Link for Second Card
            case R.id.buttona2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com")));
                break;

            //MyApps Link for Third Card
            case R.id.buttona3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com")));
                break;
            
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
