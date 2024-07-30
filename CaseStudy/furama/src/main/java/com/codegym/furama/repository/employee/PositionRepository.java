package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
