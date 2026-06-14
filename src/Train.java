public class Train {
    private int TrainId;
    private String TrainName;
    private String Source;
    private String Dest;
    private int Totalseats;
    private int AvailableSeats;

    public Train(int trainId, String trainName, String source, String dest, int totalseats) {
        TrainId = trainId;
        TrainName = trainName;
        Source = source;
        Dest = dest;
        Totalseats = totalseats;
        AvailableSeats = totalseats;
    }

    public int getTrainId() {
        return TrainId;
    }

    public void setTrainId(int trainId) {
        TrainId = trainId;
    }

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String trainName) {
        TrainName = trainName;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDest() {
        return Dest;
    }

    public void setDest(String dest) {
        Dest = dest;
    }

    public int getTotalseats() {
        return Totalseats;
    }

    public void setTotalseats(int totalseats) {
        Totalseats = totalseats;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        AvailableSeats = availableSeats;
    }
    public boolean BookSeats(int Count){
        if(Count <= AvailableSeats){
            AvailableSeats -= Count;
            return true;
        }
        return false;
    }
    public void CancelSeat(int Count){
        AvailableSeats += Count;
    }

    @Override
    public String toString() {
        return TrainId + " | " + TrainName + " | " + Source + " -> " + Dest + " | " + Totalseats + " Available Seats: " + AvailableSeats;
    }
}
