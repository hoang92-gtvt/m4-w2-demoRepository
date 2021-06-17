package repository;

import model.Student;

public interface IStudentRepository {
    boolean insertWithStoredProcedure(Student student);
}
