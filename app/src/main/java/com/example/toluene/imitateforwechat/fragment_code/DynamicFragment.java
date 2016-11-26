package com.example.toluene.imitateforwechat.fragment_code;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.toluene.imitateforwechat.R;

/**
 * Created by toluene on 2016/11/15.
 */

public class DynamicFragment extends Fragment implements View.OnClickListener{

    View dynamicLayout;
    private LinearLayout line_friend;
    private LinearLayout line_one_sweep;
    private LinearLayout line_shake;
    private LinearLayout line_nearby;
    private LinearLayout line_drift_bottle;
    private LinearLayout line_shopping;
    private LinearLayout line_game;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dynamicLayout = inflater.inflate(R.layout.dynamic_layout,container,false);
        initLinearLayout();
        registerLineClick();
        return dynamicLayout;

    }

    private void initLinearLayout() {
        line_friend = (LinearLayout)dynamicLayout.findViewById(R.id.line_friend);
        line_one_sweep = (LinearLayout)dynamicLayout.findViewById(R.id.line_oneSweep);
        line_shake = (LinearLayout)dynamicLayout.findViewById(R.id.line_shake);
        line_nearby = (LinearLayout)dynamicLayout.findViewById(R.id.line_nearby);
        line_drift_bottle = (LinearLayout)dynamicLayout.findViewById(R.id.line_drift_bottle);
        line_shopping = (LinearLayout)dynamicLayout.findViewById(R.id.line_shopping);
        line_game = (LinearLayout)dynamicLayout.findViewById(R.id.line_game);

    }

    public void registerLineClick(){
        line_friend.setOnClickListener(this);
        line_one_sweep.setOnClickListener(this);
        line_shake.setOnClickListener(this);
        line_nearby.setOnClickListener(this);
        line_drift_bottle.setOnClickListener(this);
        line_shopping.setOnClickListener(this);
        line_game.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.line_friend:
                Toast.makeText(getActivity(),"点击添加朋友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.line_oneSweep:
                //TODO
                break;
            case R.id.line_shake:
                //TODO
                break;
            case R.id.line_nearby:
                //TODO
                break;
            case R.id.line_drift_bottle:
                //TODO
                break;
            case R.id.line_shopping:
                //TODO
                break;
            case R.id.line_game:
                //TODO
                break;
            default:
                break;
        }
    }
}
