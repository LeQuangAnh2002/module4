package com.example.projectspring.repository.admin;

import com.example.projectspring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p ")
    Page<Product> pageProduct(Pageable pageable);
    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    Page<Product> searchProducts(String keyword,Pageable pageable);

    @Query("select  p from Product p where p.description like %?1% or p.name like %?1%")
    List<Product> searchProductsList(String keyword);
//    Customer
    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false ")
    List<Product> getAllProducts();
    @Query(value = "select * from products p where p.is_deleted = false  and p.is_activated = true order by  rand() asc limit 4",nativeQuery = true)
    List<Product> listViewProducts();

    Product getProductById(Long id);
    @Query(value = "select * from products  p inner join categories c on c.category_id = p.category_id where p.category_id =?1",nativeQuery = true)
    List<Product> getRelatedProduct(Long categoryId);

//    Câu query được sử dụng để lấy các sản phẩm (Product) từ một danh mục (Category) cụ thể, với điều kiện rằng sản phẩm không bị xóa (is_deleted = false) và được kích hoạt (is_activated = true).
    @Query(value = "select p from Product p inner join Category  c on c.id = p.category.id where c.id =?1 and p.is_deleted = false and p.is_activated = true")
    List<Product> getProductsInCategory(Long categoryId);

    @Query("select p from Product  p where  p.is_activated = true and p.is_deleted = false order by p.costPrice desc ")
    List<Product> filterHighPrice();

    @Query("select p from Product  p where p.is_activated = true and p.is_deleted = false order by p.costPrice ")
    List<Product> filterLowPrice();
}
