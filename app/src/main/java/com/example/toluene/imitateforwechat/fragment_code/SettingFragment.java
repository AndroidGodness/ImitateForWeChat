package com.example.toluene.imitateforwechat.fragment_code;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toluene.imitateforwechat.R;

/**
 * Created by toluene on 2016/11/15.
 */

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.setting_layout,container,false);
        return settingLayout;
    }
}
