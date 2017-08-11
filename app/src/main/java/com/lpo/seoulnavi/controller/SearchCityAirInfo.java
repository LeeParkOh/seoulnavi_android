package com.lpo.seoulnavi.controller;

import android.util.Log;

import com.lpo.seoulnavi.net.response.CityAirInfoRes;
import com.lpo.seoulnavi.net.response.ParkInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 서울시 권역별 실시간 대기환경 현황
 */

public class SearchCityAirInfo {
    private static final String TAG = "SearchCityAirInfo";
    private CityAirInfoRes mCityAirInfoRes;

    public CityAirInfoRes searchCityAirInfo() {
        Log.d(TAG, "searchCityAirInfo>>Start>>>>>>>>>>>>>>>>>>>>");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "searchCityAirInfo Retrofit Response Success");
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(ApiUtil.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ContentService service = retrofit.create(ContentService.class);
                    Call<CityAirInfoRes> call = service.getPostCityAirInfo();
                    mCityAirInfoRes = call.execute().body();
                    Log.d(TAG,">>>>"+mCityAirInfoRes.searchRealtimeCityAirInfo.row.get(0).idexMvl);
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
        return mCityAirInfoRes;
    }
}
