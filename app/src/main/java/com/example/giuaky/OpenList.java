package com.example.giuaky;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OpenList extends AppCompatActivity {

    TextView txtview;
    TextView txtview2;
    TextView txtquocgia;
    TextView txtsao;
    ImageView imghinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);
        AnhXa();
        txtview.setText(getIntent().getStringExtra("Tên"));
        txtview2.setText(getIntent().getStringExtra("Nghệ danh"));

        txtquocgia.setText(getIntent().getStringExtra("Quốc gia"));
        txtsao.setText(getIntent().getStringExtra("Số sao"));
        imghinh.setImageResource(getIntent().getIntExtra("Hinh",0));
    }

    private void AnhXa() {
        txtview = (TextView) findViewById(R.id.ten1);
        txtview2 = (TextView) findViewById(R.id.ten2);
        txtquocgia = (TextView) findViewById(R.id.textViewquocgia);
        txtsao= (TextView) findViewById(R.id.textViewsao);
        imghinh = (ImageView) findViewById(R.id.hinh1);
    }
}