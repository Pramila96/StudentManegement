package com.example.StudentManegement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryController {
    Map<Integer,Student> db=new HashMap<>();
    //Get information of Student

    public Student getStudent( int admnNo)
    {
        //Student student=ServiceController.getStudent(admnNo);
         return db.get(admnNo);
    }
    public Student getStudent( String name)
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

    public String addStudent( Student student)
    {
        int admnnNo=student.getAdmnNo();
        db.put(admnnNo,student);
        return "student added successfully";
    }
    public String deleteStudent( int admnNo)
    {
        if(db.containsKey(admnNo))
        {
            db.remove(admnNo);
            return "Student deleted successfully";
        }
        return "student all ready not present";
    }

    public String updateStudent( int admnN0, Student student)
    {
        if(db.containsKey(admnN0)) {
            int admnNo = student.getAdmnNo();
            db.put(admnNo, student);
            return "Student information updated successfully";
        }
        return "No match found for update";
    }
}
