import java.util.List;
import java.util.Scanner;

public class IRCTCapp {
    private final Scanner scanner = new Scanner(System.in);
    private final UserServices userServices = new UserServices();
    private final BookingService bookingService = new BookingService();
    //everything is loaded before the app starts.
    public static void main(String[] args) {
        new IRCTCapp().start();
    }
    public void start(){
        while(true){
            System.out.println("--------Welcome to IRCTC APP---------");
            if(!userServices.isloggedin()){
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> Exitapp();
                    default -> System.out.println("Invalid choice");
                }
            }
            else {
                showUserMenu();
            }
        }
    }
    public void register(){
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.print("Enter Full Name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.next();
        userServices.registerUser(username,password,fullName,contact);
        userServices.LoginUser(username,password);
    }
    public void login(){
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        userServices.LoginUser(username,password);
    }

    private void showUserMenu(){
        while (userServices.isloggedin()){
            System.out.println("\n---------User Menu---------");
            System.out.println("1. Search Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View All Trains");
            System.out.println("6. Logout");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> searchTrain();
                case 2 -> BookTicket();
                case 3 -> viewMyticket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userServices.logoutuser();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void searchTrain(){
        System.out.print("Enter source Station: ");
        String source = scanner.next();
        System.out.print("Enter destination Station: ");
        String destination = scanner.next();
        List<Train> trains = bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("Train not found between "+source+" and "+destination);
            return;
        }
        System.out.print("Trains found: ");
        for(Train train: trains){
            System.out.println(train);
        }
        System.out.println("Do you want to Book the Train? (Yes/No): ");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter trainID to Book:");
            int trainID = scanner.nextInt();
            System.out.print("Enter number of seats to book:");
            int seats = scanner.nextInt();

            Ticket ticket = bookingService.bookTicket(userServices.getCurrentuser(), trainID, seats);
            if (ticket != null) {
                System.out.println("Booking Successful!");
                System.out.println(ticket);
            }
        }
        else {
            System.out.println("Returning to user menu...");
        }
    }
    private void BookTicket(){
        System.out.print("Enter source Station: ");
        String source = scanner.next();
        System.out.print("Enter destination Station: ");
        String destination = scanner.next();
        List<Train> trains = bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("No Trains Available for Booking");
            return;
        }
        System.out.print("Available trains: ");
        for(Train train: trains){
            System.out.println(train);
        }
        System.out.print("Enter trainID to Book:");
        int trainID = scanner.nextInt();
        System.out.print("Enter number of seats to book:");
        int seats = scanner.nextInt();

        Ticket ticket = bookingService.bookTicket(userServices.getCurrentuser(), trainID, seats);
        if (ticket != null) {
            System.out.println("Booking Successful!");
            System.out.println(ticket);
        }
    }

    private void viewMyticket(){
        List<Ticket> ticketbyuser = bookingService.getallticketsbyuser(userServices.getCurrentuser());
        if(ticketbyuser.isEmpty()){
            System.out.println("Booked Ticket not found...");
        }
        else{
            System.out.print("Your Tickets:");
            for (Ticket ticket:ticketbyuser){
                System.out.println(ticket);
            }
        }
    }

    private void cancelTicket(){
        System.out.print("Enter TicketID to cancel");
        int ticketID = scanner.nextInt();
        bookingService.cancelticket(ticketID,userServices.getCurrentuser());
    }

    private void Exitapp(){
        System.out.println("Thankyou! For Using IRCTC App...");
        System.exit(0);
    }
}
