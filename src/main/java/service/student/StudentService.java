package service.student;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.student.IStudentRepository;

import java.util.List;

public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public boolean insertWithStoredProcedure(Student student) {
        return studentRepository.insertWithStoredProcedure(student);
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.remove(id);
    }
}
