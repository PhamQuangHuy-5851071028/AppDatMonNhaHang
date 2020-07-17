package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.datmonannhahang.Adapter.BillAdapter;

import org.w3c.dom.Text;

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
                "TenMon VARCHAR(200), " + "GiaBan VARCHAR(200), " + "SoLuong INTEGER , " + "Tien INTEGER)");

//        database.QueryData("DELETE TABLE HoaDon");

//        database.QueryData("DELETE FROM HoaDon");
//        database.QueryData("INSERT INTO HoaDon VALUES(1, 'Gà chiên', '50000', 2, 100000)");
//        database.QueryData("INSERT INTO HoaDon VALUES(2, 'Thịt kho hột vịt', '30000', 2, 60000)");
//        database.QueryData("INSERT INTO HoaDon VALUES(3, 'Cá chép kho tương', '70000', 2, 140000)");
//        database.QueryData("SELECT Tien FROM HoaDon WHERE Tien=GiaBan*SoLuong");

    }
    private void getData() {
        Cursor c = database.GetData("SELECT * FROM HoaDon");
        //arrayBill.clear();
        while (c.moveToNext()){
            int ID = c.getInt(0);
            String TenMon = c.getString(1);
            String GiaBan = c.getString(2);
            int SoLuong = c.getInt(3);
            int Tien = c.getInt(4);
            arrayBill.add(new Bill(ID, TenMon, GiaBan, SoLuong, Tien));
        }
        billAdapter.notifyDataSetChanged();
    }

    public void Xuathoadon(View view) {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận hóa đơn");
        b.setIcon(R.drawable.icon);
        b.setMessage("Tổng tiền hóa đơn của bạn là " + txtTongTien.getText().toString() + " đồng" +"\nCảm ơn và hẹn gặp lại");
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }
}