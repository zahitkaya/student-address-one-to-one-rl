package com.example.demo.decorator;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class StudentDecorator implements StudentMapper {
    @Setter(onMethod = @__({@Autowired}))
    StudentMapper studentMapper;
    @Setter(onMethod = @__({@Autowired}))
    StudentRepository studentRepository;

    @Override
    public Student studentRequestToStudentEntity(StudentRequest studentRequest) {
        var entity=studentMapper.studentRequestToStudentEntity(studentRequest);
        entity.setId(0);
        entity.getAddress().setId(0);
        return studentRepository.save(entity);
    }
}
