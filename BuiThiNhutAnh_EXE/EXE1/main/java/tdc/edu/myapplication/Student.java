package tdc.edu.myapplication;

public class Student {
    int icon;
    String txtMa, txtTen;

    public Student() {
    }


    public Student(int icon, String txtMa, String txtTen) {
        this.icon = icon;
        this.txtMa = txtMa;
        this.txtTen = txtTen;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTxtMa() {
        return txtMa;
    }

    public void setTxtMa(String txtMa) {
        this.txtMa = txtMa;
    }

    public String getTxtTen() {
        return txtTen;
    }

    public void setTxtTen(String txtTen) {
        this.txtTen = txtTen;
    }


}
