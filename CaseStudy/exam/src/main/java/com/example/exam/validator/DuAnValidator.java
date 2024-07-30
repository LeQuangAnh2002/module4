package com.example.exam.validator;

import com.example.exam.model.DuAn;
import com.example.exam.service.DuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import java.util.Date;

@Component
public class DuAnValidator implements Validator {
    @Autowired
    private DuAnService duAnService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (!(target instanceof DuAn)) {
            return;
        }

        DuAn duAn = (DuAn) target;
        if(duAn.getId() == null || duAn.getId().isEmpty()){
            errors.rejectValue("id", "", "ID Không được dể trống");
        }else if (duAnService.findByIdNameDuAn(duAn.getId()) != null) {
            errors.rejectValue("id", "", "ID bị trùng lặp");
        }  else if (duAn.getTenDuAn().matches("^DA-\\d{4}$")) {
            errors.rejectValue("tenDuAn", "", "Tên dự án phải đúng định dạng(DA-1234)");
        }

        if (duAn.getTenDuAn() == null || duAn.getTenDuAn().isEmpty()) {
            errors.rejectValue("tenDuAn", "", "Tên dự án không được để trống ");
        }

        if (duAn.getKinhPhi() <= 30000000) {
            errors.rejectValue("kinhPhi", "", "kinh phí phải lớn hơn 30.000.000");
        }

        if (duAn.getMoTa() == null || duAn.getMoTa().isEmpty()) {
            errors.rejectValue("moTa", "", "Mô tả không được để trống ");
        }

        if (String.valueOf(duAn.getThoiGian()) == null || String.valueOf(duAn.getThoiGian()).equals("")) {
            errors.rejectValue("thoiGian", "", "Thời gian không được để trống");
        } else if (duAn.getThoiGian() < 1 || duAn.getThoiGian() > 12) {
            errors.rejectValue("thoiGian", "", "Thời gian chỉ hợp lệ 1 đến 12 tháng");
        }
//        if(duAn.getNgayDangKi()  == null || duAn.getNgayDangKi().equals("")){
//            errors.rejectValue("ngayDangKi", "", "Ngày tháng không được  để trống");
//        }
//        else if (duAn.getNgayDangKi().before(new Date())) {
//            errors.rejectValue("ngayDangKi", "", "Ngày không hợp lệ");
//        }


// ^KH-\\d{4}$  định dạng mã khách hàng
// ^(\\(84\\)\\+)?(090|091)\\d{7}$ định dạng số điện thoại
        // ^0\d{8}(\d{2})?$ định dạng CMND
    }
}
