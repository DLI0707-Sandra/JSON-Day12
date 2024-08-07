package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManager
{
    public static void main(String[] args)
    {
        Gson gson=new Gson();

        List<Employee> employees_list =new ArrayList<>();

        try(FileReader fileReader=new FileReader("employee.json");)
        {
            Employee[] employees=gson.fromJson(fileReader,Employee[].class);
            employees_list.addAll(Arrays.asList(employees));

        }catch(IOException e)
        {
            System.out.println("IO exception!");
        }

        System.out.println("List of employees:");
        System.out.println(employees_list);

    }
}
