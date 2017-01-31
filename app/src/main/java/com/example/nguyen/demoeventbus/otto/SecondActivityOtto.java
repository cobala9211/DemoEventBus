package com.example.nguyen.demoeventbus.otto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nguyen.demoeventbus.R;

/**
 * Created by NGUYEN on 1/27/2017.
 */

public class SecondActivityOtto extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_otto);
        Button btnSendToMain = (Button) findViewById(R.id.btnMainOtto);
        btnSendToMain.setOnClickListener(this);
        Button btnSendData = (Button) findViewById(R.id.btnMainOttoData);
        btnSendData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMainOtto:
                // post data to callback Activity
                OttoActivity.mBusSendToMain.post(new DataOtto("title", 10));
                finish();
                break;
            case R.id.btnMainOttoData:
                // post string to callback Activity
                OttoActivity.mBusSendToMainSecond.post("new String data");
                finish();
                break;
            default:
                throw new IllegalStateException("not found id view");
        }
    }
}
