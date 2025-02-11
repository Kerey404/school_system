package kz.aitu.oop.Alizhan.school_system.services;

import kz.aitu.oop.Alizhan.school_system.models.Student;
import kz.aitu.oop.Alizhan.school_system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return repository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            return repository.save(student);
        }).orElseThrow(() -> new RuntimeException("Студент с ID " + id + " не найден"));
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
