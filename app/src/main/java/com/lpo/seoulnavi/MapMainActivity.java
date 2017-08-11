package com.lpo.seoulnavi;

import android.app.FragmentManager;
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
import com.lpo.seoulnavi.controller.SearchParkInfo;
import com.lpo.seoulnavi.net.response.CityAirInfoRes;
import com.lpo.seoulnavi.net.response.ParkInfoRes;

public class MapMainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private static final String TAG = "MapMainActivity";
    private LocationManager mLocationManager;
    private FloatingActionButton mFab;
    private GoogleMap mGMap;

    private SearchParkInfo mSearchParkInfo;
    private ParkInfoRes mParkInfoRes;

    private SearchCityAirInfo mSearchCityAirInfo;
    private CityAirInfoRes mCityAirInfoRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        callParkInfo();
        callCityAirInfo();
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
                Toast.makeText(MapMainActivity.this, "Filter Button", Toast.LENGTH_SHORT).show();
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
        // 마커에 표시될 정보

        MarkerOptions markerOptions = new MarkerOptions();
        /*
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(PARK70);
        markerOptions2.title("초안산근린공원");
        markerOptions2.snippet("한국의 초안산근린공원");

        mGMap.addMarker(markerOptions);
        mGMap.addMarker(markerOptions2);
        */

        Log.d(TAG,"row.size()>>>"+mParkInfoRes.searchParkInfo.row.size());
        int rowSize = mParkInfoRes.searchParkInfo.row.size();
        for(int i=0; i<rowSize; i++){
            //new LatLng(LATITUDE, LONGITUDE)
            LatLng Park = new LatLng(mParkInfoRes.searchParkInfo.row.get(i).latitude
                                    , mParkInfoRes.searchParkInfo.row.get(i).longitude);
            markerOptions.position(Park);
            markerOptions.title(mParkInfoRes.searchParkInfo.row.get(i).pPark);
            markerOptions.snippet("한국의 "+mParkInfoRes.searchParkInfo.row.get(i).pPark);
            mGMap.addMarker(markerOptions);
        }
    }//onMapReady end

    /**
     * 공원정보 불러오기
     */
    private void callParkInfo() {
        Log.d(TAG,"<<<<<<<callParkInfo Start>>>>>>");
        mSearchParkInfo = new SearchParkInfo();
        mParkInfoRes = mSearchParkInfo.searchParkInfo();
    }

    /**
     * 서울시 권역별 실시간 대기환경 현황 불러오기
     */
    private void callCityAirInfo() {
        Log.d(TAG,"<<<<<<<callCityAirInfo Start>>>>>>");
        mSearchCityAirInfo = new SearchCityAirInfo();
        mCityAirInfoRes = mSearchCityAirInfo.searchCityAirInfo();
    }
}
