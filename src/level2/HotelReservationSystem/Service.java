package level2.HotelReservationSystem;

public class Service implements IChargeable {


    private String serviceId;
    private String name;
    private double price;
    private String description;


    public Service(String serviceId, String name, double price, String description) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public String getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }


    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }


}