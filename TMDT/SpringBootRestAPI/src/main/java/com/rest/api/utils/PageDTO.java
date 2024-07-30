package com.rest.api.utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageDTO<T> {
    private int page;
    private int size;
    private long totalElement;
    private boolean isLast;
    private boolean isFirst;
    private List<T> data;
}
//@AllArgsConstructor: Annotation này được sử dụng để tạo một constructor chứa tất cả các trường (fields) của lớp. Nó tự động tạo ra một constructor
// có tham số với các tham số đầu vào tương ứng với các trường trong lớp.
//
//@NoArgsConstructor: Annotation này được sử dụng để tạo một constructor không có tham số trong lớp. Nó tự động tạo ra một constructor không có tham số,
// cho phép tạo đối tượng của lớp mà không cần truyền bất kỳ tham số nào.