package com.justin.practice;

import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView guess;
    private ImageView smile;
    private ImageView wrong;
    int counter =0;
    private int secret;
    private ImageView result;
    String TAG =MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        guess = findViewById(R.id.number);
        secret = new Random().nextInt(10)+1;
        result = findViewById(R.id.smile);
        setSupportActionBar(toolbar);
        Log.d(TAG,"secret: "+secret);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                guess.setText(Integer.toString(counter));
                result.setAlpha(1.0f);
                result.setVisibility(View.VISIBLE);
                if (secret ==counter ){
                    result.setImageResource(R.drawable.wrong);
                }
                else
                    result.setImageResource(R.drawable.smile);
                result.animate().alpha(0.0f).setDuration(1200);
            }
        });
    }
    public void reset(View view){
        counter=0;
        guess.setText(Integer.toString(counter));
        secret=new Random().nextInt(10)+1;
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
