package level2.HotelReservationSystem;


public class Guest {

    private String guestId;
    private String name;
    private String email;
    private String phone;
    private String idNumber;
    private int loyaltyPoints;


    public Guest(String guestId, String name, String email, String phone, String idNumber, int loyaltyPoints) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idNumber = idNumber;
        this.loyaltyPoints = loyaltyPoints;
    }


    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            this.loyaltyPoints += points;
        }
    }
    public double getDiscountRate() {
        if (loyaltyPoints >= 5000) {
            return 0.20;
        } else if (loyaltyPoints >= 1000) {
            return 0.10;
        } else {
            return 0.0;
        }
    }


    public String getGuestId() {
        return guestId;
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

    public String getIdNumber() {
        return idNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }


    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getGuestInfo() {
        return "Guest ID: " + guestId +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nID Number: " + idNumber +
                "\nLoyalty Points: " + loyaltyPoints;
    }
}