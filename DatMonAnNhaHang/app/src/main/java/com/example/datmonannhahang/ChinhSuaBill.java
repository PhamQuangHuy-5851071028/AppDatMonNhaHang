package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datmonannhahang.Adapter.BillAdapter;

import java.util.ArrayList;

import Database.Database;

public class ChinhSuaBill extends AppCompatActivity {


    TextView txtTongTien;
    ListView lvBill;

    Database database;
    Button btnThanhToan;

    public ArrayList<Bill> arrayBill;
    public BillAdapter billAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_bill);

        addViews();
        addEvents();
        PrepareDB();
        getData();

    }

    private void addEvents() {

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thanhtoan = new Intent(ChinhSuaBill.this, HoaDon.class);
                startActivity(thanhtoan);
            }
        });
    }

    private void addViews() {
        txtTongTien=findViewById(R.id.txtTongTien);
        lvBill=findViewById(R.id.lvBill);
        btnThanhToan=findViewById(R.id.btnThanhToan);

        arrayBill = new ArrayList<>();
        billAdapter = new BillAdapter(this, R.layout.list_bill, arrayBill);
        lvBill.setAdapter(billAdapter);
    }
    private void PrepareDB() {

        database = new Database(this, "bill.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS HoaDon(ID INTEGER PRIMARY KEY, " +
                "TenMon VARCHAR(200), " + "GiaBan VARCHAR(200), " + "SoLuong INTEGER, "+" Ban INTEGER)");


    }
    private void getData() {
        Cursor c = database.GetData("SELECT * FROM HoaDon");
        //arrayBill.clear();
        while (c.moveToNext()){
            int ID = c.getInt(0);
            String TenMon = c.getString(1);
            String GiaBan = c.getString(2);
            int SoLuong = c.getInt(3);
            int Ban = c.getInt(4);
            arrayBill.add(new Bill(ID, TenMon, GiaBan, SoLuong, Ban));
        }
        billAdapter.notifyDataSetChanged();
    }
}