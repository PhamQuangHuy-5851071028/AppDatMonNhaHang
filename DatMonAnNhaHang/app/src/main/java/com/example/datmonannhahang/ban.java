package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ban extends AppCompatActivity {

    ImageView imgBan1, imgBan2, imgBan3, imgBan4, imgBan5, imgBan6, imgBan7, imgBan8, imgBan9,imgBan10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);

        addViews();
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

    public void chuyenban(View view) {
        modatmon();
    }

    private void modatmon() {
        Intent datmon = new Intent(this, dat_mon.class);
        startActivity(datmon);
    }
}