package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService,Integer> {
}
