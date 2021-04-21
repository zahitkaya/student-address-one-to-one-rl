package com.example.demo.service;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface StudentService {
    Page<StudentResponseDto> fetchAllStudents(Pageable pageable);
    StudentResponseDto getStudentByID(Integer id);
    StudentResponseDto updateStudent(Integer id, StudentRequest studentRequest);
    StudentResponseDto createStudent(StudentRequest studentRequest);
    void deleteStudentByID(Integer id);
}
