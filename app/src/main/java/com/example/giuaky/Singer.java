package com.example.giuaky;

public class Singer {
    private String Ten;
    private String MoTa;
    private String QuocGia;
    private String SoSao;
    private int Hinh;

    public Singer(String ten, String mota, String quocgia, String sosao, int hinh) {
        this.Ten = ten;
        this.MoTa = mota;
        this.Hinh = hinh;
        this.QuocGia = quocgia;
        this.SoSao = sosao;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public String getSoSao() {
        return SoSao;
    }

    public void setSoSao(String soSao) {
        SoSao = soSao;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
