public class Ticket {
    private static int counter= 1000;
    private int ticketid;
    private User user;
    private Train train;
    private int SeatBooked;

    public Ticket(User user, Train train, int seatBooked) {
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

    public int getSeatBooked() {
        return SeatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        SeatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "TicketId: "+ticketid+ " | Train: "+ train.getTrainName() + " | Passenger Name: "+ user.getFullName()
                + " | Seats Booked: "+getSeatBooked() + " | From "+ train.getSource() + " | To "+ train.getDest();
    }
}
