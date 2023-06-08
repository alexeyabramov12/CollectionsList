package practice;

import java.util.ArrayList;

public class TodoList {

    private static final String ERROR = "Task with this number does not exist";

    private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        if (index >= todoList.size()) {
            todoList.add(todo);
        } else {todoList.add(index, todo);}
    }

    public void edit(int index, String todo) {
        if (index >= todoList.size()) {
            System.out.println(ERROR);
        } else {todoList.set(index, todo);}
    }

    public void delete(int index) {
        if (index >= todoList.size()) {
            System.out.println(ERROR);
        } else {todoList.remove(index);}
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }

    public String getTodos(int index) {
        return todoList.get(index);
    }

    public void getList() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + " - " + todoList.get(i));
        }
    }
    public int getArraySize() {
        return todoList.size();
    }
}