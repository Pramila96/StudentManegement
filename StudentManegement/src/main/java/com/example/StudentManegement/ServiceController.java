package com.example.StudentManegement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceController {
    @Autowired
    RepositoryController repositoryController;
    public String addStudent(Student student)
    {
        return repositoryController.addStudent(student);
    }

    public String deleteStudent(int id)
    {
        return repositoryController.deleteStudent(id);
    }
    public String updateStudent(int id,Student student)
    {
        return repositoryController.updateStudent(id,student);
    }
    public Student getStudent(int id)
    {
        return  repositoryController.getStudent(id);
    }

}
