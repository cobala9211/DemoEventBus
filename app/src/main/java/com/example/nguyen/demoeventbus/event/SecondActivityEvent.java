package com.example.nguyen.demoeventbus.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nguyen.demoeventbus.R;

/**
 * Created by NGUYEN on 1/31/2017.
 */

public class SecondActivityEvent extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_event_second);
        Button btnSendToData = (Button) findViewById(R.id.btnSendData);
        btnSendToData.setOnClickListener(this);
        Button btnSendDataDefault = (Button) findViewById(R.id.btnSendDataDefault);
        btnSendDataDefault.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendData:
                //post data to main event
                EventActivity.mEventBusData.post(new DataEvent("title data", 10));
                finish();
                break;
            case R.id.btnSendDataDefault:
                //post data default to main event
                EventActivity.mEventBusDefault.post("send data string to main event bus");
                finish();
                break;
            default:
                throw new IllegalStateException("not found id of view");
        }
    }
}
