package com.example.hientran.onclick_bai1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtvkq;
    Button btntong , btnhieu;
    EditText editso1 , editso2;
    LinearLayout linear_layout;
    CheckBox Cboxon;

    // tạo Context để sử dụng dialog
    Context context = this;
    // button exit
    Button btnexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hàm ánh xạ
        Init();
        // xử lý checkbox
        XuLy_CheckBox();
        // sử lý Dialog
        Method_exit();

    }

    // xử lý onlick với hàm bên ngoài
    public void Init()
    {
        txtvkq = (TextView)findViewById(R.id.TextViewkq);
        btnhieu = (Button)findViewById(R.id.buttonhieu);
        btntong = (Button)findViewById(R.id.buttontong);

        editso1 = (EditText)findViewById(R.id.editTextso1);
        editso2 = (EditText)findViewById(R.id.editTextso2);

        btnexit = (Button)findViewById(R.id.buttonexit);

    }

    // bắt xự kiện onclick thong qua layout
    public void tinhtong(View v)
    {

        // kiểm tra điều kiện
        if(editso1.getText().toString().equalsIgnoreCase("") || editso2.getText().toString().equalsIgnoreCase(""))  // phải dùng
            Toast.makeText(MainActivity.this, "bạn chưa nhập 1 trong 2 số " , Toast.LENGTH_SHORT).show();
        else
        {
            int a = Integer.parseInt(editso1.getText().toString());
            int b = Integer.parseInt(editso2.getText().toString());
            txtvkq.setText("Tổng = " + (a + b));
            Toast.makeText(MainActivity.this, "xuất ra tổng " , Toast.LENGTH_SHORT).show();
        }
    }


    public void tinhhieu(View v)
    {


        if(editso1.getText().toString().equalsIgnoreCase("") || editso2.getText().toString().equalsIgnoreCase(""))
            Toast.makeText(MainActivity.this, "bạn chưa nhập 1 trong 2 số " , Toast.LENGTH_SHORT).show();
        else
        {
            int a = Integer.parseInt(editso1.getText().toString());
            int b = Integer.parseInt(editso2.getText().toString());
            txtvkq.setText("Hiệu = " + (a - b));
            Toast.makeText(MainActivity.this, "xuất ra kết quả hiệu " , Toast.LENGTH_SHORT).show();
        }
    }
    // hàm xử lý LinearLayout
    public void XuLy_CheckBox()
    {
//        // tạo chuỗi hiện thị
//        String s = "";
//        // biến on và off nhạc
//        MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.cryingoveryou);
//        // checkbox được khai báo ở đây lun
//        Cboxon = (CheckBox)findViewById(R.id.checkBoxPlaynhac);
//        if(Cboxon.isChecked())
//        {
//            Cboxon.setChecked(true);
//            song.start();
//            s += "bạn đã bật chế độ nhạc nền ";
//            Toast.makeText(MainActivity.this, s , Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Cboxon.setChecked(false);
//            s += "bạn đã tắt chế độ nhạc nền";
//            song.stop();
//            Toast.makeText(MainActivity.this, s , Toast.LENGTH_SHORT).show();
//        }
        Cboxon = (CheckBox)findViewById(R.id.checkBoxPlaynhac);
        Cboxon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // tạo chuỗi hiện thị
                String s = "";
                // biến on và off nhạc
                MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.cryingoveryou);
                // kiểm tra trường hợp tắt bật lại
                if(!Cboxon.isChecked())    // isChecked có nghĩa checkbox đã được check
                {

                    s += "bạn đã tắt chế độ nhạc nền";
                    song.stop();
                    Toast.makeText(MainActivity.this, s , Toast.LENGTH_SHORT).show();
                    Cboxon.setChecked(true);
                }
                else //if(Cboxon.isChecked())
                {

                    song.start();
                    s += "bạn đã bật chế độ nhạc nền ";
                    Toast.makeText(MainActivity.this, s , Toast.LENGTH_SHORT).show();
                    Cboxon.setChecked(false);
                }
            }
        });
    }

    // hàm exit
    public void Method_exit()
    {

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tạo 1 dailog hỏi xem nguwfoi dùng muốn thoát không
                AlertDialog.Builder b = new AlertDialog.Builder(context);
                // tiêu đề
                b.setTitle("Thoát Ứng Dụng");  // tiêu đề của Dialog
                b.setMessage("bạn có thực sự muốn thoát không ?");  // thông báo Dialog
                b.setNegativeButton("No", null);   // nút No không làm gì cả

                b.setNeutralButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // khi nhấn vào yes sẽ thoát ứng dụng
                                System.exit(0);
                            }
                        }
                );
                b.show();
            }
        });
    }

}
