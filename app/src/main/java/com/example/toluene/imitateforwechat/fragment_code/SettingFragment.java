package com.example.toluene.imitateforwechat.fragment_code;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.toluene.imitateforwechat.R;
import com.example.toluene.imitateforwechat.SettingActivity;

/**
 * Created by toluene on 2016/11/15.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{
    private LinearLayout setting_chat;
    View settingLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        settingLayout = inflater.inflate(R.layout.setting_layout,container,false);
        initLineView();
        registerView();
        return settingLayout;
    }

    private void registerView() {
        setting_chat.setOnClickListener(this);

    }

    private void initLineView() {
        setting_chat = (LinearLayout)settingLayout.findViewById(R.id.setting_chat);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.setting_chat:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);


        }
    }
}
