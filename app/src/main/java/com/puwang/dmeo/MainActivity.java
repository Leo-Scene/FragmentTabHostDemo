package com.puwang.dmeo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.puwang.dmeo.bean.Tab;
import com.puwang.dmeo.fragment.ChatFragment;
import com.puwang.dmeo.fragment.HomeFragment;
import com.puwang.dmeo.fragment.MainFragment;

import java.util.ArrayList;

import static com.puwang.dmeo.R.color.text_selector;

public class MainActivity extends FragmentActivity {

    ArrayList<Tab> arrayList = new ArrayList<>();
    private FragmentTabHost mTabHost;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    private void initTab() {
        Tab main = new Tab(R.string.main,
                R.drawable.main_selector,
                MainFragment.class);

        Tab chat = new Tab(R.string.chat,
                R.drawable.chat_selector,
                ChatFragment.class);

        Tab home = new Tab(R.string.home,
                R.drawable.home_selector,
                HomeFragment.class);

        arrayList.add(home);
        arrayList.add(chat);
        arrayList.add(main);

        mTabHost = (FragmentTabHost)
                findViewById(android.R.id.tabhost);

        mTabHost.setup(this,
                getSupportFragmentManager(),
                R.id.realtabcontent);

        for (Tab tab : arrayList){
            TabHost.TabSpec mTabSpec = mTabHost.newTabSpec(
                    getString(tab.getTitle()));

            mTabSpec.setIndicator(buildIndicator(tab));

            mTabHost.addTab(mTabSpec,tab.getFragment(),null);

        }

        //去掉分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        //设置默认第一个页面被选中
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab) {
        inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.tab_indicator, null);

        TextView text = (TextView) view.findViewById(R.id.txt_indicator);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);

        text.setText(tab.getTitle());
        img.setBackgroundResource(tab.getIcon());

        return view;
    }
}
