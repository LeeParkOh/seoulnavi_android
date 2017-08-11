package com.lpo.seoulnavi.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by parkjongkook on 2017. 8. 11..
 * 공공체육시설 정보
 */

public class PhysicalPlantInfoRes {
	protected static final String TAG = "PhysicalPlantInfoRes";	
	
    @SerializedName("ListPublicPhysicalPlant")
    public SearchPhysicalPlantInfo searchPhysicalPlantInfo;
	
    public static class SearchPhysicalPlantInfo {
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
        	  //일련번호
             @SerializedName("SEQ")
             public int seq;

             //시설키
             @SerializedName("CENTER_KEY")
             public String centerKey;

             //시설명
             @SerializedName("CENTER_NAME")
             public String centerName;

             //주소
             @SerializedName("ADDRESS")
             public String address;

             //우편번호
             @SerializedName("ZIP")
             public String zip;

             //홈페이지
             @SerializedName("HOMEPAGE")
             public String homepage;

             //E-MAIL
             @SerializedName("EMAIL")
             public String email;

             //시설전화번호
             @SerializedName("TEL")
             public String tel;

             //FAX
             @SerializedName("FAX")
             public double fax;

             //소유기관
             @SerializedName("OWN_ORGAN")
             public double ownOrgan;

             //운영형태
             @SerializedName("MANAGE_FORM")
             public double manageForm;

             //운영기관명
             @SerializedName("MANAGE_ORGAN")
             public double manageOrgan;
             
             //부지면적(㎡)
             @SerializedName("PLOTTAGE")
             public double plottage;
             
             //건축면적(㎡)
             @SerializedName("BUILDING_AREA")
             public double buildingArea;
             
             //연면적(㎡)
             @SerializedName("GROSS_AREA")
             public double grossArea;
             
             //지상 0층
             @SerializedName("GROUND")
             public double ground;
             
             //지하 0층
             @SerializedName("UNDERGROUND")
             public double underground;
             
             //주차면(면)
             @SerializedName("PARKING_SIDE")
             public double parkingSide;
             
             //부대시설
             @SerializedName("SUBSIDIARY")
             public double subsidiary;
             
             //시설소개
             @SerializedName("INTRO")
             public double intro;
             
             //BUS X좌표
             @SerializedName("X_COORD")
             public double xCoord;
           
             //BUS Y좌표
             @SerializedName("Y_COORD")
             public double yCoord;
         }
    }
}