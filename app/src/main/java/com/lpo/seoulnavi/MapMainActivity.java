package com.lpo.seoulnavi;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lpo.seoulnavi.controller.SearchCityAirInfo;
import com.lpo.seoulnavi.controller.SearchLibraryInfo;
import com.lpo.seoulnavi.controller.SearchParkInfo;
import com.lpo.seoulnavi.controller.SearchParticleOfDustInfo;
import com.lpo.seoulnavi.controller.SearchPhysicalPlantInfo;
import com.lpo.seoulnavi.controller.SearchSmokingZoneInfo;
import com.lpo.seoulnavi.controller.SearchToiletInfo;
import com.lpo.seoulnavi.controller.SearchTraditionalMarketInfo;
import com.lpo.seoulnavi.net.response.CityAirInfoRes;
import com.lpo.seoulnavi.net.response.LibraryInfoRes;
import com.lpo.seoulnavi.net.response.ParkInfoRes;
import com.lpo.seoulnavi.net.response.ParticleOfDustInfoRes;
import com.lpo.seoulnavi.net.response.PhysicalPlantInfoRes;
import com.lpo.seoulnavi.net.response.SmokingZoneInfoRes;
import com.lpo.seoulnavi.net.response.ToiletInfoRes;
import com.lpo.seoulnavi.net.response.TraditionalMarketInfoRes;

