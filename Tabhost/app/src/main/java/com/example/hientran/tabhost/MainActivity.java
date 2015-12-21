package com.example.hientran.tabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        // tạo ra 2 tabSpec và thêm vào TabHost
        //=========== = Tab Hình Ảnh = ============//
        TabSpec hinhanh = tabHost.newTabSpec("tên đặt tùy ý ");
        // phần hiện thị của Tab
        hinhanh.setIndicator("Hình Ảnh" , getResources().getDrawable(R.drawable.icon_photos_tab));
        // thiết lập nội dung
        Intent hinhanh_Intent = new Intent(this, HinhanhActivity.class);
        hinhanh.setContent(hinhanh_Intent);
        

        //=========== = Tab Tìm Kiếm = ============//
        // khởi tạo tab tìm kiếm
        TabSpec timkiem = tabHost.newTabSpec("Tìm Kiếm");
        // cần chỉnh sủa icon_song_tab
        timkiem.setIndicator("Tìm Kiếm", getResources().getDrawable(R.drawable.icon_search_tab));
        Intent timkiem_Intent = new Intent(this, SearchActivity.class);
        timkiem.setContent(timkiem_Intent);


        //=========== = Tab yêu thích = ============//
        TabSpec yeuthich = tabHost.newTabSpec("Yêu Thích");
        yeuthich.setIndicator("Yêu Thích", getResources().getDrawable(R.drawable.icon_yeuthich_tab));
        Intent yeuthich_Intent = new Intent(this, YeuthichActivity.class);
        yeuthich.setContent(yeuthich_Intent);  // yeuthich_Intent là biến thực hiện khi nhảy qua tab yêu thích

    /*
        TabSpec
    */

        // thêm vào Tabhost
        tabHost.addTab(hinhanh);
        tabHost.addTab(timkiem);
        tabHost.addTab(yeuthich);

    }
}
