package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 전통시장정보
 */

public class TraditionalMarketInfoRes {
	protected static final String TAG = "TraditionalMarketInfoRes";	
	 
	@SerializedName("ListTraditionalMarket")
	    public SearchTraditionalMarketInfo searchTraditionalMarketInfo;
		
	    public static class SearchTraditionalMarketInfo {
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
	        	  //자치구 코드
	             @SerializedName("M_CODE")
	             public String mCode;

	             //자치구명
	             @SerializedName("GUNAME")
	             public String guName;

	             //전통시장명
	             @SerializedName("M_NAME")
	             public String mName;

	             //주소명
	             @SerializedName("M_ADDR")
	             public String mAddr;

	             //상인회 연락처명
	             @SerializedName("M_TEL")
	             public String mTel;

	             //위도
	             @SerializedName("LAT")
	             public long latitude;

	             //경도
	             @SerializedName("LNG")
	             public long longitude;
	         }
	    }
}