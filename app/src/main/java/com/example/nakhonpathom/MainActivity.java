package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nakhonpathom.model.Place;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*private String[] mPlaceList = new String[]{
            "พระปฐมเจดี","บ้านปลายนา","พิพิธภัท?์รถเก่า","ตลาดท่านา","วัดกลางบางแก้ว","วัดสามพราน","วัดไร่ขิง","วัดศรีษะทอง"
    };*/

    private List<Place> mPlaceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        populateData();

        ListView plListView = findViewById(R.id.place_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,//context
                R.layout.item_place,//ระบุlaout แต่ละ list
                R.id.place_name_text_view,//ระบุที่จะใส่ขอมูลของ item
                mPlaceList//แหล่งขอมูล
        );
        plListView.setAdapter(adapter);
        //สร้างlistenner เมื่อมีการกดแต่ละครั้ง
        plListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parnet, View view, int possion, long id) {
                //อ่านสถานที่ของITEM ที่ถูฏคลิก
         String placeName = mPlaceList[possion];
                //แสดงชื่อสถานที่ออกมา TOAST
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populateData() {
       Place place = new Place("พระฐมเจดี","เมือง");
       mPlaceList.add(place);

         place = new Place("บ้านปลายนา","นครชัยศรี");
        mPlaceList.add(place);

         place = new Place("พิพิธภัท?์รถเก่า","เมือง");
        mPlaceList.add(place);

         place = new Place("ตลาดท่านา","นครชัยศร");
        mPlaceList.add(place);

        place = new Place("วัดกลางบางแก้ว","นครชัยศร");
        mPlaceList.add(place);

         place = new Place("วัดกลางบางแก้ว","สามพราน");
        mPlaceList.add(place);

         place = new Place("ววัดไร่ขิง","สามพราน");
        mPlaceList.add(place);

         place = new Place("วัดศรีษะทอง","นครชัยศรี");
        mPlaceList.add(place);


    }
}
