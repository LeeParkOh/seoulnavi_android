package com.lpo.seoulnavi.net.retrofit;

import com.lpo.seoulnavi.net.response.CityAirInfoRes;
import com.lpo.seoulnavi.net.response.LibraryInfoRes;
import com.lpo.seoulnavi.net.response.ParkInfoRes;
import com.lpo.seoulnavi.net.response.ParticleOfDustInfoRes;
import com.lpo.seoulnavi.net.response.PhysicalPlantInfoRes;
import com.lpo.seoulnavi.net.response.SmokingZoneInfoRes;
import com.lpo.seoulnavi.net.response.ToiletInfoRes;
import com.lpo.seoulnavi.net.response.TraditionalMarketInfoRes;

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

    /**
     * 도서관정보
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/GeoInfoLibrary/1/200")
    Call<LibraryInfoRes> getPostLibraryInfo();

    /**
     * 서울시 권역별 실시간 대기환경 현황
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/RealtimeCityAir/1/100")
    Call<CityAirInfoRes> getPostCityAirInfo();

    /**
     * 미세먼지정보
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/ForecastWarningMinuteParticleOfDustService/1/1")
    Call<ParticleOfDustInfoRes> getPostParticleOfDust();

    /**
     * 공공체육시설 정보
     * @return
     */
    @GET("SmokingZoneInfo/476b6d4a4c74776f3131394d78654457/json/ListPublicPhysicalPlant/1/500")
    Call<PhysicalPlantInfoRes> getPostPhysicalPlantInfo();

    /**
     * 흡연구역정보
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/ListPublicPhysicalPlant/1/500/")
    Call<SmokingZoneInfoRes> getPostSmokingZoneInfo();

    /**
     * 공공화장실정보
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/SearchPublicToiletPOIService/1/1000")
    Call<ToiletInfoRes> getPostToiletInfo();

    /**
     * 전통시장정보
     * @return
     */
    @GET("/476b6d4a4c74776f3131394d78654457/json/ListTraditionalMarket/1/400")
    Call<TraditionalMarketInfoRes> getPostTraditionalMarketInfo();
}
