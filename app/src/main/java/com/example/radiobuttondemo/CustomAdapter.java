package com.example.radiobuttondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context    context;
    int layoutid;
    ArrayList<HoaDon> hoaDons = new ArrayList<>();
    public CustomAdapter(@NonNull Context context, int layoutid, ArrayList<HoaDon> hoaDons){
        super(context,layoutid);
        this.context=context;
        this.layoutid=layoutid;
        this.hoaDons = hoaDons;

    }
    @Override
    public int getCount(){
        return hoaDons.size();
    }
    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater =(LayoutInflater.from(context));
        convertView = inflater.inflate(layoutid,null);
        TextView tvnhanVien =convertView.findViewById(R.id.tvnhanVien);
        TextView tvsanPham = convertView.findViewById(R.id.tvsanPham);
        TextView tvDay = convertView.findViewById(R.id.tvDay);
        tvnhanVien.setText(hoaDons.get(position).getNhanVien());
        tvsanPham.setText(hoaDons.get(position).getSanPham());
        tvDay.setText(hoaDons.get(position).getNgay());
        return convertView;

    }
}
