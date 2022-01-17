package com.example.du_an_1_android;

public class ThongTinXuat {
    private String id;
    private String TenCuaBan;
    private String NgaySinh;
    private String SoThich1;
    private String Hinh1;

    public ThongTinXuat() {
    }

    public ThongTinXuat(String id, String tenCuaBan, String ngaySinh, String soThich1, String hinh1) {
        this.id = id;
        TenCuaBan = tenCuaBan;
        NgaySinh = ngaySinh;
        SoThich1 = soThich1;
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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSoThich1() {
        return SoThich1;
    }

    public void setSoThich1(String soThich1) {
        SoThich1 = soThich1;
    }

    public String getHinh1() {
        return Hinh1;
    }

    public void setHinh1(String hinh1) {
        Hinh1 = hinh1;
    }
}
