package com.example.hientran.thiepgiangsinh;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // đặt tên biến
     RelativeLayout bg1;
    MediaPlayer song;
    ImageView imvloan;
    TextView txtvloichucbg;
    ImageView iconcontinue;
    Button btnexxit;
    // chuyển màn hình
    //Intent Mhmusic = new Intent(getApplicationContext() , Music.class);  // màn hình đang đứng getApplicationContext đi đến Music.class


    // ánh xạ
    public void Init()
    {
       bg1 = (RelativeLayout)findViewById(R.id.manhinh);  // màn hình background
        imvloan = (ImageView)findViewById(R.id.imageViewloan);
        txtvloichucbg = (TextView)findViewById(R.id.textViewbackground);
        iconcontinue = (ImageView)findViewById(R.id.imageViewcontinue);
        btnexxit = (Button)findViewById(R.id.buttonexit);
        song = MediaPlayer.create(getApplicationContext() , R.raw.lastchristmas);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();

        // màn hình nền
        //bg1.setBackgroundResource(R.drawable.bg1);

        // nhạc nền   getApplicationContext được hiểu là màn hình đang đứng có thể dùng MainActivity.this
        song.start();

        // hiệu ứng chữ
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation1.reset();
        txtvloichucbg.clearAnimation();
        txtvloichucbg.startAnimation(animation1);

        // hiệu ứng cho hình
        // ý nghĩa animation2 là AnimationUtils load nó loadAnimation(màn hình đang đứng ,hiệu ứng đã tạo)
        Animation animation2 = AnimationUtils.loadAnimation(this , R.anim.fade);  // sử dụng translate

        animation2.reset();                  // restart vì nhiều trường hơp họ muốn quay từ đầu
        imvloan.clearAnimation();   // yêu cầu tấm hình xóa hiệu ứng nó đang chạy
        imvloan.startAnimation(animation2);  // yêu cầu tấm hình chạy với hiệu ứng là animation2

        // sự kiện để chuyển qua màn hình thứ 2
//        iconcontinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                song.stop();
//                Intent Mhmusic = new Intent(getApplicationContext() , Music.class);  // màn hình đang đứng getApplicationContext đi đến Music.class
//                startActivity(Mhmusic);  // start nó lên
//
//            }
//        });

        // nút Exit
        btnexxit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    public void Click_continue(View v)
    {
        Intent Mhmusic = new Intent(getApplicationContext() , Music.class);
        song.stop();
        startActivity(Mhmusic);  // start nó lên
    }
    public void text_Continue(View v)
    {
        Intent Mhmusic = new Intent(getApplicationContext() , Music.class);
        song.stop();
        startActivity(Mhmusic);
    }

    // hàm bắt phím hệ thống
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(MainActivity.this , " Back " , Toast.LENGTH_SHORT).show();
            b.setTitle("Lựa Chọn");
            b.setMessage("Muốn Thoát Hả Loan ? " + "\n" + "Hi giáng sinh vui vẻ nhé ");
            b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);  // thoát
                }
            });
            b.setNeutralButton("No" , null);
            b.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
