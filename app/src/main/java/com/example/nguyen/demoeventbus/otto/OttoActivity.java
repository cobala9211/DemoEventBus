package com.example.nguyen.demoeventbus.otto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nguyen.demoeventbus.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by NGUYEN on 1/27/2017.
 */

public class OttoActivity extends AppCompatActivity implements View.OnClickListener {
    // declare bus variable
    public static Bus mBusSendToMain;
    public static Bus mBusSendToMainSecond;
    public static Bus mBusSendFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_otto);
        Button btnSendToActivity = (Button) findViewById(R.id.btnSendActivity);
        btnSendToActivity.setOnClickListener(this);
        Button btnSendToFragment = (Button) findViewById(R.id.btnSendToFragment);
        btnSendToFragment.setOnClickListener(this);
        // create bus variable
        mBusSendToMain = new Bus(ThreadEnforcer.MAIN);
        mBusSendToMainSecond = new Bus(ThreadEnforcer.MAIN);
        mBusSendFragment = new Bus(ThreadEnforcer.MAIN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // register bus otto
        mBusSendToMain.register(this);
        mBusSendToMainSecond.register(this);
        mBusSendFragment.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregister bus otto
        mBusSendToMain.unregister(this);
        mBusSendToMainSecond.unregister(this);
        mBusSendFragment.unregister(this);
    }

    // method callback return data
    @Subscribe
    public void onEvent(DataOtto data) {
        Log.d("TAG11", "my data otto" + data.getTitle() + " count " + data.getCount());
    }

    // method callback return string
    @Subscribe
    public void onEventSecond(String data) {
        Log.d("TAG11", "my data otto back " + data);
    }

    // method callback return dataFragment
    @Subscribe
    public void onEventFragment(DataFragment data) {
        Log.d("TAG11", "onEventFragment back: " + data.getTitle() + " description " + data.getDescription());
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutOtto, new SecondFragment(), "SecondFragment");
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendActivity:
                initActivity(SecondActivityOtto.class);
                break;
            case R.id.btnSendToFragment:
                initFragment();
                break;
            default:
                throw new IllegalStateException("second fragment not found");
        }
    }

    private void initActivity(Class className) {
        Intent intent = new Intent(OttoActivity.this, className);
        this.startActivity(intent);
    }
}
