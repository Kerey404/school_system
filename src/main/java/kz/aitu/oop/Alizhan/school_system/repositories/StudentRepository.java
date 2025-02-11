package kz.aitu.oop.Alizhan.school_system.repositories;

import kz.aitu.oop.Alizhan.school_system.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
