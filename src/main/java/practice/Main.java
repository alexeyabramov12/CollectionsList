package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();


    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        while (true) {
            String userString = new Scanner(System.in).nextLine();

            String regex = "[0-9]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userString);

            if (userString.contains("ADD") && matcher.find()) {
                int start = userString.indexOf("ADD");
                int space1 = userString.indexOf(' ', start);
                int space2 = userString.indexOf(' ', space1 + 1);
                String number = userString.substring(space1 + 1, space2);
                int index = Integer.parseInt(number);
                String text = userString.substring(space2 + 1);
                todoList.add(index, text);
                System.out.println("Добавлено дело " + "\"" + text + "\"");
                continue;
            }
            if (userString.contains("ADD")) {
                int start = userString.indexOf("ADD");
                int space1 = userString.indexOf(' ', start);
                String text = userString.substring(space1 + 1);
                todoList.add(text);
                System.out.println("Добавлено дело " + "\"" + text + "\"");
                continue;
            }
            if (userString.contains("EDIT")) {
                int start = userString.indexOf("EDIT");
                int space1 = userString.indexOf(' ', start);
                int space2 = userString.indexOf(' ', space1 + 1);
                String number = userString.substring(space1 + 1, space2);
                int index = Integer.parseInt(number);
                String text = userString.substring(space2 + 1);
                String oldText = todoList.getTodos(index);
                todoList.edit(index, text);
                System.out.println("Дело " + "\"" + oldText + "\"" + " Заменено на " + "\"" + text + "\"");
                continue;
            }
            if (userString.contains("DELETE")) {
                int start = userString.indexOf("DELETE");
                int space1 = userString.indexOf(' ', start);
                String number = userString.substring(space1 + 1);
                int index = Integer.parseInt(number);
                if (index > todoList.getArraySize()) {
                    todoList.delete(index);
                    continue;
                }
                String oldText = todoList.getTodos(index);
                todoList.delete(index);
                System.out.println("Дело " + "\"" + oldText + "\"" + " удалено");
                continue;
            }
            if (userString.contains("LIST")) {
                todoList.getList();
            }
        }
    }
}
