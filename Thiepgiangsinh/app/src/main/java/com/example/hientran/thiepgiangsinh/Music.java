package com.example.hientran.thiepgiangsinh;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    TextView txtvloinhan;
    ListView lvbaihat;
    MediaPlayer song;

    // khai báo mảng
    ArrayList<String> mangTenBaiHat , mangLoiNhan;
    ArrayList<Integer> mangMp3;

    public void anhxa()
    {
        txtvloinhan = (TextView)findViewById(R.id.textViewloinhan);
        lvbaihat = (ListView)findViewById(R.id.listViewbaihat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // gọi hàm ánh xạ
        anhxa();

        // nhac nền
        song = MediaPlayer.create(getApplication() , R.raw.letlovebelove);
        song.start();

        // lời nhắn
        String loinhan = "Nghe Nhạc Vui Vẻ Nhé Hì Nhạc Tuyển Không Á Hì !! ";
        txtvloinhan.setText(loinhan);
        // gán hiệu ứng luôn
        Create_Animation();


        // tạo mảng
         Taomang();

         // listView
        /*
        * tạo một biến adapter biến chứa và mangTenBaiHat đóng vai trò dữ liệu đổ vào adapter
        *  android.R.layout.simple_list_item_1 ==> là kiểu hiện thị của listView
        *  */
        ArrayAdapter adapter =  new ArrayAdapter(
                getApplicationContext() , android.R.layout.simple_list_item_1 , mangTenBaiHat
        );


        // listView Onclickitem
        lvbaihat.setAdapter(adapter);
        lvbaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // phải cho nó dừng sau đó gán cho nó cái mời
                song.stop();
                song = MediaPlayer.create(getApplication(), mangMp3.get(position));    // position là phần tử thứ
                song.start();
                txtvloinhan.setText(mangLoiNhan.get(position));
                // mỗi lần gettext lại thì cũng chạy hiệu ứng
                Create_Animation();
            }
        });

        // bắt sự kiện cho text lời nhắn
        txtvloinhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                song = MediaPlayer.create(getApplication() , R.raw.letlovebelove);
                song.start();
            }
        });

    }

    // bắt sự kiện khi bấm nút back
