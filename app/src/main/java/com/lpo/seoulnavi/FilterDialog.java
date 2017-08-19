package com.lpo.seoulnavi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.lpo.seoulnavi.util.FilterType;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Woonho on 2017. 8. 16..
 */
public class FilterDialog extends Dialog implements View.OnClickListener{

    private static final String TAG = "FilterDialog";
    private Context mContext;
    // Filter 포지션을 저장하는 전역변수
    private int mPosition;

    public FilterDialog(@NonNull Context context, int position) {
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
                .bitmapTransform(new CropCircleTransformation(mContext))
                .override(70, 70)
                .into(filterPark);

    }

    // Filter 포지션값 가져오기
    public int getPosition() {
        return mPosition;
    }

    // Filter 포지션값 세팅
    public void setPosition(int position) {
        mPosition = position;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.filter_park:
                setPosition(0);
                dismiss();
                break;
            case R.id.filter_gym:
                setPosition(1);
                dismiss();
                break;
            case R.id.filter_korean_market:
                setPosition(2);
                dismiss();
                break;
            case R.id.filter_no_smoking:
                setPosition(3);
                dismiss();
                break;
            case R.id.filter_wc:
                setPosition(4);
                dismiss();
                break;
            case R.id.filter_bicycle:
                setPosition(5);
                dismiss();
                break;
            case R.id.filter_dust:
                setPosition(6);
                dismiss();
                break;
            case R.id.filter_library:
                setPosition(7);
                dismiss();
                break;
            default:
                dismiss();
                break;
        }
    }

    public void setFilterId() {
        String filter = FilterType.FILTER_PARK;
    }
}
