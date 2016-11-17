package com.example.toluene.imitateforwechat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toluene.imitateforwechat.fragment_code.ContactFragment;
import com.example.toluene.imitateforwechat.fragment_code.DynamicFragment;
import com.example.toluene.imitateforwechat.fragment_code.NewsFragment;
import com.example.toluene.imitateforwechat.fragment_code.SettingFragment;

public class MainActivity extends Activity implements View.OnClickListener {

    private ContactFragment contactFragment;  //用于展示联系人的Fragment
    private DynamicFragment dynamicFragment;  //用于展示动态的Fragment
    private NewsFragment newsFragment;   //用于展示消息的Fragment
    private SettingFragment settingFragment; //用于展示设置的Fragment

    private View contactLayout;
    private View dynamicLayout;
    private View newsLayout;
    private View settingLayout;

    private ImageView contactImage;
    private ImageView dynamicImage;
    private ImageView newsImage;
    private ImageView settingImage;

    private TextView contactText;
    private TextView dynamicText;
    private TextView newsText;
    private TextView settingText;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getFragmentManager();
        setTabSelected(0);
    }

    private void initView() {
        contactImage = (ImageView)findViewById(R.id.contact_Image);
        dynamicImage = (ImageView)findViewById(R.id.dynamic_Image);
        newsImage = (ImageView)findViewById(R.id.news_Image);
        settingImage = (ImageView)findViewById(R.id.setting_Image);

        contactText = (TextView)findViewById(R.id.contact_Text);
        dynamicText = (TextView)findViewById(R.id.dynamic_Text);
        newsText = (TextView)findViewById(R.id.news_Text);
        settingText = (TextView)findViewById(R.id.setting_Text);

        contactLayout =findViewById(R.id.contact_Layout);
        dynamicLayout = findViewById(R.id.dynamic_Layout);
        newsLayout = findViewById(R.id.news_Layout);
        settingLayout = findViewById(R.id.setting_Layout);

        newsLayout.setOnClickListener(this);
        dynamicLayout.setOnClickListener(this);
        contactLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.news_Layout:
                //消息布局
                setTabSelected(0);
                break;
            case R.id.dynamic_Layout:
                //动态布局
                setTabSelected(1);
                break;
            case R.id.contact_Layout:
                //联系人布局
                setTabSelected(2);
                break;
            case R.id.setting_Layout:
                //设置布局
                setTabSelected(3);
                break;
            default:
                break;
        }
    }

    private void setTabSelected(int index) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
            newsImage.setImageResource(R.drawable.news_selected);
            newsText.setTextColor(Color.WHITE);
                if (newsFragment == null){
                    newsFragment =  new NewsFragment();
                    transaction.add(R.id.content_frame,newsFragment);
                }else {
                    transaction.show(newsFragment);
                }
                break;
            case 1:
                dynamicImage.setImageResource(R.drawable.dynamic_selected);
                dynamicText.setTextColor(Color.WHITE);
                if (dynamicFragment == null){
                    dynamicFragment = new DynamicFragment();
                    transaction.add(R.id.content_frame,dynamicFragment);
                }else {
                    transaction.show(dynamicFragment);
                }
                break;
            case 2:
                contactImage.setImageResource(R.drawable.contact_selected);
                contactText.setTextColor(Color.WHITE);
                if (contactFragment == null){
                    contactFragment = new ContactFragment();
                    transaction.add(R.id.content_frame,contactFragment);
                }else{
                transaction.show(contactFragment);
            }
                break;
            case 3:
                default:
                    settingImage.setImageResource(R.drawable.setting_selected);
                    settingText.setTextColor(Color.WHITE);
                    if (settingFragment == null){
                        settingFragment = new SettingFragment();
                        transaction.add(R.id.content_frame,settingFragment);
                    }else{
                        transaction.show(settingFragment);
                    }
                    break;
        }
        transaction.commit();

    }

    private void clearSelection() {
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        dynamicImage.setImageResource(R.drawable.dynamic_unselected);
        dynamicText.setTextColor(Color.parseColor("#82858b"));
        contactImage.setImageResource(R.drawable.contact_unselected);
        contactText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (newsFragment != null){
            transaction.hide(newsFragment);
        }
        if (dynamicFragment != null){
            transaction.hide(dynamicFragment);
        }
        if (contactFragment != null){
            transaction.hide(contactFragment);
        }
        if (settingFragment != null){
            transaction.hide(settingFragment);
        }
    }

}
