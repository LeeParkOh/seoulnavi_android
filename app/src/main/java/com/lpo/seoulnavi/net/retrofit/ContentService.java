package com.lpo.seoulnavi.net.retrofit;

import com.lpo.seoulnavi.net.response.ParkInfoRes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by parkjongkook on 2017. 8. 7..
 */

public interface ContentService {
    /**
     * 공원정보 조회
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/SearchParkInformationByAddressService/1/100")
    Call<ParkInfoRes> getPostParkInfo();

}
