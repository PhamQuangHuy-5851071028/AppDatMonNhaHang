package com.example.datmonannhahang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datmonannhahang.Bill;
import com.example.datmonannhahang.R;

import java.util.List;

public class BillAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Bill> billList;

    public BillAdapter(Context context, int layout, List<Bill> billList) {
        this.context = context;
        this.layout = layout;
        this.billList = billList;
    }

    @Override
    public int getCount() {
        return billList.size();
    }

    @Override
    public Object getItem(int position) {
        return billList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewHolder {
        TextView txtMonAn, txtGia, txtSoLuong, txtTien;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtMonAn = (TextView) convertView.findViewById(R.id.txtMonAn);
            holder.txtGia = (TextView) convertView.findViewById(R.id.txtGia);
            holder.txtSoLuong = (TextView) convertView.findViewById(R.id.txtSoLuong);
            holder.txtTien = (TextView) convertView.findViewById(R.id.txtTien);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Bill bill = billList.get(position);
        holder.txtMonAn.setText(bill.getTenMon());
        holder.txtGia.setText(bill.getGiaBan());
        holder.txtSoLuong.setText(bill.getSoLuong()+"");
        holder.txtTien.setText(bill.getTien()+"");

        return convertView;
    }
}
