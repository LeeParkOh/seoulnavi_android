package com.lpo.seoulnavi.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.internal.bind.TreeTypeAdapter;
import com.lpo.seoulnavi.net.response.ParkInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by parkjongkook on 2017. 8. 7..
 */
public class SearchParkInfo {

    private static final String TAG = "SearchParkInfo";
    private ParkInfoRes mParkInfoRes;

    public ParkInfoRes searchParkInfo() {
        Log.d(TAG, "searchParkInfo>>Start>>>>>>>>>>>>>>>>>>>>");
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
                    Call<ParkInfoRes> call = service.getPostParkInfo();
                    mParkInfoRes = call.execute().body();
                    /*
                    for (int i = 0; i < mParkInfoRes.searchParkInfo.row.size(); i++) {
                        Log.d(TAG, "mParkInfoRes 공원명 = " + mParkInfoRes.searchParkInfo.row.get(i).pPark);
                    }
                    */
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
            return mParkInfoRes;
    }
}