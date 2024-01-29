package homework_7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class toy_shop {
    public static void main(String[] args) {

        mainMenuChoice();


        
        
        Toys toy1 = new Toys(1, "конструктор", 20);
        Toys toy2 = new Toys(2, "робот", 20);
        Toys toy3 = new Toys(3, "кукла", 60);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(toy1.toy_value, toy1.toy_id);
        map.put(toy2.toy_value, toy2.toy_id);
        map.put(toy3.toy_value, toy3.toy_id);

        
    }
    private static HashMap<Integer, Integer> queue = new HashMap<>();
    
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
                    System.out.println(sortTheMap());  // Сортировка по количеству телефонов не работает
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

    public class Toys {
        private Integer toy_id;
        private String toy_name;
        private Integer toy_value;

        public Toys(Integer toy_id, String toy_name, Integer toy_value) {
            this.toy_id = toy_id;
            this.toy_name = toy_name;
            this.toy_value = toy_value;
        }

          
    }
}
