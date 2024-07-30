package com.example.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class DuAn {
    @Id
    private String id;
    @Column(name = "ten_du_an" ,columnDefinition = "varchar(50)")
    private String tenDuAn;

    @NotNull(message = "Không được để trống ")
    private double kinhPhi;
    @Column(name = "mo_ta")
    private String moTa;
    private int thoiGian;
    @Column(columnDefinition = "DATE")
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDangKi;

    @ManyToOne
    @JoinColumn(name = "ma_doanh_nghiep", nullable = false)
    private DoanhNghiep doanhNghiep;

    public DuAn() {
    }

    public DuAn(String id, String tenDuAn, double kinhPhi, String moTa, int thoiGian, Date ngayDangKi, DoanhNghiep doanhNghiep) {
        this.id = id;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTa = moTa;
        this.thoiGian = thoiGian;
        this.ngayDangKi = ngayDangKi;
        this.doanhNghiep = doanhNghiep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }
}
