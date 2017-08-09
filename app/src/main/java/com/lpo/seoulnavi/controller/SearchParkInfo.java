package com.lpo.seoulnavi.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.lpo.seoulnavi.net.response.ParkInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

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

    //String pAddr ="";
    public ParkInfoRes searchParkInfo() {
        Log.d(TAG, "searchParkInfo>>Start>>>>>>>>>>>>>>>>>>>>");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUtil.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContentService service = retrofit.create(ContentService.class);
        Call<ParkInfoRes> call = service.getPostParkInfo();
        Log.d(TAG, "searchParkInfo>>Start>>>>>>>>>>>>>>>>>>>>2");


           call.enqueue(new Callback<ParkInfoRes>() {
               @Override
               public void onResponse(Call<ParkInfoRes> call, Response<ParkInfoRes> response) {
                   if (response.isSuccessful()) {
                       Log.d(TAG, "Retrofit Response Success");
                       mParkInfoRes = response.body();
                       Log.d(TAG, "mParkInfoRes Row Size = " + mParkInfoRes.searchParkInfo.row.size());
                       for (int i = 0; i < mParkInfoRes.searchParkInfo.row.size(); i++) {
                           Log.d(TAG, "mParkInfoRes 공원명 = " + mParkInfoRes.searchParkInfo.row.get(i).pPark);
                       }
                       //testPOIdataOverlay();
                   } else {
                       Log.d(TAG, "Retrofit Response Not Success");
                   }
               }

               @Override
               public void onFailure(Call<ParkInfoRes> call, Throwable t) {
                   Log.d(TAG, "onFailure");
                   Log.d(TAG, "mParkInfoRes Result Code = " + mParkInfoRes.searchParkInfo.resultList.code);
                   Log.d(TAG, "mParkInfoRes Result Msg = " + mParkInfoRes.searchParkInfo.resultList.message);
               }
           });

        Log.d(TAG,"왜먼저 나가냐 >>>>");
        Log.d(TAG,"함수 끝 111");
        return mParkInfoRes;
    }
}