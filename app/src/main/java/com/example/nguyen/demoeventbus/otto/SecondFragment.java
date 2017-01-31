package com.example.nguyen.demoeventbus.otto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nguyen.demoeventbus.R;

/**
 * Created by NGUYEN on 1/30/2017.
 */

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_otto, container, false);
        Button btnSendToMain = (Button) view.findViewById(R.id.btnSendDataToMain);
        btnSendToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OttoActivity.mBusSendFragment.post(new DataFragment("title fragment", "description fragment"));
            }
        });
        return view;
    }
}
