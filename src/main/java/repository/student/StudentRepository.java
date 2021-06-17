package repository.student;

import model.Student;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select c from Student c", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = entityManager.createQuery("select c from Student c where  c.id=:id", Student.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Student student) {

        if (student.getId() != null) {
            entityManager.merge(student);
        } else {
            entityManager.persist(student);
        }

    }

    @Override
    public void remove(Long id) {
        Student student= findById(id);
        if (student!= null) {
            entityManager.remove(student);
        }
    }

    @Override
    public boolean insertWithStoredProcedure(Student student) {
        String sql = "CALL Insert_Student(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", student.getFirstName());
        query.setParameter("lastName", student.getLastName());
        return query.executeUpdate() == 0;
    }
}
