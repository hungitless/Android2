package com.example.exe3;

public class BanDoc {

    @Override
    public String toString() {
        return "BanDoc{" +
                "sMa='" + sMa + '\'' +
                ", sTen='" + sTen + '\'' +
                ", nSDT=" + nSDT +
                '}';
    }

    private String sMa, sTen;
    private int nSDT;
    public BanDoc() {
    }

    public String getsMa() {
        return sMa;
    }

    public void setsMa(String sMa) {
        this.sMa = sMa;
    }

    public String getsTen() {
        return sTen;
    }

    public void setsTen(String sTen) {
        this.sTen = sTen;
    }

    public int getnSDT() {
        return nSDT;
    }

    public void setnSDT(int nSDT) {
        this.nSDT = nSDT;
    }
}
