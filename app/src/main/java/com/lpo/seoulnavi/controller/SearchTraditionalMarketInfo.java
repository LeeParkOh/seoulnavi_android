package com.lpo.seoulnavi.controller;

import android.util.Log;

import com.lpo.seoulnavi.net.response.ToiletInfoRes;
import com.lpo.seoulnavi.net.response.TraditionalMarketInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by parkjongkook on 2017. 8. 11..
 */

public class SearchTraditionalMarketInfo {
    private static final String TAG = "SearchTraditionalMarketInfo";
    private TraditionalMarketInfoRes mTraditionalMarketInfoRes;

    public TraditionalMarketInfoRes searchTraditionalMarketInfo() {
        Log.d(TAG, "searchTraditionalMarketInfo>>Start>>>>");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "Retrofit Response Success");
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(ApiUtil.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ContentService service = retrofit.create(ContentService.class);
                    Call<TraditionalMarketInfoRes> call = service.getPostTraditionalMarketInfo();
                    mTraditionalMarketInfoRes = call.execute().body();
                } catch (IOException e) {
                    Log.d(TAG, "IOException>>>" + e);
                }
            }
        }).start();
        try{
            Thread.sleep(1000); //1초딜레이
        }catch(Exception exception){
            Log.d(TAG,"exception>>>>"+exception);
        }
        return mTraditionalMarketInfoRes;
    }

}
