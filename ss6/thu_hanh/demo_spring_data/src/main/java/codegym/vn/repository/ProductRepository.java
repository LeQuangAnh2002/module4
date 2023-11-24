package codegym.vn.repository;

import codegym.vn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByNameContaining(String name);
    @Query("From Product p where p.name like :name")
//    @Query được sử dụng để xác định một câu truy vấn tùy chỉnh.
//    Lưu ý rằng câu truy vấn trong ví dụ chỉ sử dụng cú pháp HQL (Hibernate Query Language).
//    Bạn cũng có thể sử dụng cú pháp SQL thuần trong câu truy vấn tùy chỉnh bằng cách sử dụng annotation @Query với tham số nativeQuery = true.
    public List<Product> search(@Param("name") String name);
//   Phương thức search được định nghĩa để thực hiện truy vấn tùy chỉnh.
//   Nó có một tham số name được đánh dấu bằng annotation @Param("name") để ánh xạ với tham số :name trong câu truy vấn

}
