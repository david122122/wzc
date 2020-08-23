package com.wzc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import wzc.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(value = "/student/info/{id}")
    public Student studentInfo(@PathVariable(value = "id") Integer id){
        return new Student(id,"zhangsan",23,"北京昌平区","1");
    }

    @GetMapping(value = "/student/infoByQuery")
    public Student studentByQuery(String name,String addr){
        return new Student(111,name,23,addr,"1");
    }

    @GetMapping(value = "/student/infoByName")
    @HystrixCommand(fallbackMethod = "timeOutMethod")
    public Student studentByName(String name){
        //int i=1/0;
        int j=0;
        int i=1;
        while(i>0){

        }
        System.out.println("aa");
        return new Student(111,name,23,"bj","1");
    }

    public Student timeOutMethod(String name){
        System.out.println("timeOutMethod");
        return new Student(555,name,23,"bjm","1");
    }
}
