package views;

import controller.TopicController;
import java.util.Scanner;

public class TopicsUI {
    public static void main(String[] args) {
        TopicController controller = new TopicController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n---- Learning Log Menu ----");
            System.out.println("1. Add New Topic");
            System.out.println("2. View All Topics");
            System.out.println("3. Add Entry to a Topic");
            System.out.println("4. View Topics By Name");
            System.out.println("5. View Entries of a Topic");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter topic name: ");
                    String name = scanner.nextLine();
                    controller.addTopic(name);
                }
                case 2 -> controller.viewAllTopics();
                case 3 -> {
                    System.out.print("Enter Topic ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter note: ");
                    String note = scanner.nextLine();
                    controller.addEntryToTopic(id, note);
                }
                case 4 -> {
                	System.out.print("Enter the name of topic (separated by commas):");
                	String input = scanner.nextLine();
                	controller.viewTopicsByNames(input);
                }
                case 5 -> {
                	System.out.print("Enter the Topic Name or ID");
                	String input = scanner.nextLine();
                	scanner.nextLine();
                	controller.viewEntriesByTopic(input);
                }
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}