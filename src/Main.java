import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<Task> tasks;
    private final Scanner scanner;

    private Main() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to ToDoListApp!");
        System.out.println("1. Add task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your Choice: ");
    }

    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void markTaskAsComplete() {
        // Display tasks
        viewTasks();

        // Prompt user to select a task
        System.out.print("Enter task number to as complete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        // Check if task number is valid
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1 );
            task.setCompleted(true);
            System.out.println(STR."Task \"\{task.getDescription()}\" marked as complete!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void viewTasks() {
        System.out.println("Task:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(STR."\{i + 1}. \{task.getDescription()} - \{task.isCompleted() ? "Completed" : "Pending"}");
        }
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using ToDoListApp. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}