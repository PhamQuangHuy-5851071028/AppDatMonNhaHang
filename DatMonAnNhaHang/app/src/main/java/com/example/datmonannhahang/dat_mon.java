package com.example.datmonannhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.datmonannhahang.Adapter.BillAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Database.Database;

public class dat_mon extends AppCompatActivity {

    TabHost tabHost;
    int soban;



    SearchView searchView;
    Button btnLuu;
    public static int selectedTab=1;
    ListView lvMonchinh, lvMonkhaivi, lvLau, lvDouong;
    String urlGetDataMonChinh = "https://appdatmonan.000webhostapp.com/KetNoi/getDataMonChinh.php";
    String urlGetDataKhaiVi = "https://appdatmonan.000webhostapp.com/KetNoi/getDataKhaiVi.php";
    String urlGetDataLau = "https://appdatmonan.000webhostapp.com/KetNoi/getDataLau.php";
    String urlGetDataDoUong = "https://appdatmonan.000webhostapp.com/KetNoi/getDataDoUong.php";
    String urlTimKiemMC = "https://appdatmonan.000webhostapp.com/KetNoi/timkiemMC.php?key=";
    String urlTimKiemKV = "https://appdatmonan.000webhostapp.com/KetNoi/timkiemKV.php?key=";
    String urlTimKiemL = "https://appdatmonan.000webhostapp.com/KetNoi/timkiemL.php?key=";
    String urlTimKiemDU = "https://appdatmonan.000webhostapp.com/KetNoi/timkiemDU.php?key=";


    public ArrayList<MonChinh> arrayMonChinh, arrayKhaiVi, arrayLau, arrayDoUong;
    public MonAnAdapter monchinhAdapter, khaiviAdapter, lauAdapter, douongAdapter;
    public ArrayList<Bill> arrayBill;
    public BillAdapter billAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon);
        showTabHost();
        addViews();
        addEvents();
        getdataban();
        getdataMonChinh(urlGetDataMonChinh);
        getdataKhaiVi(urlGetDataKhaiVi);
        getdataLau(urlGetDataLau);
        getdataDoUong(urlGetDataDoUong);

    }



    private void addEvents() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.trim().length()>4){
                    timkiemMC(urlTimKiemMC+newText.trim().toLowerCase());
                    timkiemKV(urlTimKiemKV+newText.trim().toLowerCase());
                    timkiemL(urlTimKiemL+newText.trim().toLowerCase());
                    timkiemDU(urlTimKiemDU+newText.trim().toLowerCase());

                }
                else {
                    getdataMonChinh(urlGetDataMonChinh);
                    getdataKhaiVi(urlGetDataKhaiVi);
                    getdataLau(urlGetDataLau);
                    getdataDoUong(urlGetDataDoUong);

                }

                return false;
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenchinhsuaban = new Intent(dat_mon.this, ChinhSuaBill.class);
                startActivity(chuyenchinhsuaban);
            }
        });

    }


    private void addViews() {
        lvMonchinh=findViewById(R.id.lvMonChinh);
        lvMonkhaivi=findViewById(R.id.lvKhaiVi);
        lvLau=findViewById(R.id.lvLau);
        lvDouong=findViewById(R.id.lvDoUong);
        searchView=findViewById(R.id.svTimKiem);
        btnLuu=findViewById(R.id.btnLuu);

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
        arrayMonChinh.clear();
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
        arrayKhaiVi.clear();
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
        arrayLau.clear();
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
        arrayDoUong.clear();
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

    private void timkiemMC(String url){
        selectedTab=1;
        arrayMonChinh.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                arrayMonChinh.clear();
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
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void timkiemKV(String url){
        selectedTab=2;
        arrayKhaiVi.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                arrayKhaiVi.clear();
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
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void timkiemL(String url){
        selectedTab=3;
        arrayLau.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                arrayLau.clear();
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
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void timkiemDU(String url){
        selectedTab=4;
        arrayDoUong.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                arrayDoUong.clear();
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
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    public final int getdataban() {
        //Intent intent = getIntent();
        monchinhAdapter.sb=getIntent().getIntExtra("ban", 0);
        khaiviAdapter.sb=getIntent().getIntExtra("ban", 0);
        douongAdapter.sb=getIntent().getIntExtra("ban", 0);
        lauAdapter.sb=getIntent().getIntExtra("ban", 0);

        soban= getIntent().getIntExtra("ban", 0);
        Log.e(">> So ban: ", soban+"" );
        SharedPreferences sharedPreferences=this.getSharedPreferences("huy",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("soban",soban);
        editor.apply();
        Toast.makeText(this, "Đã chọn bàn: "+soban, Toast.LENGTH_SHORT).show();
        return soban;
    }


}
