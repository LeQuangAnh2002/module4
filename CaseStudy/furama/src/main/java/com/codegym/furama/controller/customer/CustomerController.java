package com.codegym.furama.controller.customer;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.customer.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "0") int size,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model
    ) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Customer> customerPage;
        if (valueSearch.equals("")) {
            customerPage = iCustomerService.findPage(pageable);
        } else {
            customerPage = iCustomerService.findByName(pageable, valueSearch);
        }
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("valueSearch", valueSearch);
        return "customer/list";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("customerType", iCustomerService.findCustomerType());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute CustomerDto customerDto,
                      BindingResult bindingResult, RedirectAttributes redirectAttributes
    ) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (iCustomerService.add(customer)) {
            redirectAttributes.addFlashAttribute("successCreate", "Thêm mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("successCreate", "Thêm mới không thành công!");
        }
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerType", iCustomerService.findCustomerType());

        return "customer/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam List<Integer> idRemove) {
        for (int i : idRemove) {
            iCustomerService.remove(i);
        }
        return "redirect:/customer";
    }
}