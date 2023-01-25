package com.example.StudentManegement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
Map<Integer,Student> db=new HashMap<>();
//Get information of Student
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo)
    {
        return db.get(admnNo);
    }

    //Get information by name
    @GetMapping("/get_student_byname")
    public Student getStudent(@RequestParam("n") String name)
    {
        int amdinId=0;
        for(Map.Entry<Integer,Student> e:db.entrySet())
        {
          Student std=e.getValue();
          String sName=std.getName();
          if(sName.equals(name))
          {
              amdinId=e.getKey();
          }
        }
        if(amdinId==0)
        {
            System.out.println(name+"The Name you have entered is invalid");
            return null;
        }
        else {
            return db.get(amdinId);
        }

    }
    //Adding student information to hashmap
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student)
    {
        int admnnNo=student.getAdmnNo();
        db.put(admnnNo,student);
        return "student added successfully";
    }
    @DeleteMapping("/delete_student")
public String deleteStudent(@RequestParam("r") int admnNo)
{
    if(db.containsKey(admnNo))
    {
       db.remove(admnNo);
       return "Student deleted successfully";
    }
    return "student all ready not present";
}
@PutMapping("/update_student")
public String updateStudent(@RequestParam("a") int admnN0,@RequestBody Student student)
{
    if(db.containsKey(admnN0)) {
        int admnNo = student.getAdmnNo();
        db.put(admnNo, student);
        return "Student information updated successfully";
    }
    return "No match found for update";
}
}
