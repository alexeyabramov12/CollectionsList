package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();


    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a task");
            String userString = new Scanner(System.in).nextLine().toLowerCase();

            if (userString.equals("0")) {
                break;
            }

            if (userString.contains("add")) {
                String regex = "[0-9]+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(userString);
                if (matcher.find()) {
                    addAndNumber(userString);
                } else {
                    add(userString);
                }
                continue;
            }
            if (userString.contains("edit")) {
                edit(userString);
                continue;
            }
            if (userString.contains("delete")) {
                delete(userString);
                continue;
            }
            if (userString.contains("list")) {
                todoList.getList();
            }
        }
    }

    public static void add(String userString) {
        int start = userString.indexOf("add");
        int space1 = userString.indexOf(' ', start);
        String text = userString.substring(space1 + 1);
        todoList.add(text);
        System.out.println("Added task " + "\"" + text + "\"");
    }

    public static void addAndNumber(String userString) {
        int start = userString.indexOf("add");
        int space1 = userString.indexOf(' ', start);
        int space2 = userString.indexOf(' ', space1 + 1);
        String number = userString.substring(space1 + 1, space2);
        int index = Integer.parseInt(number);
        String text = userString.substring(space2 + 1);
        todoList.add(index, text);
        System.out.println("Added task " + "\"" + text + "\"");
    }

    public static void edit(String userString) {
        int start = userString.indexOf("edit");
        int space1 = userString.indexOf(' ', start);
        int space2 = userString.indexOf(' ', space1 + 1);
        String number = userString.substring(space1 + 1, space2);
        int index = Integer.parseInt(number);
        String text = userString.substring(space2 + 1);
        if (index > todoList.getArraySize()) {
            todoList.edit(index, text);
        }else {
            String oldText = todoList.getTodos(index);
            todoList.edit(index, text);
            System.out.println("Task " + "\"" + oldText + "\"" + " Replaced with " + "\"" + text + "\"");
        }
    }

    public static void delete(String userString) {
        int start = userString.indexOf("delete");
        int space1 = userString.indexOf(' ', start);
        String number = userString.substring(space1 + 1);
        int index = Integer.parseInt(number);
        if (index > todoList.getArraySize()) {
            todoList.delete(index);
        } else {
            String oldText = todoList.getTodos(index);
            todoList.delete(index);
            System.out.println("Task " + "\"" + oldText + "\"" + " Deleted");
        }
    }
}
