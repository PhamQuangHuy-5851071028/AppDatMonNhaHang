package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datmonannhahang.Adapter.BillAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Database.Database;

public class HoaDon extends AppCompatActivity {

    TextView txtTongTien, txtSoBan;
    ListView lvBill;
    Database database;

    public ArrayList<Bill> arrayBill;
    public BillAdapter billAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        addViews();
        PrepareDB();
        getData();
    }

    private void addViews() {
        txtTongTien=findViewById(R.id.txtTongTien);
        lvBill=findViewById(R.id.lvBill);
        txtSoBan=findViewById(R.id.txtsoban);

        arrayBill = new ArrayList<>();
        billAdapter = new BillAdapter(this, R.layout.list_bill, arrayBill);
        lvBill.setAdapter(billAdapter);

    }
    private void PrepareDB() {
        //Create Database
        database = new Database(this, "bill.sqlite", null, 1);
        //Create Table
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
        int TongTien=0;
        for (Bill item: arrayBill
             ) {
            TongTien+=Integer.parseInt(item.getGiaBan())*item.getSoLuong();

        }
        txtTongTien.setText(TongTien+"");
        SharedPreferences sharedPreferences=this.getSharedPreferences("huy",MODE_PRIVATE);
        int soban=sharedPreferences.getInt("soban",0);
        txtSoBan.setText(""+soban);
        billAdapter.notifyDataSetChanged();

    }
//    public void setTxtSoBan(int soban){
//        txtSoBan.setText(soban+"");
//    }
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
                database.QueryData("DELETE FROM HoaDon");
                Intent thanhtoan = new Intent(HoaDon.this, MainActivity.class);
                startActivity(thanhtoan);
                finish();
            }
        });
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }

}