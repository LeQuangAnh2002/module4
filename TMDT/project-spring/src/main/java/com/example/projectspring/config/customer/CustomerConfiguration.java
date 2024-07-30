package com.example.projectspring.config.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(200)
public class CustomerConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService customerDetailsService(){
        return  new CustomerServiceConfig();
    }
    @Bean
    public BCryptPasswordEncoder customerPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider provider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(customerPasswordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/customer/*").hasAuthority("CUSTOMER")
                .and()
                .formLogin()
                .loginPage("/shop/login")
                .loginProcessingUrl("/customer/do-login")
                .defaultSuccessUrl("/shop")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/shop/logout"))
                .logoutSuccessUrl("/shop/logout?logout")
                .permitAll();
    }
}
//Khi bạn đánh dấu một phương thức trong một lớp cấu hình Spring với @Bean, nó sẽ trở thành một bean được quản lý bởi Spring IoC container. Trong trường hợp này, phương thức userDetailsService() trả về một đối tượng CustomerServiceConfig, là một lớp đã được triển khai UserDetailsService.


//1.authorizeRequests(): Bắt đầu cấu hình điều kiện phân quyền truy cập.
//
//2.antMatchers("/*").permitAll(): Cho phép tất cả các yêu cầu truy cập vào bất kỳ URL nào.
//
//3.antMatchers("/customer/*").hasAuthority("CUSTOMER"): Yêu cầu người dùng có vai trò "CUSTOMER" để truy cập các URL bắt đầu bằng "/customer/".
//
//4.formLogin(): Cấu hình form đăng nhập.
//
//5.loginPage("/login"): Xác định URL của trang đăng nhập.
//
//6.loginProcessingUrl("/do-login"): Xác định URL xử lý quá trình đăng nhập.
//
//7.defaultSuccessUrl("/index"): Xác định URL mặc định sau khi đăng nhập thành công.
//
//8.logout(): Cấu hình chức năng đăng xuất.
//
//9.invalidateHttpSession(true): Hủy bỏ HttpSession sau khi đăng xuất.
//
//10.clearAuthentication(true): Xóa thông tin xác thực sau khi đăng xuất.
//
//11.logoutRequestMatcher(new AntPathRequestMatcher("/logout")): Xác định URL để thực hiện đăng xuất.
//
//12.logoutSuccessUrl("/logout?logout"): Xác định URL sau khi đăng xuất thành công.
//
//13.permitAll(): Cho phép tất cả các yêu cầu truy cập vào URL này mà không cần xác thực.
