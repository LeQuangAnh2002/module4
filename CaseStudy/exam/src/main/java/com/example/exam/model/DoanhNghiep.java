package com.example.exam.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenDoanhNghiep;
    private String linhVuc;
    private String soDienThoai;
    private String email;
    private String diaChi;

    @OneToMany(mappedBy = "doanhNghiep")
    private List<DuAn> duAnList;

    public DoanhNghiep() {
    }

    public DoanhNghiep(int id, String tenDoanhNghiep, String linhVuc, String soDienThoai, String email, String diaChi, List<DuAn> duAnList) {
        this.id = id;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.linhVuc = linhVuc;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.duAnList = duAnList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<DuAn> getDuAnList() {
        return duAnList;
    }

    public void setDuAnList(List<DuAn> duAnList) {
        this.duAnList = duAnList;
    }
}