public class MapMainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private static final String TAG = "MapMainActivity";
    private LocationManager mLocationManager;
    private FloatingActionButton mFab;
    private GoogleMap mGMap;
    //공원정보
    private SearchParkInfo mSearchParkInfo;
    private ParkInfoRes mParkInfoRes;
    //서울 실시간 대기오염 정보
    private SearchCityAirInfo mSearchCityAirInfo;
    private CityAirInfoRes mCityAirInfoRes;
    //도서관정보
    private SearchLibraryInfo mSearchLibraryInfo;
    private LibraryInfoRes mLibraryInfoRes;
    //미세먼지정보
    private SearchParticleOfDustInfo mSearchParticleOfDustInfo;
    private ParticleOfDustInfoRes mParticleOfDustInfoRes;
    //공공체육시설정보
    private SearchPhysicalPlantInfo mSearchPhysicalPlantInfo;
    private PhysicalPlantInfoRes mPhysicalPlantInfoRes;
    //흡연시설정보
    private SearchSmokingZoneInfo mSearchSmokingZoneInfo;
    private SmokingZoneInfoRes mSmokingZoneInfoRes;
    //공중화장실정보
    private SearchToiletInfo mSearchToiletInfo;
    private ToiletInfoRes mToiletInfoRes;
    //전통시장정보
    private SearchTraditionalMarketInfo mSearchTraditionalMarketInfo;
    private TraditionalMarketInfoRes mTraditionalMarketInfoRes;

    private FilterDialog mFilterDialog;

    MarkerOptions mMarkerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate" );
        setContentView(R.layout.activity_map_main);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);

        // Google Map 객체가 준비되면 실행될 콜백 등록
        mapFragment.getMapAsync(this);
        // Floating Button
        mFab = (FloatingActionButton)findViewById(R.id.btnFAB);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callMarkerInfo(1);

                mFilterDialog = new FilterDialog(MapMainActivity.this, "0");
                mFilterDialog.show();
            }
        });

        // GPS 확인
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        /*
        if(!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            //GPS 설정화면으로 이동
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(intent);
            finish();
        }
        */
    }

    /**
     * OnMapReadyCallback 콜백메서드
     * @param map
     */
    @Override
    public void onMapReady(final GoogleMap map) {
        Log.d(TAG, "onMapReady is called");
        // 서울 위도, 경도
        LatLng SEOUL = new LatLng(37.56, 126.97);
                                //(LATITUDE, LONGITUDE)
        //LatLng PARK70 = new LatLng(37.648420, 127.040929); //초안산근린공원
        mGMap = map;
        mGMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        mGMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        callMarkerInfo(0);  //마커찍기
    }//onMapReady end
    /**
     * 마커찍기
     */
    private void callMarkerInfo(int infoNumber){
        mMarkerOptions = new MarkerOptions();
        Log.d(TAG,"<<<<<<<infoNumber>>>>>>>");
        if(infoNumber == 0){//공원정보
            Log.d(TAG,"infoNumber>>>>>0");
            callParkInfo();
            Log.d(TAG,"row.size()>>>"+mParkInfoRes.searchParkInfo.row.size());
            int rowSize = mParkInfoRes.searchParkInfo.row.size();
            for(int i=0; i<rowSize; i++){
                //new LatLng(LATITUDE, LONGITUDE)
                LatLng Park = new LatLng(mParkInfoRes.searchParkInfo.row.get(i).latitude
                        ,mParkInfoRes.searchParkInfo.row.get(i).longitude);
                // 마커에 표시될 정보
                mMarkerOptions.position(Park);
                mMarkerOptions.title(mParkInfoRes.searchParkInfo.row.get(i).pPark);
                mMarkerOptions.snippet("한국의 "+mParkInfoRes.searchParkInfo.row.get(i).pPark);
                mGMap.addMarker(mMarkerOptions);
            }
        }else if(infoNumber == 1){
            callLibraryInfo();
            Log.d(TAG,"infoNumber>>>>>1");
            Log.d(TAG,"row.size()>>>"+mLibraryInfoRes.searchLibraryInfo.row.size());
            int rowSize = mLibraryInfoRes.searchLibraryInfo.row.size();
            for(int i=0; i<rowSize; i++){
                //new LatLng(LATITUDE, LONGITUDE)
                LatLng Library = new LatLng(Double.parseDouble(mLibraryInfoRes.searchLibraryInfo.row.get(i).latitude)
                        ,Double.parseDouble(mLibraryInfoRes.searchLibraryInfo.row.get(i).longitude));
                // 마커에 표시될 정보
                mMarkerOptions.position(Library);
                mMarkerOptions.title(mLibraryInfoRes.searchLibraryInfo.row.get(i).fcltyName);
                mMarkerOptions.snippet("한국의 "+mLibraryInfoRes.searchLibraryInfo.row.get(i).fcltyName);
                mGMap.addMarker(mMarkerOptions);
            }
        }
    }

    /**
     * 서울시 권역별 실시간 대기환경 현황 불러오기
     */
    private void callCityAirInfo() {
        Log.d(TAG,"<<<<<<<callCityAirInfo Start>>>>>>");
        mSearchCityAirInfo = new SearchCityAirInfo();
        mCityAirInfoRes = mSearchCityAirInfo.searchCityAirInfo();
    }

    /**
     * 도서관정보
     */
    private void callLibraryInfo() {
        Log.d(TAG,"<<<<<<<callLibraryInfo Start>>>>>>");
        mSearchLibraryInfo = new SearchLibraryInfo();
        mLibraryInfoRes = mSearchLibraryInfo.searchLibraryInfo();
    }

    /**
     * 공원정보 불러오기
     */
    private void callParkInfo() {
        Log.d(TAG,"<<<<<<<callParkInfo Start>>>>>>");
        mSearchParkInfo = new SearchParkInfo();
        mParkInfoRes = mSearchParkInfo.searchParkInfo();
    }

    /**
     * 미세먼지정보 불러오기
     * 좌표값없음
     */
    private void callParticleOfDustInfo() {
        Log.d(TAG,"<<<<<<<callParticleOfDustInfo Start>>>>>>");
        mSearchParticleOfDustInfo = new SearchParticleOfDustInfo();
        mParticleOfDustInfoRes = mSearchParticleOfDustInfo.searchParticleOfDustInfo();
    }

    /**
     * 체육시설정보 불러오기
     * 좌표값없음
     */
    private void callPhysicalPlantInfo() {
        Log.d(TAG,"<<<<<<<callPhysicalPlantInfo Start>>>>>>");
        mSearchPhysicalPlantInfo = new SearchPhysicalPlantInfo();
        mPhysicalPlantInfoRes = mSearchPhysicalPlantInfo.searchPhysicalPlantInfo();
    }

    /**
     * 흡연구역정보 불러오기
     * 좌표값없음
     */
    private void callSmokingZoneInfo() {
        Log.d(TAG,"<<<<<<<callSmokingZoneInfo Start>>>>>>");
        mSearchSmokingZoneInfo = new SearchSmokingZoneInfo();
        mSmokingZoneInfoRes = mSearchSmokingZoneInfo.searchSmokingZoneInfo();
    }

    /**
     * 공공화장실정보 불러오기
     */
    private void callToiletInfo() {
        Log.d(TAG,"<<<<<<<callToiletInfo Start>>>>>>");
        mSearchToiletInfo = new SearchToiletInfo();
        mToiletInfoRes = mSearchToiletInfo.searchToiletInfo();
    }

    /**
     * 전통시장정보 불러오기
     */
    private void callTraditionalMarketInfo() {
        Log.d(TAG,"<<<<<<<callTraditionalMarketInfo Start>>>>>>");
        mSearchTraditionalMarketInfo = new SearchTraditionalMarketInfo();
        mTraditionalMarketInfoRes = mSearchTraditionalMarketInfo.searchTraditionalMarketInfo();
    }
}
