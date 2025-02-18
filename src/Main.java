package src;

import src.Domain.Characteren;
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
                    controller.createProdukt(name, Double.parseDouble(price), univerzum);
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
                    controller.updateProduct(name, Double.parseDouble(price), univerzum);
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
                case "11": {
                    System.out.println("Please enter the Region:");
                    String region = scanner.nextLine();
                    controller.filterRegion(region).forEach(System.out::println);
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        controller.createProdukt("Mjolnir", 500.0, "Asgard");
        controller.createProdukt("Vibranium-Schild", 700.0, "Wakanda");
        controller.createProdukt("Infinity Gauntlet", 10000.0, "Titan");
        controller.createProdukt("Web-Shooter", 250.0, "Terra");
        controller.createProdukt("Arc-Reaktor", 1500.0, "Terra");
        controller.createProdukt("Norn Stones", 1200.0, "Asgard");
        controller.createProdukt("Quantum Suit", 3000.0, "Terra");
        controller.createProdukt("X-Gene Serum", 850.0, "X-Mansion");
        controller.createProdukt("Cosmic Cube", 9000.0, "Multiverse");
        controller.createProdukt("Darkhold", 2000.0, "Multiverse");

        List<Produkte> pl1 = new ArrayList<>();
        pl1.add(controller.getProdukt("Mjolnir")); pl1.add(controller.getProdukt("Norn Stones"));
        pl1.add(controller.getProdukt("Darkhold"));
        controller.createCharacter(1, "Thor", "Asgard", pl1);

        List<Produkte> pl2 = new ArrayList<>();
        pl2.add(controller.getProdukt("Vibranium-Schild")); pl2.add(controller.getProdukt("X-Gene Serum"));
        controller.createCharacter(2, "Black Panther", "Wakanda", pl2);

        Main main = new Main();
        main.UI();
    }
}