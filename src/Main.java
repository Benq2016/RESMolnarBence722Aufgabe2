package src;

import src.Domain.Characteren;
import src.Domain.Produkte;

import javax.xml.namespace.QName;
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
                    6-Create Characteren
                    7-Remove Characteren
                    8-Update Characteren
                    9-Get Characteren
                    10-Get All Characteren
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
                case "6": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the region:");
                    String region = scanner.nextLine();
                    System.out.println("Please enter the the produkt-name(0 to stop):");
                    controller.getAllProdukten().forEach(System.out::println);
                    List<Produkte> produkteList = new ArrayList<>();
                    String option = scanner.nextLine();
                    while (!option.equals("0")) {
                        produkteList.add(controller.getProdukt(option));
                        option = scanner.nextLine();
                    }
                    controller.createCharacter(Integer.parseInt(id), name, region, produkteList);
                    break;
                }
                case "7": {
                    System.out.println("Please enter the Name:");
                    String name = scanner.nextLine();
                    controller.removeCharacteren(name);
                    break;
                }
                case "8": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the region:");
                    String region = scanner.nextLine();
                    System.out.println("Please enter the the produkt-name(0 to stop):");
                    controller.getAllProdukten().forEach(System.out::println);
                    List<Produkte> produkteList = new ArrayList<>();
                    String option = scanner.nextLine();
                    while (!option.equals("0")) {
                        produkteList.add(controller.getProdukt(option));
                        option = scanner.nextLine();
                    }
                    controller.updateCharacteren(Integer.parseInt(id), name, region, produkteList);
                    break;
                }
                case "9": {
                    System.out.println("Please enter the Name:");
                    String name = scanner.nextLine();
                    Characteren characteren = controller.getCharacteren(name);
                    if (characteren != null)
                        System.out.println(characteren);
                    else
                        System.out.println("No Characteren with this Name found!");
                    break;
                }
                case "10": {
                    controller.getAllCharacteren().forEach(System.out::println);
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