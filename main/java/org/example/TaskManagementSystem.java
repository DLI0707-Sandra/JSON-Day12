package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManagementSystem
{
    public static void main(String[] args)  {
        List<Task>tasks=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        int choice;
        Path path= Paths.get("src/main/java/org/example/tasks.json");
        Gson gson=new Gson();

        do {
            System.out.println("1.Add a task\n2.View all tasks\n3.Update tasks\n4.Delete task\n5.Mark as ompleted\n6.Exit");
            System.out.println("Enter your choice:");
            choice=scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter details:");
                    System.out.println("Enter id:");
                    Task task=new Task();
                    task.setTask_id(scanner.nextInt());
                    System.out.println("Enter description:");
                    task.setDescription(scanner.next());
                    System.out.println("Enter the date:");
                    task.setDue_date(scanner.next());
                    task.setCompleted(false);
                    tasks.add(task);
                    Task[] tasks1= tasks.toArray(new Task[0]);
                    String jsontask= gson.toJson(tasks1);
                    try
                    {
                        Files.write(path,jsontask.getBytes());
                    }catch (IOException e)
                    {
                        System.out.println("IO exception!");
                    }
                    break;
                case 2:
                    try
                    {
                        System.out.println("Tasks:");
                        FileReader fileReader=new FileReader("src/main/java/org/example/tasks.json");
                        Task[] tasks2=gson.fromJson(fileReader,Task[].class);
                        for(Task task2:tasks2)
                        {
                            System.out.println(task2);
                        }
                    }catch (IOException e)
                    {
                        System.out.println("IO exception!");
                    }

                    break;
                case 3:System.out.println("Enter the id of the task:");
                    int Id=scanner.nextInt();
                    Task tobeupdated =new Task();
                    for(Task task1:tasks)
                    {
                        if(task1.getTask_id()==Id)
                            tobeupdated =task1;
                    }
                    System.out.println("Enter the field to be modified:");
                    String field=scanner.next();
                    switch (field)
                    {
                        case "description":
                            System.out.println("Enter the new value:");
                            tobeupdated.setDescription(scanner.next());
                            break;
                        case  "due":System.out.println("Enter the new value:");
                            tobeupdated.setDue_date(scanner.next());
                            break;
                    }
                    Task[] taskss = tasks.toArray(new Task[0]);
                    String jsonnewtasks = gson.toJson(taskss);
                    try
                    {
                        Files.write(path, jsonnewtasks.getBytes());
                    }catch (IOException e)
                    {
                        System.out.println("IO exception!");
                    }
                    break;
                case 4:System.out.println("Enter the id of the task:");
                    int ID=scanner.nextInt();
                    Task toberemoved=new Task();
                    for(Task task1:tasks)
                    {
                        if(task1.getTask_id()==ID)
                            toberemoved=task1;
                    }
                    tasks.remove(toberemoved);
                    Task[] newtasks = tasks.toArray(new Task[0]);
                    String jsonnewtask = gson.toJson(newtasks);
                    try
                    {
                        Files.write(path, jsonnewtask.getBytes());
                    }catch (IOException e)
                    {
                        System.out.println("IO exception!");
                    }
                    break;
                case 5:
                    System.out.println("Enter the id of the task:");
                    int id=scanner.nextInt();
                    for(Task task1:tasks)
                    {
                        if(task1.getTask_id()==id)
                            task1.setCompleted(true);
                    }
                    Task[] updatedtasks= tasks.toArray(new Task[0]);
                    String jsonupdatedtask = gson.toJson(updatedtasks);
                    try
                    {
                        Files.write(path, jsonupdatedtask.getBytes());
                    }catch (IOException e)
                    {
                        System.out.println("IO exception!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting!");
                    break;
            }

        }while (choice!=6);

    }
}
