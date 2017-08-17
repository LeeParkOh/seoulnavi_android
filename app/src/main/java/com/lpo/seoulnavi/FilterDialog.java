package com.lpo.seoulnavi;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.lpo.seoulnavi.glide.FilterBitmapPool;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Woonho on 2017. 8. 16..
 */
public class FilterDialog extends Dialog {

    private static final String TAG = "FilterDialog";
    // Filter 포지션을 저장하는 전역변수
    private String mPosition;
    private Context mContext;

    public FilterDialog(@NonNull Context context, String position) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        mPosition = position;
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        params.dimAmount = 0.8f;
        getWindow().setAttributes(params);

        setContentView(R.layout.filter_view);
        initView();


    }

    private void initView() {
        ImageView filterPark = (ImageView) findViewById(R.id.filter_park);
//        filterPark.setBackground(new ShapeDrawable(new OvalShape()));

        Glide.with(mContext)
                .load(R.drawable.ic_filter_park)
                .centerCrop()
                .crossFade()
                .bitmapTransform(new CropCircleTransformation(new FilterBitmapPool()))
                .override(70, 70)
                .into(filterPark);
    }

    // Filter 포지션값 가져오기
    public String getPosition() {
        if (mPosition.isEmpty()) {
            return "0";
        }
        return mPosition;
    }

    // Filter 포지션값 세팅
    public void setPosition(String position) {
        mPosition = position;
    }
}
