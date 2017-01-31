package com.example.nguyen.demoeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nguyen.demoeventbus.event.EventActivity;
import com.example.nguyen.demoeventbus.otto.OttoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDemoEventBus = (Button) findViewById(R.id.btnDemoEventBus);
        btnDemoEventBus.setOnClickListener(this);
        Button btnDemoOtto = (Button) findViewById(R.id.btnDemoOtto);
        btnDemoOtto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDemoEventBus:
                initActivity(EventActivity.class);
                break;
            case R.id.btnDemoOtto:
                initActivity(OttoActivity.class);
                break;
            default:
                break;
        }
    }

    private void initActivity(Class className) {
        Intent intent = new Intent(MainActivity.this, className);
        this.startActivity(intent);
    }
}
