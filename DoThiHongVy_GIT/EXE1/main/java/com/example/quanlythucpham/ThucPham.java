package com.example.quanlythucpham;

public class ThucPham {
    int images;
    String thucPham;
    String chuThich;
    String gia;
    public boolean icon;

    public ThucPham() {
    }

    public ThucPham(int images, String thucPham, String chuThich ,String gia, boolean icon) {
        this.images = images;
        this.thucPham = thucPham;
        this.chuThich = chuThich;
        this.gia = gia;
        this.icon = icon;
    }

    public boolean isIcon() {
        return icon;
    }

    public boolean setIcon(boolean icon) {
        this.icon = icon;
        return icon;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getImgIcon() {
        return images;
    }

    public void setImgIcon(int imgIcon) {
        this.images = imgIcon;
    }

    public String getThucPham() {
        return thucPham;
    }

    public void setThucPham(String thucPham) {
        this.thucPham = thucPham;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

}
