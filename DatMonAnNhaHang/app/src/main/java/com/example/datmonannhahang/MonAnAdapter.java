package com.example.datmonannhahang;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Database.Database;

public class MonAnAdapter extends BaseAdapter{

    Database database;
    private Context context;
    private int layout;
    private List<MonChinh> monAnList;
    public int sb;

    public MonAnAdapter(Context context, int layout, List<MonChinh> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return monAnList.size();
    }

    @Override
    public Object getItem(int position) {
          return monAnList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        CheckBox cbChon;
        TextView txtMonAn, txtGia, txtSoLuong;
        ImageView imgCong, imgTru;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

       final ViewHolder holder;

       if(convertView==null){
           holder = new ViewHolder();
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(layout,null);
           holder.txtMonAn = (TextView) convertView.findViewById(R.id.txtMonAn);
           holder.txtGia = (TextView) convertView.findViewById(R.id.txtGia);
           holder.txtSoLuong = (TextView) convertView.findViewById(R.id.txtSoLuong);
           holder.imgCong = (ImageView) convertView.findViewById(R.id.imgTang);
           holder.imgTru = (ImageView) convertView.findViewById(R.id.imgGiam);
           holder.cbChon = (CheckBox) convertView.findViewById(R.id.cbChon);
           holder.cbChon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                   if(isChecked)
                   {
                       holder.txtSoLuong.setText("1");
                       MonChinh monan=monAnList.get(position);
                       database = new Database(context, "bill.sqlite", null, 1);
                       database.QueryData("CREATE TABLE IF NOT EXISTS HoaDon(ID INTEGER PRIMARY KEY, " +
                               "TenMon VARCHAR(200), " + "GiaBan VARCHAR(200), " + "SoLuong INTEGER, "+" Ban INTEGER)");
                       database.QueryData("INSERT INTO HoaDon VALUES("+monan.getID()+", '"+monan.getTenmon()+"'," +
                           " '"+monan.getGiaban()+"', "+Integer.parseInt(holder.txtSoLuong.getText().toString())+", "+sb+")");
                       Toast.makeText(context, "Lưu dữ liệu vào bàn: "+sb+"", Toast.LENGTH_SHORT).show();
                       holder.imgCong.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               int soluong = Integer.parseInt(holder.txtSoLuong.getText().toString());
                               soluong++;
                               holder.txtSoLuong.setText(soluong+"");
                               MonChinh monan=monAnList.get(position);
                       String query = "SELECT * FROM HoaDon WHERE ID= "+ monan.getID();
                               Cursor cursor = database.GetData(query);
                               if(cursor.getCount()>0){
                                   database.QueryData("UPDATE HoaDon SET SoLuong = "+Integer.parseInt(holder.txtSoLuong.getText().toString())+
                                           " WHERE ID= "+monan.getID());
                               }
                               else{
                       database.QueryData("INSERT INTO HoaDon VALUES("+monan.getID()+", '"+monan.getTenmon()+"'," +
                               " '"+monan.getGiaban()+"', "+Integer.parseInt(holder.txtSoLuong.getText().toString())+", "+sb+")");
                               }
                           }
                       });
                       holder.imgTru.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               int soluong = Integer.parseInt(holder.txtSoLuong.getText().toString());
                               soluong--;
                               if(soluong>0){
                                   holder.txtSoLuong.setText(soluong+"");
                                   MonChinh monan=monAnList.get(position);
                                   String query = "SELECT * FROM HoaDon WHERE ID= "+ monan.getID();
                                   Cursor cursor = database.GetData(query);
                                   if(cursor.getCount()>0){
                                       database.QueryData("UPDATE HoaDon SET SoLuong = "+Integer.parseInt(holder.txtSoLuong.getText().toString())+" WHERE ID= "+monan.getID());
                                   }
                                   else{
                                       database.QueryData("INSERT INTO HoaDon VALUES("+monan.getID()+", '"+monan.getTenmon()+"'," +
                                               " '"+monan.getGiaban()+"', "+Integer.parseInt(holder.txtSoLuong.getText().toString())+", "+sb+")");}
                               }else {
                                   holder.txtSoLuong.setText("0");
                                   MonChinh monan=monAnList.get(position);
                                   database.QueryData("DELETE FROM HoaDon WHERE ID= "+monan.getID());
                               }
                           }
                       });
                   }
                   else {
                       holder.txtSoLuong.setText("");
                   MonChinh monan=monAnList.get(position);
                   database.QueryData("DELETE FROM HoaDon WHERE ID= "+monan.getID());
                   }
               }

           });
           convertView.setTag(holder);
       }else {
           holder = (ViewHolder) convertView.getTag();
       }
       MonChinh monChinh = monAnList.get(position);
       holder.txtMonAn.setText(monChinh.getTenmon());
       holder.txtGia.setText(monChinh.getGiaban());
    return convertView;
    }
}
