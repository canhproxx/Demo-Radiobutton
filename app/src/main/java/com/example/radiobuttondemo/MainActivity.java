package com.example.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtDay, edtsoLuong;
    Spinner spnnhanVien,spnsanPham;
    Button btnThem,btnXoa,btnSua,btnThoat;
    ListView lsvData;
    ArrayList nhanVien = new ArrayList();
    ArrayList sanPham = new ArrayList();
    ArrayList<HoaDon> hoaDons = new ArrayList<>();
    int index=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        nhanVien.add("Nguyễn Hữu Cảnh");
        nhanVien.add("Lý Thiên Du");
        nhanVien.add("Nguyễn Thị Kim Tuyến");
        ArrayAdapter adapterNV = new ArrayAdapter(this,android.R.layout.simple_spinner_item,nhanVien);
        spnnhanVien.setAdapter(adapterNV);
        sanPham.add("Samsung Galaxy Note 10");
        sanPham.add("Iphone XS");
        sanPham.add("Sony Xperia XZ 2");
        sanPham.add("Nokia 1280");
        ArrayAdapter adapterSP = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sanPham);
        spnsanPham.setAdapter(adapterSP);

        final CustomAdapter adapterLV;
        adapterLV = new CustomAdapter(this,R.layout.custom_item,hoaDons);
        lsvData.setAdapter(adapterLV);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtDay.getText().toString().equals("")){
                    edtDay.setError("bạn phải nhập ngày");
                    edtDay.requestFocus();
                    return;
                }
                if(edtsoLuong.getText().toString().equals("")){
                    edtsoLuong.setError("bạn cần nhập số lượng");
                    edtsoLuong.requestFocus();
                    return;

                }
                HoaDon hoaDon = new HoaDon();
                hoaDon.setNgay(edtDay.getText().toString().trim());
                hoaDon.setSoLuong(edtsoLuong.getText().toString().trim());
                hoaDon.setNhanVien(spnnhanVien.getSelectedItem().toString().trim());
                hoaDon.setSanPham(spnsanPham.getSelectedItem().toString().trim());
                hoaDons.add(hoaDon);
                adapterLV.notifyDataSetChanged();

            }
        });
        lsvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
                edtDay.setText(hoaDons.get(position).getNgay());
                edtsoLuong.setText((hoaDons.get(position).getSoLuong()));
                spnnhanVien.setSelection(nhanVien.indexOf(hoaDons.get(position).getNhanVien()));
                spnsanPham.setSelection(sanPham.indexOf(hoaDons.get(position).getSanPham()));
            }
        });
        lsvData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                hoaDons.remove(position);
                adapterLV.notifyDataSetChanged();
                return false;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index !=-1 && hoaDons.isEmpty()){
                    return;
                }
                hoaDons.remove(index);
                adapterLV.notifyDataSetChanged();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index!=-1 && hoaDons.isEmpty()){
                    return;
                }
                HoaDon hoaDon = hoaDons.get(index);
                hoaDon.setNgay(edtDay.getText().toString().trim());
                hoaDon.setSoLuong(edtsoLuong.getText().toString().trim());
                hoaDon.setNhanVien(spnnhanVien.getSelectedItem().toString().trim());
                hoaDon.setSanPham(spnsanPham.getSelectedItem().toString().trim());
                adapterLV.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setControl() {
        edtDay = findViewById(R.id.edtNgay);
        edtsoLuong = findViewById(R.id.edtsoLuong);
        spnnhanVien=findViewById(R.id.spnnhanVien);
        spnsanPham=findViewById(R.id.spnsanPham);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lsvData = findViewById(R.id.lsvdata);
    }
}
