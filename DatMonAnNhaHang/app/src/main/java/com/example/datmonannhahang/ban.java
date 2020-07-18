package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

public class ban extends AppCompatActivity {

    ImageView imgBan1, imgBan2, imgBan3, imgBan4, imgBan5, imgBan6, imgBan7, imgBan8, imgBan9,imgBan10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);

        addViews();
        addEvents();
    }



    private void addViews() {
        imgBan1=findViewById(R.id.ban1);
        imgBan2=findViewById(R.id.ban2);
        imgBan3=findViewById(R.id.ban3);
        imgBan4=findViewById(R.id.ban4);
        imgBan5=findViewById(R.id.ban5);
        imgBan6=findViewById(R.id.ban6);
        imgBan7=findViewById(R.id.ban7);
        imgBan8=findViewById(R.id.ban8);
        imgBan9=findViewById(R.id.ban9);
        imgBan10=findViewById(R.id.ban10);
    }
    private void addEvents() {
        imgBan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 1);
                startActivity(datmon);
            }
        });
        imgBan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 2);
                startActivity(datmon);
            }
        });
        imgBan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 3);
                startActivity(datmon);
            }
        });
        imgBan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 4);
                startActivity(datmon);
            }
        });
        imgBan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 5);
                startActivity(datmon);
            }
        });
        imgBan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 6);
                startActivity(datmon);
            }
        });
        imgBan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 7);
                startActivity(datmon);
            }
        });
        imgBan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 8);
                startActivity(datmon);
            }
        });
        imgBan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 9);
                startActivity(datmon);
            }
        });
        imgBan10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent datmon = new Intent(ban.this, dat_mon.class);
                datmon.putExtra("ban", 10);
                startActivity(datmon);
            }
        });
    }


}