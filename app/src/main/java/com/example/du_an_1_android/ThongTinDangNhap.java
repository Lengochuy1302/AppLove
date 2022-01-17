package com.example.du_an_1_android;

import java.util.HashMap;
import java.util.Map;

public class ThongTinDangNhap {
    private String id;
    private String TenDangNhap;
    private String MatKhau;
    private String Gmail;
    private String SDT;
    private String TenCuaBan;
    private String NgaySinh;
    private String GioiTinh;
    private String SoThich1;
    private String SoThich2;
    private String SoThich3;
    private String MoTa;
    private String Hinh1;
    private String Hinh2;
    private String Hinh3;
    private String Hinh4;
    private String Hinh5;
    private String Hinh6;
    private String Hinh7;
    private String Hinh8;
    private String Hinh9;
    private String TrangThai;
    private String TinhYeu;
    private String NgayYeu;
    private String Vitri;
    private String LoaiTaiKhoan;
    private String DieuKhoan;

    public ThongTinDangNhap() {
    }

    public ThongTinDangNhap(String id, String tenDangNhap, String matKhau, String gmail, String SDT, String tenCuaBan, String ngaySinh, String gioiTinh, String soThich1, String soThich2, String soThich3, String moTa, String hinh1, String hinh2, String hinh3, String hinh4, String hinh5, String hinh6, String hinh7, String hinh8, String hinh9, String trangThai, String tinhYeu, String ngayYeu, String vitri, String loaiTaiKhoan, String dieuKhoan) {
        this.id = id;
        TenDangNhap = tenDangNhap;
        MatKhau = matKhau;
        Gmail = gmail;
        this.SDT = SDT;
        TenCuaBan = tenCuaBan;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        SoThich1 = soThich1;
        SoThich2 = soThich2;
        SoThich3 = soThich3;
        MoTa = moTa;
        Hinh1 = hinh1;
        Hinh2 = hinh2;
        Hinh3 = hinh3;
        Hinh4 = hinh4;
        Hinh5 = hinh5;
        Hinh6 = hinh6;
        Hinh7 = hinh7;
        Hinh8 = hinh8;
        Hinh9 = hinh9;
        TrangThai = trangThai;
        TinhYeu = tinhYeu;
        NgayYeu = ngayYeu;
        Vitri = vitri;
        LoaiTaiKhoan = loaiTaiKhoan;
        DieuKhoan = dieuKhoan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
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

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getSoThich1() {
        return SoThich1;
    }

    public void setSoThich1(String soThich1) {
        SoThich1 = soThich1;
    }

    public String getSoThich2() {
        return SoThich2;
    }

    public void setSoThich2(String soThich2) {
        SoThich2 = soThich2;
    }

    public String getSoThich3() {
        return SoThich3;
    }

    public void setSoThich3(String soThich3) {
        SoThich3 = soThich3;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getHinh1() {
        return Hinh1;
    }

    public void setHinh1(String hinh1) {
        Hinh1 = hinh1;
    }

    public String getHinh2() {
        return Hinh2;
    }

    public void setHinh2(String hinh2) {
        Hinh2 = hinh2;
    }

    public String getHinh3() {
        return Hinh3;
    }

    public void setHinh3(String hinh3) {
        Hinh3 = hinh3;
    }

    public String getHinh4() {
        return Hinh4;
    }

    public void setHinh4(String hinh4) {
        Hinh4 = hinh4;
    }

    public String getHinh5() {
        return Hinh5;
    }

    public void setHinh5(String hinh5) {
        Hinh5 = hinh5;
    }

    public String getHinh6() {
        return Hinh6;
    }

    public void setHinh6(String hinh6) {
        Hinh6 = hinh6;
    }

    public String getHinh7() {
        return Hinh7;
    }

    public void setHinh7(String hinh7) {
        Hinh7 = hinh7;
    }

    public String getHinh8() {
        return Hinh8;
    }

    public void setHinh8(String hinh8) {
        Hinh8 = hinh8;
    }

    public String getHinh9() {
        return Hinh9;
    }

    public void setHinh9(String hinh9) {
        Hinh9 = hinh9;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getTinhYeu() {
        return TinhYeu;
    }

    public void setTinhYeu(String tinhYeu) {
        TinhYeu = tinhYeu;
    }

    public String getNgayYeu() {
        return NgayYeu;
    }

    public void setNgayYeu(String ngayYeu) {
        NgayYeu = ngayYeu;
    }

    public String getVitri() {
        return Vitri;
    }

    public void setVitri(String vitri) {
        Vitri = vitri;
    }

    public String getLoaiTaiKhoan() {
        return LoaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        LoaiTaiKhoan = loaiTaiKhoan;
    }

    public String getDieuKhoan() {
        return DieuKhoan;
    }

    public void setDieuKhoan(String dieuKhoan) {
        DieuKhoan = dieuKhoan;
    }

    public Map<String, Object> toMapGmail() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("gmail", Gmail);
        return resuft;
    }

    public Map<String, Object> toMapSDT() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("sdt", SDT);
        return resuft;
    }

    public Map<String, Object> toMapTenCuaBan() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("tenCuaBan", TenCuaBan);
        return resuft;
    }

