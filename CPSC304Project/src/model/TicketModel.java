package model;

public class TicketModel extends TupleModel {
    private int ticketNo;
    private int trainId;
    private String trainClass;
    private String row;
    private int seatNo;

    public TicketModel(int ticketNo, int trainId, String trainClass, String row, int seatNo) {
        this.ticketNo = ticketNo;
        this.trainId = trainId;
        this.trainClass = trainClass;
        this.row = row;
        this.seatNo = seatNo;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public int getTrainId() {
        return trainId;
    }

    public String getId() {
        return trainClass;
    }

    public String getRow() {
        return row;
    }

    public int getSeatNo() {
        return seatNo;
    }
}
