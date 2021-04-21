package com.example.demo.controller.rest;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @Operation(description = "List Student as Page")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok" ),
            @ApiResponse(responseCode = "400", description = "Bad Request" ) ,
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @PageableAsQueryParam
    @GetMapping("/student")
    Page<StudentResponseDto> getAllStudents(@Parameter(hidden = true)Pageable pageable){
        return studentService.fetchAllStudents(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok" ),
            @ApiResponse(responseCode = "400", description = "Bad Request" ) ,
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @PostMapping("/student")
    StudentResponseDto createStudent(@RequestBody StudentRequest student){
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok" ),
            @ApiResponse(responseCode = "400", description = "Bad Request" ) ,
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @PutMapping("/student/{id}")
    StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id,studentRequest);
    }
}
