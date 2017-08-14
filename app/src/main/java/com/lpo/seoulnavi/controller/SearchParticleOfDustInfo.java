package com.lpo.seoulnavi.controller;

import android.util.Log;

import com.lpo.seoulnavi.net.response.LibraryInfoRes;
import com.lpo.seoulnavi.net.response.ParticleOfDustInfoRes;
import com.lpo.seoulnavi.net.retrofit.ContentService;
import com.lpo.seoulnavi.util.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by parkjongkook on 2017. 8. 11..
 */

public class SearchParticleOfDustInfo {
    private static final String TAG = "SearchParticleOfDustInfo";
    private ParticleOfDustInfoRes mParticleOfDustInfoRes;

    public ParticleOfDustInfoRes searchParticleOfDustInfo() {
        Log.d(TAG, "searchLibraryInfo>>Start>>>>");
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
                    Call<ParticleOfDustInfoRes> call = service.getPostParticleOfDust();
                    mParticleOfDustInfoRes = call.execute().body();
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
        return mParticleOfDustInfoRes;
    }

}
