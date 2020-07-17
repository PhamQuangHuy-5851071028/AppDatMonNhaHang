package com.example.datmonannhahang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDatmonan, btnSuamonan, btnThanhtoan;
    TabHost tabHost;
    ImageView imgFB, imgPhone;
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
        imgFB=findViewById(R.id.imgFB);
        imgPhone=findViewById(R.id.imgPhone);
    }

    private void addEvents() {
        btnDatmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moban();
            }
        });

        imgFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/QHuyPham.3399/"));
                startActivity(intent);
            }
        });
        imgPhone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                xyLyCall();
            }
        });
    }

    String[] listPermissions=new String[]{Manifest.permission.CALL_PHONE};

    boolean checkPermission(String per){
        if(ContextCompat.checkSelfPermission(this,per)!= PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void xyLyCall() {
        if(!checkPermission(Manifest.permission.CALL_PHONE))
        {
            this.requestPermissions(listPermissions,0);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri uri = Uri.parse("tel:" + "0977869590");
            intent.setData(uri);
            startActivity(intent);
        }

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