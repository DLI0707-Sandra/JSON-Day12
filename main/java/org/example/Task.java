package org.example;

public class Task
{
    int task_id;
    String description;
    String due_date;
    boolean completed;

    public Task(){}

    public Task(int task_id, String description, String due_date, boolean completed) {
        this.task_id = task_id;
        this.description = description;
        this.due_date = due_date;
        this.completed = completed;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return getTask_id()+" "+description+" "+due_date+" "+completed;
    }
}
