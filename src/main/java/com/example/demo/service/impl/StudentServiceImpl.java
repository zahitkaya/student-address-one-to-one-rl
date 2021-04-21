package com.example.demo.service.impl;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;
    final StudentMapper studentMapper;

    @Override
    public Page<StudentResponseDto> fetchAllStudents(Pageable pageable) {
       return studentRepository.findAll(pageable).map(studentMapper::studentEntityToStudentResponseDto);
    }

    @Override
    public StudentResponseDto getStudentByID(Integer id) {
        return null;
    }

    @Override
    public StudentResponseDto updateStudent(Integer id, StudentRequest studentRequest) {
        var entity=studentRepository.findById(id).get();
        var addresId=entity.getAddress().getId();
        studentMapper.studentRequestToStudentEntity(studentRequest,entity);
        entity.getAddress().setId(addresId);
        studentRepository.save(entity);
        return studentMapper.studentEntityToStudentResponseDto(entity);
    }

    @Override
    public StudentResponseDto createStudent(StudentRequest studentRequest) {
       var entity= studentMapper.studentRequestToStudentEntity(studentRequest);
       return studentMapper.studentEntityToStudentResponseDto(entity);
    }

    @Override
    public void deleteStudentByID(Integer id) {
        studentRepository.deleteById(id);
    }
}
