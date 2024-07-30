package com.example.projectspring.config.customer;

import com.example.projectspring.model.Role;
import com.example.projectspring.model.customer.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDetails implements UserDetails {
    private Customer customer;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : customer.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
// UserDetails mục đích là cung cấp thông tin chi tiết về người dùng theo yêu cầu của Spring Security để xác thực và ủy quyền
// 1.getAuthorities(): Phương thức này trả về một tập hợp các quyền được cấp (thường là các vai trò) được liên kết với người dùng. Trong quá trình triển khai được cung cấp, nó truy xuất các vai trò được gán cho Customervà chuyển đổi chúng thành SimpleGrantedAuthoritycác đối tượng.
//
//2.getPassword(): Phương thức này trả về mật khẩu được liên kết với người dùng. Trong quá trình triển khai được cung cấp, nó sẽ lấy mật khẩu từ Customerđối tượng.
//
//3.getUsername(): Phương thức này trả về tên người dùng (hoặc mã định danh) được liên kết với người dùng. Trong quá trình triển khai được cung cấp, nó sẽ lấy tên người dùng từ Customerđối tượng.
//
//4.isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled(): Các phương thức này cho biết trạng thái của tài khoản người dùng. Trong quá trình triển khai được cung cấp, tất cả các phương thức này đều trả về true, cho biết rằng tài khoản người dùng luôn được coi là hợp lệ và được kích hoạt.
