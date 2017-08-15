package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parkjongkook on 2017. 8. 11..
 * 도서관정보
 */
public class LibraryInfoRes {
	protected static final String TAG = "LibraryInfoRes";	
	@SerializedName("GeoInfoLibrary")
    public SearchLibraryInfo searchLibraryInfo;
	
    public static class SearchLibraryInfo {
	   	 @SerializedName("list_total_count")
	        public int listTotlaCount;
	   	 
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
	            public String newAdressNm;
	            
	            //시설명
	            @SerializedName("FCLTY_NM")
	            public String fcltyName;
	            
	            //운영기관
	            @SerializedName("ORN_ORG")
	            public String ornOrg;
	            
	            //설립주체
	            @SerializedName("EBT_MAN")
	            public String ebtMan;
	            
	            //시설구분
	            @SerializedName("FLY_GBN")
	            public String flyGbn;
	            
	            //개관일
	            @SerializedName("OPNNG_DE")
	            public String opnngDate;
	            
	            //면적
	            @SerializedName("AR")
	            public double ar;
	            
	            //홈페이지주소
	            @SerializedName("HMPG_CN")
	            public String hmpgCn;
	            
	            //연락처
	            @SerializedName("CTTPC_CN")
	            public String cttpcCn;
	            
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