    public Map<String, Object> toMapNgaySinh() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("ngaySinh", NgaySinh);
        return resuft;
    }

    public Map<String, Object> toMapGioiTinh() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("gioiTinh", GioiTinh);
        return resuft;
    }

    public Map<String, Object> toMapSoThich1() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("soThich1", SoThich1);
        return resuft;
    }

    public Map<String, Object> toMapSoThich2() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("soThich2", SoThich2);
        return resuft;
    }

    public Map<String, Object> toMapSoThich3() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("soThich3", SoThich3);
        return resuft;
    }

    public Map<String, Object> toMapMoTa() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("moTa", MoTa);
        return resuft;
    }

    public Map<String, Object> toMapAnh1() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh1", Hinh1);
        return resuft;
    }

    public Map<String, Object> toMapAnh2() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh2", Hinh2);
        return resuft;
    }

    public Map<String, Object> toMapAnh3() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh3", Hinh3);
        return resuft;
    }

    public Map<String, Object> toMapAnh4() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh4", Hinh4);
        return resuft;
    }

    public Map<String, Object> toMapAnh5() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh5", Hinh5);
        return resuft;
    }

    public Map<String, Object> toMapAnh6() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh6", Hinh6);
        return resuft;
    }

    public Map<String, Object> toMapAnh7() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh7", Hinh7);
        return resuft;
    }

    public Map<String, Object> toMapAnh8() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh8", Hinh8);
        return resuft;
    }

    public Map<String, Object> toMapAnh9() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("hinh9", Hinh9);
        return resuft;
    }

    public Map<String, Object> toMapTenDangNhap() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("tenDangNhap", TenDangNhap);
        return resuft;
    }

    public Map<String, Object> toMapMatKhau() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("matKhau", MatKhau);
        return resuft;
    }

    public Map<String, Object> toMapTrangThai() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("trangThai", TrangThai);
        return resuft;
    }
    public Map<String, Object> toMapNgayYeu() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("ngayYeu", NgayYeu);
        return resuft;
    }
    public Map<String, Object> toMapVitri() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("viTri", Vitri);
        return resuft;
    }
    public Map<String, Object> toMapLoaiTaiKhoan() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("loaiTaiKhoan", LoaiTaiKhoan);
        return resuft;
    }
    public Map<String, Object> toMapDieuKhoan() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("dieuKhoan", DieuKhoan);
        return resuft;
    }
    public Map<String, Object> toMapTinhYeu() {
        HashMap<String, Object> resuft = new HashMap<>();
        resuft.put("tinhYeu", TinhYeu);
        return resuft;
    }
}
