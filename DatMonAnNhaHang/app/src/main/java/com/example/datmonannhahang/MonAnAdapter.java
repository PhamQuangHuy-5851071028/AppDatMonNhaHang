package com.example.datmonannhahang;

import android.content.Context;
import android.content.SharedPreferences;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

       final ViewHolder holder;
//        final SharedPreferences preferences;
//        final SharedPreferences.Editor editor;
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
//           preferences = this.context.getSharedPreferences("Monan", Context.MODE_PRIVATE);
//           editor = preferences.edit();

           holder.cbChon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if(isChecked)
                   {
//                       editor.putBoolean(monAnList.get(position).getID()+"",true);
//                       editor.commit();

                       holder.txtSoLuong.setText("1");
                       holder.imgCong.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               int soluong = Integer.parseInt(holder.txtSoLuong.getText().toString());
                               soluong++;
                               holder.txtSoLuong.setText(soluong+"");
                           }
                       });
                       holder.imgTru.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               int soluong = Integer.parseInt(holder.txtSoLuong.getText().toString());
                               soluong--;
                               if(soluong<0){
                                   holder.txtSoLuong.setText("0");
                               }else
                               holder.txtSoLuong.setText(soluong+"");
                           }
                       });
                   }
                   else
                       holder.txtSoLuong.setText("");
               }

           });
           convertView.setTag(holder);
       }else {
           holder = (ViewHolder) convertView.getTag();
       }
//        boolean trangthai = preferences.getBoolean(monAnList.get(position).getID()+"",false);
//       holder.cbChon.setChecked(trangthai);
       MonChinh monChinh = monAnList.get(position);
       holder.txtMonAn.setText(monChinh.getTenmon());
       holder.txtGia.setText(monChinh.getGiaban());
//        holder.cbChon.setChecked(false);
    return convertView;
    }
}
