package repository;

import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;

public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean insertWithStoredProcedure(Student student) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", student.getFirstName());
        query.setParameter("lastName", student.getLastName());
        return query.executeUpdate() == 0;
    }
}
