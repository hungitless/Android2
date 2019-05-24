package com.example.exe3;

public class Sach {

    public int  hinh, id;

    public String  tenSach, tenTG, NSX, ngayNhapKho;

    public Sach() {
    }

    public Sach(int id, String tenSach, String tenTG, String NSX, String ngayNhapKho,  int hinh) {
        this.id = id;
        this.tenSach = tenSach;
        this.tenTG = tenTG;
        this.NSX = NSX;
        this.ngayNhapKho = ngayNhapKho;
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(String ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
