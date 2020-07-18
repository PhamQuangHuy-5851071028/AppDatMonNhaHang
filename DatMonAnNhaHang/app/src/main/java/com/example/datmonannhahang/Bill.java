package com.example.datmonannhahang;

public class Bill {
    private int ID;
    private String TenMon;
    private String GiaBan;
    private int SoLuong;
    private int Ban;

    public int getBan() {
        return Ban;
    }

    public void setBan(int ban) {
        Ban = ban;
    }

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

    public Bill(int ID, String tenMon, String giaBan, int soLuong, int ban) {
        this.ID = ID;
        TenMon = tenMon;
        GiaBan = giaBan;
        SoLuong = soLuong;
        Ban = ban;
    }

    public Bill() {
    }
}
