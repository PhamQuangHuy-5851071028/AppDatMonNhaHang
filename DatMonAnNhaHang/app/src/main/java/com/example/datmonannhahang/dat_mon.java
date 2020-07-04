package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

public class dat_mon extends AppCompatActivity {

    TabHost tabHost;
    public static int selectedTab = 1;

    ListView lvMonchinh, lvMonkhaivi, lvLau, lvDouong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon);
        showTabHost();
        addViews();
    }

    private void addViews() {
        lvMonchinh=findViewById(R.id.lvMonChinh);
        lvMonkhaivi=findViewById(R.id.lvKhaiVi);
        lvLau=findViewById(R.id.lvLau);
        lvDouong=findViewById(R.id.lvDoUong);
    }

    private void showTabHost() {
        tabHost = findViewById(R.id.host);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.monchinh);
        tab1.setIndicator("Món chính");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.monkhaivi);
        tab2.setIndicator("Khai vị");
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab2.setContent(R.id.lau);
        tab2.setIndicator("Lẩu");
        tabHost.addTab(tab3);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4");
        tab2.setContent(R.id.lau);
        tab2.setIndicator("Đồ uống");
        tabHost.addTab(tab4);
    }
}