package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 서울시 권역별 실시간 대기환경 현황
 */
public class CityAirInfoRes {
protected static final String TAG = "CityAirInfoRes";	
	
	@SerializedName("RealtimeCityAir")
    public SearchRealtimeCityAirInfo searchRealtimeCityAirInfo;
	
    public static class SearchRealtimeCityAirInfo {
	   	 @SerializedName("list_total_count")
	        public String listTotlaCount;
	   	 
	   	 @SerializedName("RESULT")
	        public RESULTLIST resultList;
	
	        public class RESULTLIST {
	            @SerializedName("CODE")
	            public String code;
	            @SerializedName("MESSAGE")
	            public String message;
	        }
	   	
	        @SerializedName("row")
	        public ArrayList<row> row = new ArrayList<>();
	        public class row {
	        	//측정일시
	            @SerializedName("MSRDT")
	            public String msrDate;
	
	            //권역명
	            @SerializedName("MSRRGN_NM")
	            public String msrrgnName;
	
	            //측정소명
	            @SerializedName("MSRSTE_NM")
	            public String msrsteName;
	
	            //미세먼지(㎍/㎥)
	            @SerializedName("PM10")
	            public int pm10;
	
	            //초미세먼지농도(㎍/㎥)
	            @SerializedName("PM25")
	            public int pm25;
	
	            //오존(ppm)
	            @SerializedName("O3")
	            public float o3;
	
	            //이산화질소농도(ppm)
	            @SerializedName("NO2")
	            public float no2;
	            
	            //일산화탄소농도(ppm)
	            @SerializedName("CO")
	            public float co;
	        	
	            //아황산가스농도(ppm)
	            @SerializedName("SO2")
	            public float so2;
	            
	            //통합대기환경등급
	            @SerializedName("IDEX_NM")
	            public String idexName;
	            
	            //통합대기환경지수
	            @SerializedName("IDEX_MVL")
	            public int idexMvl;
	        	
	            //지수결정물질
	            @SerializedName("ARPLT_MAIN")
	            public String arpltMain;
	        }
    	}
	
	
	
}