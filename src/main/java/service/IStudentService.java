package service;

import model.Student;

public interface IStudentService {
    boolean insertWithStoredProcedure(Student student);
}
