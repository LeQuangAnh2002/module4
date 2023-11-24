package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;
    @GetMapping("/list")
    public String listCustomers(@RequestParam("search") Optional<String> search, Model model, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(),pageable);
        }else{
            customers = customerService.findAll(pageable);
        }

        model.addAttribute("customers",customers);
        return "customer/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces",provinceService.findAll());
        return "customer/create";

    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Optional<Customer> customer = customerService.findById(id);

        if(customer.isPresent()){
            model.addAttribute("customer",customer.get());
            model.addAttribute("provinces",provinceService.findAll());
        }
        return "customer/update";
    }
    @PostMapping("/update-customer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.remove(id);
        return "redirect:/customer/list";

    }
}
