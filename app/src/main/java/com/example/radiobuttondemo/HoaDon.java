package com.example.radiobuttondemo;

import java.util.Date;

class HoaDon {
    private String sanPham,nhanVien;
    private String ngay;
    private String soLuong;

    public HoaDon( String sanPham, String nhanVien, String ngay, String soLuong) {

        this.sanPham = sanPham;
        this.nhanVien = nhanVien;
        this.ngay = ngay;
        this.soLuong = soLuong;
    }

    public HoaDon() {
    }





    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }


    @Override
    public String toString() {
        return "HoaDon{" +
                "sanPham='" + sanPham + '\'' +
                ", nhanVien='" + nhanVien + '\'' +
                ", ngay=" + ngay +
                ", soLuong=" + soLuong +
                '}';
    }
}
