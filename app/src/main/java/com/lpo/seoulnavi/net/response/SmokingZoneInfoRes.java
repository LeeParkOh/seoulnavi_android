package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 흡연구역정보
 */

public class SmokingZoneInfoRes {
	protected static final String TAG = "SmokingZoneInfoRes";	
	 
		@SerializedName("SebcSmokingZoneKor")
	    public SearchSmokingZoneInfo searchSmokingZoneInfo;
		
	    public static class SearchSmokingZoneInfo {
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
	        	  //번호
	             @SerializedName("MAIN_KEY")
	             public String mainKey;

	             //명칭
	             @SerializedName("NAME_KOR")
	             public String zoneName;

	             //대분류
	             @SerializedName("CATE1_NAME")
	             public String cate1Name;

	             //주소
	             @SerializedName("ADD_KOR")
	             public String address;

	             //규모
	             @SerializedName("AREA")
	             public String area;

	             //설치일
	             @SerializedName("MAKE_DATE")
	             public String makeDate;

	             //설치주체
	             @SerializedName("AUTHORITY")
	             public String authority;
	             
	             //운영관리
	             @SerializedName("OPERATOR")
	             public String operator;
	         }
	    }
	
}