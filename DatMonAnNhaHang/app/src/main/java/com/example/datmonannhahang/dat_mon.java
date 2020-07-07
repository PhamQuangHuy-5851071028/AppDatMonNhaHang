package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class dat_mon extends AppCompatActivity {

    TabHost tabHost;
    public static int selectedTab = 1;

    ListView lvMonchinh, lvMonkhaivi, lvLau, lvDouong;
    String urlGetDataMonChinh = "http://192.168.1.46/nhahang/getdata.php";

    ArrayList<MonChinh> arrayMonChinh;
    MonAnAdapter monchinhAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon);
        showTabHost();
        addViews();
        getdataMonChinh(urlGetDataMonChinh);
    }

    private void addViews() {
        lvMonchinh=findViewById(R.id.lvMonChinh);
        lvMonkhaivi=findViewById(R.id.lvKhaiVi);
        lvLau=findViewById(R.id.lvLau);
        lvDouong=findViewById(R.id.lvDoUong);
        arrayMonChinh = new ArrayList<>();
        monchinhAdapter = new MonAnAdapter(this, R.layout.list_mon_chinh, arrayMonChinh);
        lvMonchinh.setAdapter(monchinhAdapter);
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
        tab3.setContent(R.id.lau);
        tab3.setIndicator("Lẩu");
        tabHost.addTab(tab3);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4");
        tab4.setContent(R.id.douong);
        tab4.setIndicator("Đồ uống");
        tabHost.addTab(tab4);
    }
    private void getdataMonChinh(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayMonChinh.add(new MonChinh(
                                object.getInt("ID"),
                                object.getString("TenMon"),
                                object.getString("GiaBan")
                                ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    monchinhAdapter.notifyDataSetChanged();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    Toast.makeText(dat_mon.this, "Lỗi!", Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}