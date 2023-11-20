package codegym.com.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.Beans;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("codegym.com")
@EnableTransactionManagement
public class Appconfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;




    @Override
    public void setApplicationContext(ApplicationContext applicationContext)  {
                this.applicationContext =applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
//        Tạo một đối tượng SpringTemplateEngine
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        Thiết lập đối tượng SpringResourceTemplateResolver  đã cấu hình trước đó cho templateEngine.Điều này cho phép templateEngine biết cách tìm và xử lý template
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
//        SpringTemplateEngine sẽ được sử dụng để xử lý các template giao diện người dùng và tạo ra nội dung HTML để trả về cho trình duyệt.
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
//        ThymeleafViewResolver sẽ được sử dụng để xác định cách xử lý các view và trả về nội dung HTML cho trình duyệt.
    }

    //Cấu hình JPA
    @Bean
    @Qualifier(value = "entityManager")
//    @Qualifier đảm bảo rằng bean này có tên là "entityManager"
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
//        Phương thức này sử dụng entityManagerFactory để tạo ra một đối tượng EntityManager bằng cách gọi phương thức createEntityManager() trên entityManagerFactory.
//        Đối tượng EntityManager được tạo ra để thực hiện các thao tác với cơ sở dữ liệu, bao gồm truy vấn dữ liệu, thêm, sửa, xóa và quản lý mọi liên kết với cơ sở dữ liệu.
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        Thiết lập dataSource() cho em, điều này cho phép em biết cách kết nối và tương tác với CSDL
        em.setDataSource(dataSource());
//        Thiết lập gói(package) chứa các entity model mà EntityManager cần quản lý. Trong trường hợp này gói com.codegym.cms.model chứa các entity model của ứng dụng
        em.setPackagesToScan("codegym.com.model");
//        Tạo một đối tượng HibernateJpaVendorAdapter, là một implementation của JpaVendorAdapter dùng để cấu hình JPA (Java Persistence API) với Hibernate.
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        Thiết lập HibernateJpaVendorAdapter cho em, cho biết rằng Hibernate sẽ được sử dụng làm cơ chế JPA trong ứng dụng.
        em.setJpaVendorAdapter(vendorAdapter);
//        Thiết lập các thuộc tính (properties) cho cấu hình JPA. additionalProperties() là một phương thức khác được gọi để trả về một danh sách các thuộc tính cấu hình bổ sung.
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mySQL://127.0.0.1:3306/blog?createDatabaseIfNotExist=true&useSSL=false&useUnicode=true&characterEncoding=utf8");

        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
//        cấu hình thông tin kết nối đến cơ sở dữ liệu MySQL, bao gồm tên lớp của driver, URL, tên người dùng và mật khẩu.
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
}
