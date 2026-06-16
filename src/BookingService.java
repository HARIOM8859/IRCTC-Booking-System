import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainlist = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService() {
        trainlist.add(new Train(101, "Rajdhani Express", "Delhi", "Nagpur", 100));
        trainlist.add(new Train(102, "Doronto Express", "Nagpur", "Mumbai", 60));
        trainlist.add(new Train(103, "Satabdi Express", "Jamnagar", "Agra", 70));
        trainlist.add(new Train(104, "Hawrrah Express", "Jammu", "Bengal", 10));
        trainlist.add(new Train(105, "Tejas Express", "Agra", "Jammu", 50));
        trainlist.add(new Train(106, "Gatiman Express", "Delhi", "Jamnagar", 20));
    }
    //date add krna hai..

    public List<Train> searchTrain(String source, String destination) {
        List<Train> res = new ArrayList<>();
        for (Train train : trainlist) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDest().equalsIgnoreCase(destination)) {
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user, int trainid, int seatcount) {
        for (Train train : trainlist) {
            if (train.getTrainId() == trainid) {
                if (train.BookSeats(seatcount)) {
                    Ticket ticket = new Ticket(user, train, seatcount);
                    ticketList.add(ticket);
                    return ticket;
                } else {
                    System.out.println("Not enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train ID not found");
        return null;
    }

    public List<Ticket> getallticketsbyuser(User user) {
        List<Ticket> res = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                res.add(ticket);
            }
        }
        return res;
    }

    //.........................Unable to understand the iterators........................(Work On it)
    public boolean cancelticket(int ticketid, User user) {
        Iterator<Ticket> iterator = ticketList.listIterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketid() == ticketid && ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                Train train = ticket.getTrain();
                train.CancelSeat(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket " + ticketid + " cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket does not belong to current user");
        return false;
    }

    public void listAllTrains(){
        System.out.println("List of all trains: ");
        for(Train train: trainlist){
            System.out.println(train);
        }
    }
}
