import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}

public class CustomerRelationshipManagement {
    private static final Map<String, Customer> customers = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    displayAllCustomers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);
        System.out.println("Customer added successfully!");
    }

    private static void findByName() {
        System.out.print("Enter customer name to find: ");
        String name = scanner.nextLine();
        Customer customer = customers.get(name);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void displayAllCustomers() {
        System.out.println("All Customers:");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }
}