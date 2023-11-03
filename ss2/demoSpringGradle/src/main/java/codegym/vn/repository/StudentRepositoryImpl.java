package codegym.vn.repository;

import codegym.vn.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put("SV001", new Student("SV001", "Hải", "Da Nang"));
        studentMap.put("SV002", new Student("SV002", "Lan", "Da Nang"));
        studentMap.put("SV003", new Student("SV003", "Khanh", "Quang Nam"));
        studentMap.put("SV004", new Student("SV004", "Thanh", "Da Nang"));
        studentMap.put("SV005", new Student("SV005", "Hung", "Da Nang"));
    }

    @Override
    public void create(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public void delete(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.remove(student.getId());
        }
    }

    @Override
    public void update(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }
}
