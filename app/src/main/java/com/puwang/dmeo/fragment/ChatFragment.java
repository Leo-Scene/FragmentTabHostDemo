package com.puwang.dmeo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.puwang.dmeo.R;

import butterknife.BindView;

/**
 * Created by Leo on 2016/10/9.
 */

public class ChatFragment extends Fragment {
    @BindView(R.id.radio_group)
    RadioGroup group;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* View view = inflater.inflate(R.layout.fragment_chat, null);

        return view;*/



        if(rootView==null){
            rootView = inflater.inflate(R.layout.fragment_chat, null);

        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }
}
