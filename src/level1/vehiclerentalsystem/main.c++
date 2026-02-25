#include <iostream>
#include <string>
#include <vector>
using namespace std;
#include <string>
#include <chrono>


class Vehicle {

private:
    std::string vehicleId;
    std::string make;
    std::string model;
    int year;
    double dailyRate;
    bool isAvailable;

public:
    Vehicle(std::string vehicleId,
            std::string make,
            std::string model,
            int year,
            double dailyRate)
        : vehicleId(std::move(vehicleId)),
          make(std::move(make)),
          model(std::move(model)),
          year(year),
          dailyRate(dailyRate),
          isAvailable(true)   
    {
        if (this->vehicleId.empty())
            throw std::invalid_argument("Vehicle ID cannot be empty");

        if (this->make.empty())
            throw std::invalid_argument("Make cannot be empty");

        if (this->model.empty())
            throw std::invalid_argument("Model cannot be empty");

    
        if (this->year < 1886 || this->year > 2026)
            throw std::invalid_argument("Invalid year");

        if (this->dailyRate <= 0.0)
            throw std::invalid_argument("Daily rate must be positive");
    }
const std::string& getId() const{
    return vehicleId;
}
  void getVehicleInfo() const {
        cout << "ID: " << vehicleId
            << "\nMake: " << make
            << "\nModel: " << model
            << "\nYear: " << year
            << "\nDaily Rate: " << dailyRate
            << "\nAvailable: " << (isAvailable ? "Yes" : "No");
       
    }

    void rent() {
        if (!isAvailable)
            throw std::logic_error("Vehicle already rented");
        isAvailable = false;
    }

    void returnVehicle() {
        if (isAvailable)
            throw std::logic_error("Vehicle is not rented");
        isAvailable = true;
    }

    double calculateRentalCost(int days) const {
        if (days <= 0)
            throw std::invalid_argument("Days must be positive");
        return days * dailyRate;
    }

    bool available() const  {
        return isAvailable;
    }
};
class Customer {
private:
    std::string customerId;
    std::string name;
    std::string phone;
    std::string email;
    std::string driversLicenseNumber;

    // اعرف بيتعاملو ازاي
    bool isValidEmail(const std::string& e) const {
        return e.find('@') != std::string::npos;
    }

    bool isDigitsOnly(const std::string& s) const {
        for (char c : s)
            if (!std::isdigit(static_cast<unsigned char>(c)))
                return false;
        return true;
    }

public:
    Customer(std::string customerId,
             std::string name,
             std::string phone,
             std::string email,
             std::string driversLicenseNumber)
        : customerId(std::move(customerId)),
          name(std::move(name)),
          phone(std::move(phone)),
          email(std::move(email)),
          driversLicenseNumber(std::move(driversLicenseNumber))
    {
        if (this->customerId.empty())
            throw std::invalid_argument("Customer ID cannot be empty");

        if (this->name.empty())
            throw std::invalid_argument("Name cannot be empty");

        if (!isValidEmail(this->email))
            throw std::invalid_argument("Invalid email");

        if (!isDigitsOnly(this->phone))
            throw std::invalid_argument("Phone must contain digits only");
    }
  const std::string& getname()const{
        return name;
    }
     const std::string& getId()const{
        return customerId;
    }
void getCustomerInfo() const {
        cout << "ID: " << customerId
            << "\nName: " << name
            << "\nphone: " << phone
            << "\nemail: " << email
            << "\ndriversLicenseNumber: " << driversLicenseNumber;
       
    }

};
class Rental{

    private :
    std::string rentalId;
    Customer& customer;
    Vehicle& vehicle;
    std::chrono::system_clock::time_point startDate;
    std::chrono::system_clock::time_point endDate;
    bool isActive;

    public:
    Rental(std::string Id ,
        Customer& cust,
        Vehicle& vehc,
        int days )
        :rentalId(std::move(Id)),
        customer (cust),
          vehicle(vehc),
          startDate(std::chrono::system_clock::now()),
         endDate(startDate + std::chrono::hours(24 * days)),
             isActive(true)

    {
        if(this->rentalId.empty()) 
         throw std::invalid_argument("rentalId cannot be empty");
        if(days<=0)
         throw std::invalid_argument("Days must be positive");
        if(!vehicle.available())
         throw std::logic_error("Vehicle is not available");
        vehicle.rent();
    }
    int  getRentalDuration() const{
      auto duration = endDate - startDate;
    return std::chrono::duration_cast<std::chrono::days>(duration).count();

    }
    double getTotalCost() const {
        int days=getRentalDuration();
     if (days <= 0)
        throw std::logic_error("Invalid rental duration");

        return vehicle.calculateRentalCost(days);

    }

   void completeRental(){  
      if (!isActive)
        throw std::logic_error("Rental already completed");

    isActive = false;

    vehicle.returnVehicle();   

    endDate = std::chrono::system_clock::now(); 

    }
    
void getRentalInfo() const {
        cout << "rentalId: " << rentalId
            << "\ncustomerName: " << customer.getname()
            << "\vehicle: " << vehicle.getId();
       
    }

};
class RentalAgency {
private:
    std::string agencyName;
    std::vector<Vehicle> vehicles;
    std::vector<Customer> customers;
    std::vector<Rental> rentals;
public:
explicit RentalAgency (std::string agencyName): 
 agencyName(std::move(agencyName))
{
if (this->agencyName.empty())
throw std::invalid_argument("Agency name cannot be empty");
}
void addVehicle(const Vehicle& v){
    for (const Vehicle&  e: vehicles){
        if (e.getId()==v.getId())
              throw std::logic_error("Vehicle already exists");
   
    }
     vehicles.push_back(v);
}
void registerCustomer (const Customer& c){
    for(const Customer& e: customers ){
        if (e.getId() ==c.getId())
             throw std::logic_error("Customer already exists");
    }
    customers.push_back(c);
}
   
};
int main() {
    std::cout << "Vehicle Rental System" << std::endl;
    
    return 0; 

}
 
