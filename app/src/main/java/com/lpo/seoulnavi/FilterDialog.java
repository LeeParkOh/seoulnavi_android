package com.lpo.seoulnavi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by Woonho on 2017. 8. 16..
 */
public class FilterDialog extends Dialog {

    private static final String TAG = "FilterDialog";
    // Filter 포지션을 저장하는 전역변수
    private String mPosition;

    public FilterDialog(@NonNull Context context, String position) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        mPosition = position;
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
