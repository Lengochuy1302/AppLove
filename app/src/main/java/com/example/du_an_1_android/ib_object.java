package com.example.du_an_1_android;

public class ib_object {
    private String id;
    private String TenCuaBan;
    private String Hinh1;

    public ib_object(String id, String tenCuaBan, String hinh1) {
        this.id = id;
        TenCuaBan = tenCuaBan;
        Hinh1 = hinh1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenCuaBan() {
        return TenCuaBan;
    }

    public void setTenCuaBan(String tenCuaBan) {
        TenCuaBan = tenCuaBan;
    }

    public String getHinh1() {
        return Hinh1;
    }

    public void setHinh1(String hinh1) {
        Hinh1 = hinh1;
    }
}
