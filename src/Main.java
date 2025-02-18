package src;

import src.Domain.Produkte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Controller controller = new Controller();

    public void UI() {
        System.out.println("Welcome! Please choose an option:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    0-Exit
                    1-Create Produkt
                    2-Remove Produkt
                    3-Update Produkt
                    4-Get Produkt
                    5-Get All Produkte
                    """);
            String input = scanner.nextLine();
            switch (input) {
                case "0": {
                    System.out.println("Goodbye!");
                    return;
                }
                case "1": {
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the price:");
                    String price = scanner.nextLine();
                    System.out.println("Please enter the univerzum:");
                    String univerzum = scanner.nextLine();
                    controller.createProdukt(name, Integer.parseInt(price), univerzum);
                    break;
                }
                case "2": {
                    System.out.println("Please enter the Name:");
                    String name = scanner.nextLine();
                    controller.removeProdukt(name);
                    break;
                }
                case "3": {
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the price:");
                    String price = scanner.nextLine();
                    System.out.println("Please enter the univerzum:");
                    String univerzum = scanner.nextLine();
                    controller.updateProduct(name, Integer.parseInt(price), univerzum);
                    break;
                }
                case "4": {
                    System.out.println("Please enter the Name:");
                    String name = scanner.nextLine();
                    Produkte produkte = controller.getProdukt(name);
                    if (produkte != null)
                        System.out.println(produkte);
                    else
                        System.out.println("No Produkt with this ID found!");
                    break;
                }
                case "5": {
                    controller.getAllProdukten().forEach(System.out::println);
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.UI();
    }
}