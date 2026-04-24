package level2.HotelReservationSystem;

import level2.HotelReservationSystem.enums.RoomStatus;
import level2.HotelReservationSystem.enums.RoomType;

import java.util.ArrayList;

public class Room {
    final private   String roomNumber;
    final private RoomType type;
    private RoomStatus  status;
    final private int floor;
    private double pricePerNight;
    private int maxOccupancy;
    private ArrayList<String> amenities;

    Room( String roomNumber, RoomType type, RoomStatus  status, int floor, double pricePerNight, int maxOccupancy){
        this.roomNumber=roomNumber;
        this.type=type;
        this.status=status;
        this.floor=floor;
        this.pricePerNight=pricePerNight;
        this.maxOccupancy=maxOccupancy;
        this.amenities=new ArrayList<>();
    }


   public double getPrice(long N){
        return N*pricePerNight;
   }


    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public RoomStatus isAvailable() {
        return status;
    }

    public void changeStatus(RoomStatus status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }



    public String getDescription() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", floor=" + floor +
                ", pricePerNight=" + pricePerNight +
                ", maxOccupancy=" + maxOccupancy +
                ", amenities=" + amenities +
                '}';
    }
}
