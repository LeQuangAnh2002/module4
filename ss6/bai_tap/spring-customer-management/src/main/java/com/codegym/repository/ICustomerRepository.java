package com.codegym.repository;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
//    Iterable đây là một giao diện trong java, được triển khai bởi các lớp mà cho
//    phép lặp qua các phần của chúng.Nó đại diện cho một tập hợp các đối tượng có thể
//    được lặp qua, ví dụ như một danh sách, một mảng hay kết quả trả về từ một truy vấn CSDL
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
