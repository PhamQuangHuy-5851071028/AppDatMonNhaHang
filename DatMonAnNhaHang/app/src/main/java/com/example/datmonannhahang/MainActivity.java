package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDatmonan, btnSuamonan, btnThanhtoan;
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
                modatmon();
            }
        });
    }

    private void modatmon() {
        Intent datmon = new Intent(this, dat_mon.class);
        startActivity(datmon);
    }


}