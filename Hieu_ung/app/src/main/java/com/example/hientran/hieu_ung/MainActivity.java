package com.example.hientran.hieu_ung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // khai báo
    Button btnAlpha, btnScale, btnTranslate, btnrotate;
    TextView txtvhieuung;
/* sẽ bị lỗi nến khai báo ở đây vào lấy ra sử dụng
    Animation hieuungsangmo = AnimationUtils.loadAnimation(this ,R.anim.alpha);
    Animation hieuungzoom = AnimationUtils.loadAnimation(this , R.anim.scale);
    Animation hieuungtranslate = AnimationUtils.loadAnimation(this , R.anim.translate);
    Animation hieuungRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
*/
    // ánh xạ
    public void Init()
    {
        btnAlpha = (Button)findViewById(R.id.buttonAlpha);
        btnrotate = (Button)findViewById(R.id.buttonRotate);
        btnScale = (Button)findViewById(R.id.buttonScale);
        btnTranslate = (Button)findViewById(R.id.buttonTranslate);
        txtvhieuung = (TextView)findViewById(R.id.textViewhieuung);

    }

    // xử lý Onclick
    public void Xu_kien()
    {
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hieuungzoom = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.scale);

                hieuungzoom.reset();     // reset lại tránh lỗi khi nháy đúp
                txtvhieuung.clearAnimation();    // yêu cầu textview xóa hiệu ứng
                txtvhieuung.startAnimation(hieuungzoom);// yêu cầu nó chạy với hiệu ứng truyền vào
                String s = "hiệu ứng phóng to thu nhỏ";
                txtvhieuung.setText(s);
            }
        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hieuungtranslate = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.translate);
                hieuungtranslate.reset();
                txtvhieuung.clearAnimation();
                txtvhieuung.startAnimation(hieuungtranslate);
                String s = "hiệu ứng Thay đổi vị trí";
                txtvhieuung.setText(s);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hieuungRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

                hieuungRotate.reset();
                txtvhieuung.clearAnimation();
                txtvhieuung.startAnimation(hieuungRotate);
                String s = "hiệu ứng quay ";
                txtvhieuung.setText(s);
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hieuungsangmo = AnimationUtils.loadAnimation(getApplicationContext() ,R.anim.alpha);
                hieuungsangmo.reset();
                txtvhieuung.clearAnimation();
                txtvhieuung.startAnimation(hieuungsangmo);
                String s = "hiệu ứng Sáng Mờ ";
                txtvhieuung.setText(s);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Xu_kien();
    }
}