/*
* bị lỗi khi quay về màn hình chính thì dialog bắt không chuẩn xác nữa Vì sao ?
bởi vì Activity kia vẫn đang hoạt động nên phải dùng 
main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK)
        {
            song.stop();
            Intent main = new Intent(Music.this.finsh() , MainActivity.class); 
            main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(main);
            Toast.makeText(this, "trở về màn hình đầu " , Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }

    // hàm Animation
    public void Create_Animation(){
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        zoom.reset();
        txtvloinhan.clearAnimation();
        txtvloinhan.setAnimation(zoom);
    }

    // tạo mảng
    public void Taomang(){

        mangMp3 = new ArrayList<Integer>();
        mangTenBaiHat = new ArrayList<String>();
        mangLoiNhan =  new ArrayList<String>();

        // lời chúc 1
        mangMp3.add(R.raw.feliznavidadnoney);
        mangTenBaiHat.add("Feliznavi Dadnoney");
        mangLoiNhan.add("———★——–\n" +
                "———-**——–\n" +
                "———*o*——–\n" +
                "——-*♥*o*——-\n" +
                "——***o***——-\n" +
                "—-**o**♥*o*—–\n" +
                "—**♥**o**o**—-\n" +
                "–**o**♥***♥*o*–\n" +
                "-*****♥*o**o*****\n" +
                "**♥**o*****o**♥**\n" +
                "—-__ _!_!____—\n" +
                "—-\\_________/—\n" +
                "Chúc cậu đón nhận\n" +
                "Giáng sinh an lành\n" +
                "và một năm mới\n" +
                "hạnh phúc! ^^");

        // lời chúc 2
        mangMp3.add(R.raw.jinglebells);
        mangTenBaiHat.add("Jingle Bells");
        mangLoiNhan.add("。☆2016☆ 。\n" +
                "★。＼｜／。★\n" +
                "—-。 Merry 。—\n" +
                "★。／｜＼。★\n" +
                "。☆ ☆。。☆ ☆。\n" +
                "。☆2016☆ 。\n" +
                "★。＼｜／。★\n" +
                "–。Christmas。–\n" +
                "★。／｜＼。★\n" +
                "。☆ ☆。。☆ ☆。\n" +
                "♥ Chúc bạn của tớ ♥\n" +
                "♥ Giáng sinh vui vẻ ♥\n" +
                "♥ Ấm áp, anh lành♥\n" +
                "♥ Và Hạnh phúc^^ ♥ ");

        // lời chúc 3
        mangMp3.add(R.raw.warmfuzzy);
        mangTenBaiHat.add("Warm Fuzzy");
        mangLoiNhan.add("\n" +
                "–_I.I_———,☆,\n" +
                "–(•.•)——-,★,,★,\n" +
                "<( : )>—–,☆*;*☆,\n" +
                "-(_._)— `´`´∩`´`´\n" +
                "♫♫♫ Noel Đến…\n" +
                "\u2028♀ღ♥ღ °Chúc cậu\n" +
                "°một °mùa °Giáng °\n" +
                "sinh °vui °vẻ °và\n" +
                "°ấm °áp ֽღ♥ღ ");

        // lời chúc 4
        mangMp3.add(R.raw.wewishyoumerrychristmas);
        mangTenBaiHat.add("We Wish You A Merry Christmas");
        mangLoiNhan.add("\n" +
                "(¯`v´¯)….l.o.v.e…..\n" +
                ".`•.¸. • ´………y.o.u…\n" +
                "¸.•… ´¸.•´¨) ¸.•”¨……\n" +
                "(¸.•´ (¸.•´ .•´ ¸¸.•¨¯`•\n" +
                "-:¦:-•:*’.☆.’*:•-:¦:-\n" +
                "-:¦:-•:.,’*:••:*’,.:•-:¦:-\n" +
                "_ Merry ღ Christmas _\n" +
                "-:¦:**.’*:•:*’**:¦:-\n" +
                "°Giáng °sinh＊ấm áp\n" +
                "-:¦:-•:*’*:•:*’*:•-:¦:-\n" +
                "Khi bạn nhận được tin\n" +
                "nhắn này thì hãy cười\n" +
                "đi nhé, vì ít nhất đâu đó\n" +
                "quanh đây có một người\n" +
                "mong bạn vui vẻ và luôn\n" +
                "yêu đời. Mùa đông ấm áp\n" +
                "hơn khi có một nụ cười.\n" +
                "Merry Xmas ^^! ");

        // lời chúc 5
        mangMp3.add(R.raw.whenwintercomes);
        mangTenBaiHat.add("When Winter Comes");
        mangLoiNhan.add("———()”,,() ღ—–\n" +
                "——–(◑␣◑).——–\n" +
                "—-25-12-2016—–\n" +
                "Giáng sinh vui vẻ\n" +
                "An lành, hạnh phúc\n" +
                "♥ ♫♫♫♫♫ ♥..☆..\n" +
                "..Happy Day ..☆\n" +
                "..♥ ♫♫♫♫♫ ♥..\n" +
                "Chúc cho cậu một\n" +
                "Giáng sinh ấm áp\n" +
                "Bên người thân ^^");

        // lời chúc 6
        mangMp3.add(R.raw.muadongyeuthuong);
        mangTenBaiHat.add("Mùa Đông Yêu Thương");
        mangLoiNhan.add("(⁀‵⁀,) ♡♥♡.•♡♥♡¸.•\n" +
                ".`⋎ ¸.•°*”˜2016˜”*°•.\n" +
                "Vậy là noel đến rồi …\n" +
                "Một năm cũ sắp qua và\n" +
                "Một năm mới đang tới.\n" +
                "Giáng Sinh vui vẻ bạn nhé!\n" +
                "•✤─█▄◯╲╱☰─✤• ^^");
    }

}

