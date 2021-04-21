package com.example.demo.mapper;

import com.example.demo.decorator.StudentDecorator;
import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.entity.Student;
import org.mapstruct.*;

@Mapper
@DecoratedWith(StudentDecorator.class)
public interface StudentMapper {
    Student studentRequestToStudentEntity(StudentRequest studentRequest);
    StudentResponseDto studentEntityToStudentResponseDto(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void studentRequestToStudentEntity(StudentRequest studentRequest,@MappingTarget Student student);

}
