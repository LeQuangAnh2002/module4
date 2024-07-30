package com.codegym.furama.service.contract;

import com.codegym.furama.model.contract.AttachService;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Contract add(Contract contract);
    Page<Contract> findPage(Pageable pageable);
    List<AttachService> findAttach();

    boolean addContractDetail(ContractDetail contractDetail);
    Long showMaxId();
}
