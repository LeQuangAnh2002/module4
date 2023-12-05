package codegym.vn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
//AOP cho phép bạn tách riêng các phần logic quan trọng khỏi các phần khác trong ứng dụng, chẳng hạn như ghi log, xử lý ngoại lệ, quản lý giao dịch
public class LoggingAspect {
    // tạo một đối tượng logger. Logger được sử dụng để ghi các thông báo log
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    // productService() là một điểm cắt(poincut). Điểm cắt này xác định tất cả các phương
    // thức trong lớp ProductService. Tất cả các phương thức này sẽ được áp dụng với advice(hành động) tương ứng.
    @Pointcut("execution (* codegym.vn.service.ProductService.*(..))")
    public void productService(){};

    // writeLogBefore là một advice( hành động) chú thích @Before. Advice này sẽ được thực thi trước khi các phương thức trong điểm cắt productService() được gọi
//    JoinPoint được sử dụng để  truy xuất thông tin về phương thức đang được gọi,như tên phương thức
//    Đoạn mã ghi log trong phương thức này sẽ ghi ra thông trước khi gọi phương thức
    @Before("productService()")
    public void writeLogBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("======== Before call method: " + methodName);
    }
//   writeLogAround là một advice được xách định bằng @Around . Advice này sẽ được thực thi
//    trước và sau khi các phương thức trước và sau khi các phương thức bắt đầu bằng phương thức find* trong ProductService được gọi.
//    Trong advice này, ProceedingJoinPoint được sử dụng để chạy phương thức gốc và nhận kết quả trả về từ phương thức đó
    @Around("execution (* codegym.vn.service.ProductService.find*(..))")
    public Object writeLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("======== Around call method: before " + methodName);
        Object result = joinPoint.proceed();
        logger.info("======== Around call method: after " + methodName);
        return result;
    }
}
