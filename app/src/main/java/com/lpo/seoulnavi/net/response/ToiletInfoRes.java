package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 공공화장실정보
 */
public class ToiletInfoRes {
	protected static final String TAG = "ToiletInfoRes";	
	
	@SerializedName("GeoInfoPublicToilet")
    public SearchToiletInfo searchToiletInfo;
	
    public static class SearchToiletInfo {
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
	       	  //고유번호
	            @SerializedName("OBJECTID")
	            public int objectId;
	
	            //구명
	            @SerializedName("GU_NM")
	            public String guName;
	
	            //법정동명
	            @SerializedName("HNR_NAM")
	            public String hnrName;
	
	            //산지여부
	            @SerializedName("MTC_AT")
	            public String mtcAt;
	
	            //주지번
	            @SerializedName("MASTERNO")
	            public String masterNo;
	
	            //부지번
	            @SerializedName("SLAVENO")
	            public String slaveNo;
	
	            //새주소명
	            @SerializedName("NEADRES_NM")
	            public String newAdressName;
	            
	            //생성일
	            @SerializedName("CREAT_DE")
	            public String createDate;
	            
	            //X 좌표
	            @SerializedName("X")
	            public String latitude;
	            
	            //Y 좌표
	            @SerializedName("Y")
	            public String longitude;
	        }
    	}
}