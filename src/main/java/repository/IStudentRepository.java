package repository;

import model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository  extends CrudRepository<Student, Long> {
}
// với từ khóa @Repository, thì việc tạo đối tượng để tiem vao server không cần phải config lại trong Spring IOC