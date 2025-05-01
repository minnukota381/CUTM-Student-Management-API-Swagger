package com.hm.controller;

import com.hm.entity.CutmStudent;
import com.hm.service.CutmStudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutmstudents")
public class CutmStudentController {

    @Autowired
    private CutmStudentService studentService;

    @Operation(summary = "Create a new CUTM Student", description = "This endpoint allows you to create a new student in the CUTM system.")
    @PostMapping
    public CutmStudent createStudent(@RequestBody CutmStudent student) {
        return studentService.saveStudent(student);
    }

    @Operation(summary = "Get all CUTM Students", description = "This endpoint retrieves a list of all students in the CUTM system.")
    @GetMapping
    public List<CutmStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get a CUTM Student by ID", description = "This endpoint retrieves a single student by their unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<CutmStudent> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a CUTM Student by ID", description = "This endpoint allows you to update the details of an existing student by their unique ID.")
    @PutMapping("/{id}")
    public ResponseEntity<CutmStudent> updateStudent(@PathVariable Long id, @RequestBody CutmStudent student) {
        return studentService.updateStudent(id, student);
    }

    @Operation(summary = "Delete a CUTM Student by ID", description = "This endpoint allows you to delete a student by their unique ID.")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
