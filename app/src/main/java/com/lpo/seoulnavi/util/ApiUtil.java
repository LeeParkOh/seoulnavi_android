package com.lpo.seoulnavi.util;

/**
 * Created by parkjongkook on 2017. 8. 7..
 */
/**
 * API 키 관리하는 클래스
 * 모든 API 키값은 여기다 정의하고 사용한다.
 * Created by leewoonho on 2017. 7. 25..
 */

public class ApiUtil {

    public static final String NAVER_API_KEY = "xX_X9wNXFyIe0z3vGgi2";
    public static final String API_KEY = "476b6d4a4c74776f3131394d78654457/json/SearchParkInformationByAddressService/1/100/";
    public static final String BASE_URL = "http://openapi.seoul.go.kr:8088/";

    public String getUrl(String url) {
        return BASE_URL + API_KEY + url;
    }
}
