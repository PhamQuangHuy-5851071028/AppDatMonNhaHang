package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
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
    Spinner spSoBan;
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

        String []soban ={"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> sobanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, soban);
        sobanAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spSoBan.setAdapter(sobanAdapter);

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
        spSoBan=findViewById(R.id.spSoBan);
        btnThanhToan=findViewById(R.id.btnThanhToan);

        arrayBill = new ArrayList<>();
        billAdapter = new BillAdapter(this, R.layout.list_bill, arrayBill);
        lvBill.setAdapter(billAdapter);
    }
    private void PrepareDB() {

        database = new Database(this, "bill.sqlite", null, 1);
//        database.QueryData("Use database bill.sqlite");
//        //Create Table
        database.QueryData("CREATE TABLE IF NOT EXISTS HoaDon(ID INTEGER PRIMARY KEY, " +
                "TenMon VARCHAR(200), " + "GiaBan VARCHAR(200), " + "SoLuong INTEGER, "+" Ban INTEGER)");

//        database.QueryData("DELETE TABLE HoaDon");

//        database.QueryData("INSERT INTO HoaDon VALUES(5, 'Xương heo hầm măng', '75000', 1, 75000)");

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
    public void openDialogEditTask(final int ID, int SoLuong){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_edit);

        final EditText edtSoLuong = dialog.findViewById(R.id.edtSL);
        Button btnEditTask = dialog.findViewById(R.id.btnEdit);
        Button btnCancel = dialog.findViewById(R.id.btnCancelEdit);

        edtSoLuong.setText(SoLuong);

        btnEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSL = edtSoLuong.getText().toString();
                database.QueryData("UPDATE HoaDon SET SoLuong = '" + newSL + "' WHERE ID = " + ID);
                Toast.makeText(ChinhSuaBill.this, "Chỉnh sửa hoàn tất", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getData();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}