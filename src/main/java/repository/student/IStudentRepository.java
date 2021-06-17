package repository.student;

import model.Student;
import repository.IGeneralRepository;

public interface IStudentRepository extends IGeneralRepository<Student> {
    boolean insertWithStoredProcedure(Student student);
}
