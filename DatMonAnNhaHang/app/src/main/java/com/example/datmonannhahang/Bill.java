package com.example.datmonannhahang;

public class Bill {
    private int ID;
    private String TenMon;
    private String GiaBan;
    private int SoLuong;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public Bill(int ID, String tenMon, String giaBan, int soLuong) {
        this.ID = ID;
        TenMon = tenMon;
        GiaBan = giaBan;
        SoLuong = soLuong;
    }

    public Bill() {
    }
}
