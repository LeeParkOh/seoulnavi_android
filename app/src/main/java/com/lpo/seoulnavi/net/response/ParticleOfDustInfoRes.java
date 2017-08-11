package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 미세먼지정보
 */
public class ParticleOfDustInfoRes {
protected static final String TAG = "ToiletInfoRes";	
	
	@SerializedName("ForecastWarningMinuteParticleOfDustService")
    public SearchParticleOfDustInfo searchParticleOfDustInfo;
	
    public static class SearchParticleOfDustInfo {
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
	        	//발표시간 YYYYMMDDHHMI)
	            @SerializedName("APPLC_DT")
	            public String appclDt;
	
	            //예/경보 구분      (f: 예보, a: 경보)
	            @SerializedName("FA_ON")
	            public String faOn;
	
	            //오염물질 종류
	            @SerializedName("POLLUTANT")
	            public String pollutant;
	
	            //예보 등급
	            @SerializedName("CAISTEP")
	            public String caistep;
	
	            //행동요령(예보)
	            @SerializedName("ALARM_CNDT")
	            public String alarmCndt;
	
	            //경보 등급
	            @SerializedName("ALERTSTEP")
	            public String alertStep;
	
	            //행동요령(경보)
	            @SerializedName("CNDT1")
	            public String cndt1;
	        }
    	}
}