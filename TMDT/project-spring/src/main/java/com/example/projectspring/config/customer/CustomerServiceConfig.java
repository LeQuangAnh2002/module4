package com.example.projectspring.config.customer;

import com.example.projectspring.model.customer.Customer;
import com.example.projectspring.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomerServiceConfig implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer =customerRepository.findByUsername(username);
        if(customer == null){
            throw new UsernameNotFoundException("Could not find username");
        }
        return new User( customer.getUsername(),
                customer.getPassword(),
                customer.getRoles()
                        .stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
}
// class CustomerServiceConfig triển khai interface UserDetailsService mục đích chịu trách nhiệm tải dữ liệu cụ thể của người dùng trong quá trình xác thực
//1.loadUserByUsername() phương thức này sẽ truy xuất 1 Customer từ customerRepository dựa trên username. Nếu ko tìm thấy khách hàng ngoại lệ UsernameNotFoundExceptionsẽ được ném ra
//2.Nếu tìm thấy khách hang, một phiên bản mới của UserDetails sẽ được tạo bằng cách sử dụng Userlớp này, đây là cách triển khai mặc định của UserDetailsgiao diện do Spring Security cung cấp. Hàm Usertạo lấy tên người dùng, mật khẩu và tập hợp GrantedAuthoritycác đối tượng làm tham số.
//3.customer.getRoles(): Đây là danh sách các vai trò (roles) được lấy từ đối tượng Customer.
//4.Phần quan trọng là phần .stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()). Đoạn mã này sử dụng Stream API để chuyển đổi danh sách các vai trò của Customer thành một danh sách các đối tượng SimpleGrantedAuthority sử dụng phương thức .map().
//5.