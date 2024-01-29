package homework_7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class toy_shop {
    public static void main(String[] args) {

        mainMenuChoice();

    }
    private static HashMap<Integer, Integer> queue = new HashMap<>();
    private static ArrayList<Integer, String, Integer> toysList = new ArrayList<>();
    
    public static void mainMenuChoice() {
        System.out.println("- Главное меню -");
        System.out.println();
        System.out.println("- 1. Просмотр списка игрушек -");
        System.out.println("- 2. Случайный выбор игрушки -");
        System.out.println("- 3. Добавить игрушку -");
        System.out.println("- 0. Выход -");
        System.out.println();
        System.out.println("Выберите пункт меню");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    /* Вывод игрушек */
                    System.out.println("Наши игрушки:");                  
                    System.out.println(getToysList());  // Сортировка по количеству телефонов не работает
                    System.out.println();
                    mainMenuChoice();

                case 2:
                    /* Рандом игрушки */
                    
                    mainMenuChoice();

                case 3:
                    /* Создаём игрушку */
                    Scanner newContScanner = new Scanner(System.in);
                    System.out.println();
                    System.out.println("- Введите порядковый номер игрушки -");
                    Integer newid = newContScanner.nextInt();
                    System.out.println("- Введите порядковый номер игрушки -");
                    String newtoy_name = newContScanner.nextLine();
                    System.out.println("- Введите шанс в % -");
                    Integer newtoy_value = newContScanner.nextInt();

                    add(newid, newtoy_value);
                    configureLogger();
                    toysList.add(newid, newtoy_name, newtoy_value);
                    System.out.println("Игрушка внесена");
                    System.out.println();
                    mainMenuChoice();

                case 0:
                    /* Выход из программы */
                    System.out.println();
                    System.out.println("Выходим...");
                    break;

                default:
                    mainMenuChoice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void add(Integer id, Integer value) {
        queue.put(id, value);        
    }

    public static StringBuilder ToList(Integer id, String name, Integer value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(id)).append(name).append(Integer.toString(value));
        return stringBuilder;            
    }


    public static HashMap<String, ArrayList<Integer>> getToysList() {

        return queue;
    }

    public void configureLogger() {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            toyList.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
