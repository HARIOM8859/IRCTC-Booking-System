public class Ticket {
    private static int counter= 1000;
    private int ticketid;
    private User user;
    private Train train;
    private String SeatBooked;

    public Ticket(User user, Train train, String seatBooked) {
        this.ticketid = counter++;
        this.user = user;
        this.train = train;
        SeatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getSeatBooked() {
        return SeatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        SeatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "TicketId: "+ticketid+ " | Train: "+ train.getTrainName() + " | Passenger Name: "+ user.getFullName()
                + " | Status: "+getSeatBooked() + " | From "+ train.getSource() + " | To "+ train.getDest();
    }
}
