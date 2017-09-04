package com.lpo.seoulnavi.controller;

import android.os.AsyncTask;
import android.util.Log;
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

    //String pAddr ="";
    public ParkInfoRes searchParkInfo() {
        Log.d(TAG, "searchParkInfo>>Start>>>>>>>>000>>>>>>>>>>>>");
        AsyncTest aSync = new AsyncTest();
        aSync.execute();
        return mParkInfoRes;
    }

    //Async
    private class AsyncTest extends AsyncTask {
        Call<ParkInfoRes> call;
        @Override protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            Log.d(TAG, "searchParkInfo>>Start>>>>>>>>>>>>>>>>>>>>");
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUtil.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ContentService service = retrofit.create(ContentService.class);
            call = service.getPostParkInfo();
            Log.d(TAG, "searchParkInfo>>Start>>>>>>>>>>>>>>>>>>>>2");
            Log.d(TAG,"왜먼저 나가냐 >>>>");
            return null;
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            try{
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
            }catch(Exception e){
                e.printStackTrace();
            }
            Log.d(TAG, "s = " +o);
            Log.d(TAG, "Result Message = ");
        }

    }
}