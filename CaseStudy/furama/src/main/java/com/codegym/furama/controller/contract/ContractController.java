package com.codegym.furama.controller.contract;

import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.contract.AttachService;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.contract.IContractService;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.employee.EmpolyeeService;
import com.codegym.furama.service.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private EmpolyeeService EmployeeService;
    @Autowired
    private IService iService;

    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "0") int size,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Contract> contractPage = iContractService.findPage(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }
    @GetMapping("/update")
    public String update(){

        return "contract/list";
    }

    @GetMapping("/add_contract_villa")
    public String addContractVilla(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("listEmployee", EmployeeService.findAll());
        model.addAttribute("listCustomer", iCustomerService.getCustomer());
        model.addAttribute("listAttach", iContractService.findAttach());
        model.addAttribute("listService", iService.findByServiceName("Villa"));
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }
    @GetMapping("/add_contract_house")
    public String addContractHouse(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("listEmployee", EmployeeService.findAll());
        model.addAttribute("listCustomer", iCustomerService.getCustomer());
        model.addAttribute("listAttach", iContractService.findAttach());
        model.addAttribute("listService", iService.findByServiceName("House"));
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                      @RequestParam List<Long> valueAttach
    ) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/add";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.add(contract);

        for (Long i:valueAttach) {
            ContractDetail contractDetail = new ContractDetail();
            AttachService attachService = new AttachService();
            contractDetail.setContract(contract);
            contractDetail.setAttachService(attachService);
            contractDetail.setQuantity(valueAttach.size());
            iContractService.addContractDetail(contractDetail);
        }
        return "redirect:/contract";
    }
}
