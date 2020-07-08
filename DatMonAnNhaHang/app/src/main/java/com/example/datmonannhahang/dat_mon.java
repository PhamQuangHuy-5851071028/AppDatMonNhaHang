package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DownloadManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
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

    public static int selectedTab=1;
    ListView lvMonchinh, lvMonkhaivi, lvLau, lvDouong;
    String urlGetDataMonChinh = "http://172.17.7.246/nhahang/getDataMonChinh.php";
    String urlGetDataKhaiVi = "http://172.17.7.246/nhahang/getDataKhaiVi.php";
    String urlGetDataLau = "http://172.17.7.246/nhahang/getDataLau.php";
    String urlGetDataDoUong = "http://172.17.7.246/nhahang/getDataDoUong.php";
    String urlTimKiem = "http://172.17.7.246/nhahang/timkiem.php";


    public ArrayList<MonChinh> arrayMonChinh, arrayKhaiVi, arrayLau, arrayDoUong;
    public MonAnAdapter monchinhAdapter, khaiviAdapter, lauAdapter, douongAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon);
        showTabHost();
        addViews();
        getdataMonChinh(urlGetDataMonChinh);
        getdataKhaiVi(urlGetDataKhaiVi);
        getdataLau(urlGetDataLau);
        getdataDoUong(urlGetDataDoUong);


    }


    private void addViews() {
        lvMonchinh=findViewById(R.id.lvMonChinh);
        lvMonkhaivi=findViewById(R.id.lvKhaiVi);
        lvLau=findViewById(R.id.lvLau);
        lvDouong=findViewById(R.id.lvDoUong);

        //Tab1
        arrayMonChinh = new ArrayList<>();
        monchinhAdapter = new MonAnAdapter(this, R.layout.list_mon_chinh, arrayMonChinh);
        lvMonchinh.setAdapter(monchinhAdapter);



        //Tab2
        arrayKhaiVi = new ArrayList<>();
        khaiviAdapter = new MonAnAdapter(this, R.layout.list_mon_chinh, arrayKhaiVi);
        lvMonkhaivi.setAdapter(khaiviAdapter);

        //Tab3
        arrayLau = new ArrayList<>();
        lauAdapter = new MonAnAdapter(this, R.layout.list_mon_chinh, arrayLau);
        lvLau.setAdapter(lauAdapter);

        //Tab4
        arrayDoUong = new ArrayList<>();
        douongAdapter = new MonAnAdapter(this, R.layout.list_mon_chinh, arrayDoUong);
        lvDouong.setAdapter(douongAdapter);
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
        selectedTab=1;
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

    private void getdataKhaiVi(String url){
        selectedTab=2;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayKhaiVi.add(new MonChinh(
                                object.getInt("ID"),
                                object.getString("TenMon"),
                                object.getString("GiaBan")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                   khaiviAdapter.notifyDataSetChanged();
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

    private void getdataLau(String url){
        selectedTab=3;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayLau.add(new MonChinh(
                                object.getInt("ID"),
                                object.getString("TenMon"),
                                object.getString("GiaBan")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    lauAdapter.notifyDataSetChanged();
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

    private void getdataDoUong(String url){
        selectedTab=4;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayDoUong.add(new MonChinh(
                                object.getInt("ID"),
                                object.getString("TenMon"),
                                object.getString("GiaBan")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    douongAdapter.notifyDataSetChanged();
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem mnSearch = menu.findItem(R.id.mnSearch);
        SearchView searchView = (SearchView) mnSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//               getdataMonChinh(urlTimKiem);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}