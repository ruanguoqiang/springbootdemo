package com.qiangge.provide.restful;

import com.qiangge.model.Class;
import com.qiangge.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChangeController {

    @PostMapping(value = "/getStudent")
    public Class getStudent(@RequestBody Class clas){
        List<Student> students=clas.getStudents();
        students.add(new Student(6,"qige"));
        clas.setStudents(students);
        return clas;
    }
}
