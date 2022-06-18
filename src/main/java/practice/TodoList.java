package practice;

import java.util.ArrayList;

public class TodoList {

    private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= todoList.size()) {
            todoList.add(todo);
        } else {todoList.add(index, todo);}
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= todoList.size()) {
            System.out.println("Дело с таким номером не существует");
        } else {todoList.set(index, todo);}
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= todoList.size()) {
            System.out.println("Дело с таким номером не существует");
        } else {todoList.remove(index);}
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
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