package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager
{
    public static void main(String[] args)
    {
        Gson gson=new Gson();
        List<Employee> employees_list =new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of the employee to be updated:");
        String name=scanner.next();

        try(FileReader fileReader=new FileReader("employee.json");)
        {
            Employee[] employees=gson.fromJson(fileReader,Employee[].class);
            employees_list.addAll(Arrays.asList(employees));
            for(Employee employee:employees_list)
            {
                if(employee.getName().equals(name))
                {
                    System.out.println("Enter the field to be modified:");
                    String field=scanner.next();
                    switch (field)
                    {
                        case "age":
                            System.out.println("Enter the new value:");
                            employee.setAge(scanner.nextInt());
                            break;
                        case "address": System.out.println("Enter the new value:");
                            employee.setAddress(scanner.next());
                            break;
                    }
                }
            }

        }catch(IOException e)
        {
            System.out.println("IO exception!");
        }

        System.out.println("List of employees:");
        System.out.println(employees_list);

        try(FileWriter fileWriter=new FileWriter("employee.json");)
        {
            Employee[] updated=employees_list.toArray(new Employee[0]);
            gson.toJson(updated,fileWriter);

        }catch (IOException e){
            System.out.println("IO exception!");
        }

    }
}
