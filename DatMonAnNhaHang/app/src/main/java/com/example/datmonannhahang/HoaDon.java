package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class HoaDon extends AppCompatActivity {

    TextView txtTongTien;
    ListView lvBill;
    Spinner spSoBan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        addViews();
        addEvents();
    }

    private void addEvents() {
        String []soban ={"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> sobanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, soban);
        sobanAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spSoBan.setAdapter(sobanAdapter);
    }

    private void addViews() {
        txtTongTien=findViewById(R.id.txtTongTien);
        lvBill=findViewById(R.id.lvBill);
        spSoBan=findViewById(R.id.spSoBan);
    }
}