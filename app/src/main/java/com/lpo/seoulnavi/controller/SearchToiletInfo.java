package com.lpo.seoulnavi.controller;

import android.util.Log;

import com.lpo.seoulnavi.net.response.SmokingZoneInfoRes;
import com.lpo.seoulnavi.net.response.ToiletInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by parkjongkook on 2017. 8. 11..
 */

public class SearchToiletInfo {
    private static final String TAG = "SearchToiletInfo";
    private ToiletInfoRes mToiletInfoRes;

    public ToiletInfoRes searchToiletInfo() {
        Log.d(TAG, "searchSmokingZoneInfo>>Start>>>>");
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
                    Call<ToiletInfoRes> call = service.getPostToiletInfo();
                    mToiletInfoRes = call.execute().body();
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
        return mToiletInfoRes;
    }
}
