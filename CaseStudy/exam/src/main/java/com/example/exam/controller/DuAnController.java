package com.example.exam.controller;

import com.example.exam.model.DoanhNghiep;
import com.example.exam.model.DuAn;
import com.example.exam.service.DoanhNghiepService;
import com.example.exam.service.DuAnService;
import com.example.exam.validator.DuAnValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/du-an")
public class DuAnController {
    @Autowired
    private DuAnService duAnService;
    @Autowired
    private DoanhNghiepService doanhNghiepService;
    @Autowired
    private DuAnValidator duAnValidator;
        @GetMapping("/list")
    public String showDuAn(Model model,@RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize){
            Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
            Page<DuAn> duAnPage = duAnService.pageAllDuAn(pageable);
            int totalPage = duAnPage.getTotalPages();
            List<Integer> pageNumbers = new ArrayList<>();
            for (int i = 0; i < totalPage; i++) {
                pageNumbers.add(i + 1);
            }

            model.addAttribute("duAnList", duAnPage);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("pageNumbers", pageNumbers);
            return "list";
        }

        @GetMapping("/add")
        public String showDangKi(Model model){
        List<DoanhNghiep> doanhNghieps = doanhNghiepService.findAll();
        model.addAttribute("duAn",new DuAn());
        model.addAttribute("doanhNghieps",doanhNghieps);
        return "create";
        }

        @PostMapping("/add")
    public String addDuAn(@Validated @ModelAttribute("duAn") DuAn duAn,
                          @RequestParam("ngayDangKi") String ngayDangKi
                          ,BindingResult bindingResult,Model model){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date ngayDangKiDate = dateFormat.parse(ngayDangKi);
                duAn.setNgayDangKi(ngayDangKiDate);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            duAnValidator.validate(duAn,bindingResult);

            if(bindingResult.hasErrors()){
                List<DoanhNghiep> doanhNghieps = doanhNghiepService.findAll();
                model.addAttribute("doanhNghieps",doanhNghieps);
                return "create";
            }

            duAnService.create(duAn);
            return "redirect:/du-an/list";
        }

        @GetMapping("/detail/{id}")
    public String showDetail( @PathVariable String id, Model model){
            DuAn duAn = duAnService.findByIdNameDuAn(id);
            List<DoanhNghiep> doanhNghieps = doanhNghiepService.findAll();
            model.addAttribute("duAn",duAn);
            model.addAttribute("doanhNghieps",doanhNghieps);
            return "detail";
        }

}
