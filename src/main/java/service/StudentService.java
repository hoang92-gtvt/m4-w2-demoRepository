package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IStudentRepository;

public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public boolean insertWithStoredProcedure(Student student) {
        return studentRepository.insertWithStoredProcedure(student);
    }
}
