package com.example.datmonannhahang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonAnAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<MonChinh> monAnList;

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
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder holder;
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
