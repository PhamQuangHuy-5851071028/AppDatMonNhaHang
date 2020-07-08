package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    Button btnDatmonan, btnSuamonan, btnThanhtoan;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addViews();
        addEvents();
    }

    private void addViews() {
        btnDatmonan=findViewById(R.id.btnDatMonAn);
        btnSuamonan=findViewById(R.id.btnSuaMonAn);
        btnThanhtoan=findViewById(R.id.btnThanhToan);
    }

    private void addEvents() {
        btnDatmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moban();
            }
        });
    }

    private void moban() {
        Intent ban = new Intent(this, ban.class);
        startActivity(ban);
    }


    public void thanhtoan(View view) {
        Intent thanhtoan = new Intent(this, HoaDon.class);
        startActivity(thanhtoan);
    }
}