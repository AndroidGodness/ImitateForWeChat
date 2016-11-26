package com.example.toluene.imitateforwechat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toluene.imitateforwechat.fragment_code.ContactFragment;
import com.example.toluene.imitateforwechat.fragment_code.DynamicFragment;
import com.example.toluene.imitateforwechat.fragment_code.NewsFragment;
import com.example.toluene.imitateforwechat.fragment_code.SettingFragment;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imageView_add;
    private ImageView imageView_search;
    private PopupMenu popupMenu;

    private ContactFragment contactFragment;  //用于展示联系人的Fragment
    private DynamicFragment dynamicFragment;  //用于展示动态的Fragment
    private NewsFragment newsFragment;   //用于展示消息的Fragment
    private SettingFragment settingFragment; //用于展示设置的Fragment

    protected View contactLayout;    //activity_main中联系人布局id
    protected View dynamicLayout;    //activity_main中动态布局id
    protected View newsLayout;       //activity_main中消息布局id
    protected View settingLayout;    //activity_main中设置布局id
    protected View main_bottom_navigate;

    private ImageView contactImage;  //联系人图片id
    private ImageView dynamicImage;  //动态图片id
    private ImageView newsImage;     //消息图片id
    private ImageView settingImage;  //设置图片id

    private TextView contactText;    //联系人文本
    private TextView dynamicText;    //动态文本
    private TextView newsText;       //消息文本
    private TextView settingText;    //设置文本

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getFragmentManager();
        setTabSelected(0);
        dynamicFragment = (DynamicFragment)getFragmentManager().findFragmentById(R.id.line_friend);

    }


    private void initView() {
        //图片
        newsImage = (ImageView)findViewById(R.id.news_Image);
        dynamicImage = (ImageView)findViewById(R.id.dynamic_Image);
        contactImage = (ImageView)findViewById(R.id.contact_Image);
        settingImage = (ImageView)findViewById(R.id.setting_Image);

        //文本
        newsText = (TextView)findViewById(R.id.news_Text);
        dynamicText = (TextView)findViewById(R.id.dynamic_Text);
        contactText = (TextView)findViewById(R.id.contact_Text);
        settingText = (TextView)findViewById(R.id.setting_Text);

        //布局
        newsLayout = findViewById(R.id.news_Layout);
        dynamicLayout = findViewById(R.id.dynamic_Layout);
        contactLayout =findViewById(R.id.contact_Layout);
        settingLayout = findViewById(R.id.setting_Layout);

        main_bottom_navigate = findViewById(R.id.main_bottom_navigate);

        //注册布局监听器
        newsLayout.setOnClickListener(this);
        dynamicLayout.setOnClickListener(this);
        contactLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

        //顶部两个ImageVIew
        imageView_add = (ImageView)findViewById(R.id.imageView_add);
        imageView_search = (ImageView)findViewById(R.id.imageView_search);

        imageView_search.setOnClickListener(this);
        imageView_add.setOnClickListener(this);




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
            case R.id.imageView_add:
                createPopupMenu(imageView_add);
                break;
            default:
                break;
        }
    }

    private void createPopupMenu(View image) {
       popupMenu = new PopupMenu(this,imageView_add);
        getMenuInflater().inflate(R.menu.image_add,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.add_friend:
                        //TODO
                        break;
                    case R.id.begin_chat:
                        //TODO
                        break;
                    case R.id.one_sweep:
                        //TODO
                        break;
                    case R.id.collect_money:
                        //TODO
                        break;
                    case R.id.help_feedback:
                        //TODO
                        Toast.makeText(getApplicationContext(),"帮助",Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });
        popupMenu.show();
    }

    private void setTabSelected(int index) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
            newsImage.setImageResource(R.drawable.news_selected);
            newsText.setTextColor(Color.BLACK);
                if (newsFragment == null){
                    newsFragment =  new NewsFragment();
                    transaction.add(R.id.content_frame,newsFragment);
                }else {
                    transaction.show(newsFragment);
                }
                break;
            case 1:
                dynamicImage.setImageResource(R.drawable.dynamic_selected);
                dynamicText.setTextColor(Color.BLACK);
                if (dynamicFragment == null){
                    dynamicFragment = new DynamicFragment();
                    transaction.add(R.id.content_frame,dynamicFragment);
                }else {
                    transaction.show(dynamicFragment);
                }
                break;
            case 2:
                contactImage.setImageResource(R.drawable.contact_selected);
                contactText.setTextColor(Color.BLACK);
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
                    settingText.setTextColor(Color.BLACK);
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
        newsText.setTextColor(Color.parseColor("#ffffff"));
        dynamicImage.setImageResource(R.drawable.dynamic_unselected);
        dynamicText.setTextColor(Color.parseColor("#ffffff"));
        contactImage.setImageResource(R.drawable.contact_unselected);
        contactText.setTextColor(Color.parseColor("#ffffff"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#ffffff"));
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
