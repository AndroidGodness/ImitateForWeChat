package com.example.toluene.imitateforwechat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by toluene on 2016/11/26.
 */

public class SettingActivity extends Activity implements View.OnClickListener{
    private TextView exits_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_chat_content);
        exits_text = (TextView)findViewById(R.id.exits_text);
        exits_text.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.exits_text:

        }
    }
}
