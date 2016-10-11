package com.puwang.dmeo.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.puwang.dmeo.R;
import com.puwang.dmeo.activity.ResultActivity;
import com.puwang.dmeo.adapter.MRecyclerAdapter;
import com.puwang.dmeo.bean.ItemInfo;
import com.puwang.dmeo.util.ImageUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;

import static com.daimajia.slider.library.SliderLayout.PresetIndicators.Right_Bottom;

/**
 * Created by Leo on 2016/10/9.
 */

public class HomeFragment extends Fragment {

    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;
    private View rootView;
    private SliderLayout sliderShow;
    private PagerIndicator indicator;
    private RecyclerView mRecycler;
    private ArrayList<ItemInfo> mArrayList;
    private MRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, null);
            initToolBar(rootView);
            initSlider(rootView);
            initView(rootView);

        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View rootView) {
        mRecycler = (RecyclerView)
                rootView.findViewById(R.id.recycler);

        initData();

        adapter = new MRecyclerAdapter(mArrayList);

        mRecycler.setAdapter(adapter);

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setOnItemClickListener(new MRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(getContext(),mArrayList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        mArrayList = new ArrayList<ItemInfo>();

        ItemInfo info1 = new ItemInfo("张三","男","18岁");
        ItemInfo info2 = new ItemInfo("李四","女","20岁");
        ItemInfo info3 = new ItemInfo("王五","男","16岁");
        ItemInfo info4 = new ItemInfo("赵六","女","19岁");
        ItemInfo info5 = new ItemInfo("钱七","女","22岁");
        ItemInfo info6 = new ItemInfo("孙八","男","21岁");
        ItemInfo info7 = new ItemInfo("杨九","女","24岁");
        ItemInfo info8 = new ItemInfo("吴十","女","28岁");
        ItemInfo info9 = new ItemInfo("孙大圣","男","34岁");
        ItemInfo info10 = new ItemInfo("陈一","女","14岁");
        ItemInfo info11 = new ItemInfo("欧阳师弟","男","11岁");
        ItemInfo info12 = new ItemInfo("张小姐","女","24岁");
        ItemInfo info13 = new ItemInfo("黄药师","男","44岁");

        mArrayList.add(info5);
        mArrayList.add(info1);
        mArrayList.add(info10);
        mArrayList.add(info2);
        mArrayList.add(info9);
        mArrayList.add(info3);
        mArrayList.add(info12);
        mArrayList.add(info4);
        mArrayList.add(info6);
        mArrayList.add(info8);
        mArrayList.add(info11);
        mArrayList.add(info7);
        mArrayList.add(info13);

    }


    private void initToolBar(View rootView) {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.my_toolbar_menu);

        toolbar.setNavigationIcon(R.mipmap.scan);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        toolbar.setTitle(R.string.home_page);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initSlider(View rootView) {
        sliderShow = (SliderLayout) rootView.findViewById(R.id.slider);
        indicator = (PagerIndicator)
                rootView.findViewById(R.id.custom_indicator);

        TextSliderView textSliderView1 = new TextSliderView(getContext());
        textSliderView1
                .description("草莓")
                .image("http://img5.imgtn.bdimg.com/it/u=3927785294,2227203319&fm=21&gp=0.jpg");

        TextSliderView textSliderView2 = new TextSliderView(getContext());
        textSliderView2
                .description("车厘子")
                .image("http://img1.gtimg.com/cq/pics/hv1/130/146/1845/120008485.jpg");

        TextSliderView textSliderView3 = new TextSliderView(getContext());
        textSliderView3
                .description("桃子")
                .image("http://img0.imgtn.bdimg.com/it/u=1465459959,1919113503&fm=21&gp=0.jpg");

        TextSliderView textSliderView4 = new TextSliderView(getContext());
        textSliderView4
                .description("西瓜")
                .image("http://img5.imgtn.bdimg.com/it/u=2072828474,3810422161&fm=21&gp=0.jpg");

        TextSliderView textSliderView5 = new TextSliderView(getContext());
        textSliderView5
                .description("柠檬")
                .image("http://p3.gexing.com/G1/M00/64/18/rBACJlUgxlXjzmaPAAHa9kRxrC0188.jpg");


        sliderShow.addSlider(textSliderView1);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);
        sliderShow.addSlider(textSliderView4);
        sliderShow.addSlider(textSliderView5);


        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderShow.setDuration(200);
    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    /*Intent intent = new Intent(getContext(), ResultActivity.class);
                    intent.putExtra("DetailUrl",result);
                    startActivity(intent);*/
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

        /**
         * 选择系统图片并解析
         */
        else if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(getContext(), uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                           // Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getContext(), ResultActivity.class);
                            intent.putExtra("DetailUrl",result);
                            startActivity(intent);
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
