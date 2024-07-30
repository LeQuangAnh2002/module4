package com.example.projectspring.repository.admin;

import com.example.projectspring.dto.CategoryDto;
import com.example.projectspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select c from Category c where c.is_activated = true and c.is_deleted= false ")
    List<Category> findAllByActivated();
//    Customer
//   câu truy vấn trên thực hiện lấy thông tin về danh mục (Category) cùng với số lượng sản phẩm trong mỗi danh mục
//   - select new com.example.projectspring.dto.CategoryDto(c.id, c.name, count(p.category.id)): Đây là phần chọn (select) của câu truy vấn.
//    Nó chỉ định rằng kết quả truy vấn sẽ trả về một danh sách các đối tượng CategoryDto. Mỗi CategoryDto được tạo ra với ba thông tin: id của Category, name của Category, và số lượng sản phẩm trong Category (được tính bằng hàm count()).
    @Query(value = "select new com.example.projectspring.dto.CategoryDto(c.id,c.name,count(c.id)) from  Category c inner join Product p on p.category.id = c.id where c.is_activated = true and c.is_deleted = false group by c.id")
    List<CategoryDto> getCategoryAndProduct();


}
