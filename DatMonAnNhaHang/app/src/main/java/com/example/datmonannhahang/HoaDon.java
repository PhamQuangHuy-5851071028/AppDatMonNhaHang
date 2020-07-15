package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.datmonannhahang.Adapter.BillAdapter;

import java.util.ArrayList;

import Database.Database;

public class HoaDon extends AppCompatActivity {

    TextView txtTongTien;
    ListView lvBill;
    Spinner spSoBan;
    Database database;

    public ArrayList<Bill> arrayBill;
    public BillAdapter billAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        addViews();
        addEvents();
        PrepareDB();
        getData();
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

        arrayBill = new ArrayList<>();
        billAdapter = new BillAdapter(this, R.layout.list_bill, arrayBill);
        lvBill.setAdapter(billAdapter);
    }
    private void PrepareDB() {
        //Create Database
        database = new Database(this, "bill.sqlite", null, 1);
        //Create Table
        database.QueryData("CREATE TABLE IF NOT EXISTS HoaDon(ID INTEGER PRIMARY KEY, " +
                "TenMon VARCHAR(200), " + "GiaBan VARCHAR(200), " + "SoLuong INTEGER)");
       // database.QueryData("DELETE FROM HoaDon");
        //database.QueryData("INSERT INTO HoaDon VALUES(2, 'Heo quay', '150000', 2)");
    }
    private void getData() {
        Cursor c = database.GetData("SELECT * FROM HoaDon");
        //arrayBill.clear();
        while (c.moveToNext()){
            int ID = c.getInt(0);
            String TenMon = c.getString(1);
            String GiaBan = c.getString(2);
            int SoLuong = c.getInt(3);
            arrayBill.add(new Bill(ID, TenMon, GiaBan, SoLuong));
        }
        billAdapter.notifyDataSetChanged();
    }
}