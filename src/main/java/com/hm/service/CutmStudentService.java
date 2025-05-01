package com.hm.service;

import com.hm.entity.CutmStudent;
import com.hm.repository.CutmStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CutmStudentService {

    @Autowired
    private CutmStudentRepository repository;

    public CutmStudent saveStudent(CutmStudent student) {
        return repository.save(student);
    }

    public List<CutmStudent> getAllStudents() {
        return repository.findAll();
    }

    public Optional<CutmStudent> getStudentById(Long id) {
        return repository.findById(id);
    }

    public ResponseEntity<CutmStudent> updateStudent(Long id, CutmStudent studentDetails) {
        return repository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setRegNumber(studentDetails.getRegNumber());
            student.setDepartment(studentDetails.getDepartment());
            student.setSemester(studentDetails.getSemester());
            return ResponseEntity.ok(repository.save(student));
        }).orElse(ResponseEntity.notFound().build());
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
