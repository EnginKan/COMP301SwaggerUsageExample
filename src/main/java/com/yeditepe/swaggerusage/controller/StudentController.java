package com.yeditepe.swaggerusage.controller;


import com.yeditepe.swaggerusage.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="Student Controller",
description = "Everything about student operations")
@RestController
@RequestMapping("api/v1/stud")
public class StudentController {
private List<Student> studs=List.of(
        new Student("Engin","Kandiran","engin@gmail.com"),
        new Student("Pinar","Kahraman","pinar@gmail.com"),
        new Student("Ayse","Ercan","ayse@gmail.com")
);
  @Operation(method ="GET",
  description = "Return all student records")
    @GetMapping
    public ResponseEntity<String> getStudent() {
        return ResponseEntity.ok("Student Controller");
    }

    @Operation(description = "Return student record with given id if exist")
    @ApiResponse(responseCode = "200",
    content = @Content(schema = @Schema(implementation = Student.class)))
    @ApiResponse(responseCode = "404",
    description = "Resource cannot be found/not exist")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @Parameter(required = true,
            description = "Id of student")
            @PathVariable(name="id") int id) {
      Student student = studs.get(id);
      if (student == null) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(student);
    }
    @Operation(
            description ="Create new Student Entity"
    )
    @ApiResponse
            (responseCode = "201"
            , content = @Content(schema = @Schema(implementation = Student.class)))
     @PostMapping()
    public ResponseEntity<Student> createStudent(
            @Parameter(required = true,
            schema = @Schema(implementation = Student.class))
            @RequestBody Student student) {
            studs.add(student);
            return ResponseEntity.ok(student);

    }


}
