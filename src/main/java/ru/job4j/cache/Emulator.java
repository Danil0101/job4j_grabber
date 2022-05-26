package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache fileCache = null;
        int input = 0;
        while (input != 4) {
            input = printMenu(scanner);
            switch (input) {
                case (1):
                    System.out.print("Укажите директорию: ");
                    fileCache = new DirFileCache(scanner.nextLine());
                    break;
                case (2):
                    if (fileCache == null) {
                        System.out.println("Кэшируемая директория не указана");
                    } else {
                        System.out.print("Укажите имя фала: ");
                        String key = scanner.nextLine();
                        fileCache.put(key, fileCache.load(key));
                    }
                    break;
                case (3):
                    if (fileCache == null) {
                        System.out.println("Кэшируемая директория не указана");
                    } else {
                        System.out.print("Укажите имя фала: ");
                        String key = scanner.nextLine();
                        System.out.println(fileCache.get(key));
                    }
                    break;
                case (4):
                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
        scanner.close();
    }

    static int printMenu(Scanner scanner) {
        System.out.print(
                "\n1. Указать кэшируемую директорию\n"
                + "2. Загрузить содержимое файла в кэш\n"
                + "3. Получить содержимое файла из кэша\n"
                + "4. Выход\n"
                + "Выберете операцию: "
        );
        return Integer.parseInt(scanner.nextLine());
    }
}
