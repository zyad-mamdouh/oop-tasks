package level2.HotelReservationSystem;

import level2.HotelReservationSystem.enums.ReservationStatus;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import static level2.HotelReservationSystem.enums.ReservationStatus.Pending;

public class Reservation {
    private String reservationId;
    private Guest guest;
    private  Room room;
    private  LocalDate  checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus status;
    private ArrayList<Service> services ;
    private int totalGuests;

    public Reservation(String reservationId, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, int totalGuests) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalGuests = totalGuests;

        this.status =Pending;
        this.services = new ArrayList<>();
    }

    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }
    public  double getRoomCost(){
        return getNumberOfNights() * room.getPrice(getNumberOfNights());
    }
    public  double getServicesCost(){
        double total = 0;

        if (services == null) return 0;

        for (Service s: services){
            total+=s.getPrice();
        }
        return total;
    }

public double getTotal() {
    return getRoomCost() + getServicesCost();
}
  public void addService(Service service){

    if (service == null) {
              throw new IllegalArgumentException("Service cannot be null");
          }

          services.add(service);
  }

  public  void checkIn(){
      if (this.status !=ReservationStatus.Pending) {
          throw new IllegalStateException("Cannot check in: invalid reservation status");
      }
      if (LocalDate.now().isBefore(checkInDate)) {
          throw new IllegalStateException("Cannot check in before check-in date");
      }
      this.status = ReservationStatus.CheckedIn;
  }

    public void checkOut() {
        if (this.status != ReservationStatus.CheckedIn) {
            throw new IllegalStateException("Cannot check out: invalid reservation status");
        }

        if (LocalDate.now().isBefore(checkInDate)) {
            throw new IllegalStateException("Cannot check out before check-in date");
        }

        this.status = ReservationStatus.CheckedOut;
    }
    public void cancel() {
        if (this.status != ReservationStatus.Pending) {
            throw new IllegalStateException("Cannot cancel: reservation is not pending");
        }

        this.status = ReservationStatus.Cancelled;
    }
    public String getReservationDetails() {
        return "Reservation ID: " + reservationId + "\n"
                + "Guest: " + guest.getName() + "\n"
                + "Room: " + room.getRoomNumber() + "\n"
                + "Check-in: " + checkInDate + "\n"
                + "Check-out: " + checkOutDate + "\n"
                + "Nights: " + getNumberOfNights() + "\n"
                + "Total Guests: " + totalGuests + "\n"
                + "Status: " + status + "\n"
                + "Room Cost: " + getRoomCost() + "\n"
                + "Services Cost: " + getServicesCost() + "\n"
                + "Total Cost: " + (getRoomCost() + getServicesCost()) + "\n";
    }

}


