package com.example.datmonannhahang;

public class MonChinh {
    private int ID;
    private String tenmon;
    private String giaban;

    public MonChinh(int ID, String tenmon, String giaban) {
        this.ID = ID;
        this.tenmon = tenmon;
        this.giaban = giaban;
    }

    private int soluong;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public MonChinh(int ID, String tenmon, String giaban, int soluong) {
        this.ID = ID;
        this.tenmon = tenmon;
        this.giaban = giaban;
        this.soluong = soluong;
    }

    public MonChinh() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }
}
