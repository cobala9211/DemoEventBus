package com.example.nguyen.demoeventbus.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nguyen.demoeventbus.R;
import com.example.nguyen.demoeventbus.otto.SecondActivityOtto;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by NGUYEN on 1/27/2017.
 */

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    // declare variable event bus
    public static EventBus mEventBusDefault;
    public static EventBus mEventBusData;
    public static EventBus mEventBusFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_event);
        Button btnDemoActivity = (Button) findViewById(R.id.btnDemoActivity);
        btnDemoActivity.setOnClickListener(this);
        Button btnDemoFragment = (Button) findViewById(R.id.btnDemoFragment);
        btnDemoFragment.setOnClickListener(this);
        // create event bus
        mEventBusDefault = EventBus.getDefault();
        mEventBusData = EventBus.getDefault();
        mEventBusFragment = EventBus.getDefault();
    }

    @Override
    public void onStart() {
        super.onStart();
        // register event bus
        if (!EventBus.getDefault().isRegistered(this)) {
            mEventBusDefault.register(this);
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            mEventBusData.register(this);
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            mEventBusFragment.register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // unregister event bus
        mEventBusDefault.unregister(this);
        mEventBusData.unregister(this);
        mEventBusFragment.unregister(this);
    }

    @Subscribe
    public void onEvent(String data) {
        // data string from second activity
        Log.d("TAG12", "eventBusDefault: String main " + data);
    }

    @Subscribe
    public void onEvent(DataEvent data) {
        // data from second activity
        Log.d("TAG12", "onEvent: data main " + data.getTitle() + " count " + data.getCount());
    }

    @Subscribe
    public void onEventFragment(DataEventFragment data) {
        // data from fragment
        Log.d("TAG12", "onEventFragment: " + data.getTitle() + " description " + data.getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDemoActivity:
                initActivity(SecondActivityEvent.class);
                break;
            case R.id.btnDemoFragment:
                initFragment();
                break;
            default:
                throw new IllegalStateException("not found id of view");
        }
    }

    private void initActivity(Class className) {
        Intent intent = new Intent(EventActivity.this, className);
        this.startActivity(intent);
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutEvent, new EventFragment(), "eventFragment");
        transaction.commit();
    }
}
