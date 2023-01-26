package com.example.StudentManegement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
            ServiceController serviceController;

//Map<Integer,Student> db=new HashMap<>();
//Get information of Student
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int admnNo)
    {
        Student student=serviceController.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //Get information by name
//    @GetMapping("/get_student_byname")
//    public Student getStudent(@RequestParam("n") String name)
//    {
//        int amdinId=0;
//        for(Map.Entry<Integer,Student> e:db.entrySet())
//        {
//          Student std=e.getValue();
//          String sName=std.getName();
//          if(sName.equals(name))
//          {
//              amdinId=e.getKey();
//          }
//        }
//        if(amdinId==0)
//        {
//            System.out.println(name+"The Name you have entered is invalid");
//            return null;
//        }
//        else {
//            return db.get(amdinId);
      //  }

    //}
    //Adding student information to hashmap
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
        String result=serviceController.addStudent(student);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_student")
public ResponseEntity deleteStudent(@RequestParam("r") int admnNo)
{
   String result=serviceController.deleteStudent(admnNo);
   if(result.equals("student all ready not present"))
   {
       return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
   }
   return new ResponseEntity<>(result,HttpStatus.FOUND);
}
@PutMapping("/update_student")
public ResponseEntity updateStudent(@RequestParam("a") int admnNo,@RequestBody Student student)
{
    String result=serviceController.updateStudent(admnNo,student);
    if(result.equals("No match found for update"))
    {
        return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
}
}
