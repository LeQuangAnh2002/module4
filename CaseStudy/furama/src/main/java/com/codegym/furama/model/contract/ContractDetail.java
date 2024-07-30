package com.codegym.furama.model.contract;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.service.Service;
import jakarta.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "contract_detail_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "attach_id",nullable = false,referencedColumnName = "attach_id")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false,referencedColumnName = "contract_id")
    private Contract contract;

    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, AttachService attachService, Contract contract, int quantity) {
        this.id = id;
        this.attachService = attachService;
        this.contract = contract;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
