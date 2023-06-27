package com.example.snake;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Obj {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm= new DisplayMetrics();

        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH=dm.widthPixels;
        Constants.SCREEN_HEIGHT=dm.heightPixels;
        setContentView(R.layout.activity_main);
        invokeDataProcessor();


    }
    private void invokeDataProcessor() {
        GameView dataProcessor = new GameView(this);
        dataProcessor.processData(this);// Aktivlikni tinglovchik sifatida uzating

    }

    @Override
    public void onDataReceived(int data) {
      //  Toast.makeText(this, "is"+data, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDataProcessed(int result) {
        Log.d("MainActivity", "Natija: " + result);

    }
}