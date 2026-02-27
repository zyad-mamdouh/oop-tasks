#include <iostream>
#include <string>
#include <vector>
using namespace std;
#include <chrono>
#include <algorithm>


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

  std::string getVehicleInfo() const {
    std::string info;

    info += "ID: " + vehicleId;
    info += "\nMake: " + make;
    info += "\nModel: " + model;
    info += "\nYear: " + std::to_string(year);
    info += "\nDaily Rate: " + std::to_string(dailyRate);
    info += "\nAvailable: ";
    info += (isAvailable ? "Yes" : "No");

    return info;
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
  const std::string& getName()const{
        return name;
    }
     const std::string& getId()const{
        return customerId;
    }

std::string getCustomerInfo() const {
    std::string info;

    info += "ID: " + customerId;
    info += "\nName: " + name;
    info += "\nPhone: " + phone;
    info += "\nEmail: " + email;
    info += "\nDriver's License: " + driversLicenseNumber;

    return info;
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
    bool getIsActive()const{
        return isActive;
    }
    const std::string& getRentalId()const{
        return rentalId;
    }
    const  Customer& getCustomer() const {
    return customer;
}
const Vehicle& getVehicle() const {
    return vehicle;
}
    
std::string getRentalInfo() const{
     std::string info;
       
    info += "Rental ID: " + rentalId;
    info += "\nCustomer: " + customer.getName();
    info += "\nVehicle: " + vehicle.getId();

    return info;
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
std::vector<Rental> getActiveRentals() const{
  std::vector<Rental> result;
    for(const Rental& r:rentals){
        if(r.getIsActive())
            result.push_back(r);
    }
      return result ;
}
std:: vector<Vehicle> getAvailableVehicles() const{
    std:: vector<Vehicle>  result;
    for (const Vehicle& v:vehicles ){
        if(v.available())
            result.push_back(v);
    }
     return result;
}
void displayFleet()const {
    for(const Vehicle& v:vehicles){
      std::cout<< v.getVehicleInfo() << endl;
    }
}
std::vector<Rental> getCustomerRentals(string customerId) const{
  vector <Rental> result;
  for (const Rental& r : rentals){
        if(customerId == r.getCustomer().getId()){
            result.push_back(r);
        }
    }
    return result;
}
Rental& createRental(const string& customerId,const string& vehicleId,int days){
    auto customerIt = std::find_if(customers.begin(), customers.end(),
    [customerId](const Customer& c) {
        return c.getId() == customerId;
    });

if (customerIt == customers.end()) 
    throw std::logic_error("customer not found");

auto vehicleIt = std::find_if(vehicles.begin(), vehicles.end(),
    [vehicleId](const Vehicle& v) {
        return v.getId() == vehicleId;
    });

if (vehicleIt == vehicles.end()) 
    throw std::logic_error("vehicle not found");

    if (days<=0)
      throw std::logic_error("Days Must be more than 0");

   std::string rentalId = "R" + std::to_string(rentals.size() + 1);
rentals.emplace_back(rentalId, *customerIt, *vehicleIt, days);
return rentals.back();
}                   

double  completeRental(const string& rentalId){
 auto it = std::find_if(rentals.begin(), rentals.end(),
        [rentalId](const Rental& r) {
            return r.getRentalId() == rentalId;
        });

    if (it == rentals.end())
        throw std::logic_error("Rental not found");

    if (!it->getIsActive())
        throw std::logic_error("Rental already completed");

    double totalCost = it->getTotalCost();

    it->completeRental();

    return totalCost;
}
   
};
int main() {

    try {

        // Create rental agency
        RentalAgency agency("Prime Car Rentals");

        // Add vehicles
        Vehicle car1("V001", "Toyota", "Camry", 2022, 45.00);
        Vehicle car2("V002", "Honda", "Accord", 2023, 50.00);
        Vehicle car3("V003", "Tesla", "Model 3", 2023, 85.00);

        agency.addVehicle(car1);
        agency.addVehicle(car2);
        agency.addVehicle(car3);

        // Register customers
        Customer customer1("C001", "Alice Johnson", "5550123",
                           "alice@email.com", "DL123456");

        Customer customer2("C002", "Bob Smith", "5550456",
                           "bob@email.com", "DL789012");

        agency.registerCustomer(customer1);
        agency.registerCustomer(customer2);

        // Display fleet
        std::cout << "=== Prime Car Rentals - Fleet Status ===\n";
        agency.displayFleet();

        // Create rentals
        Rental& rental1 = agency.createRental("C001", "V001", 5);

        std::cout << "\nRental created: " 
                  << rental1.getRentalId() << std::endl;

        std::cout << "Total Cost: $" 
                  << rental1.getTotalCost() << std::endl;


        Rental& rental2 = agency.createRental("C002", "V003", 3);

        std::cout << "\nRental created: " 
                  << rental2.getRentalId() << std::endl;

        std::cout << "Total Cost: $" 
                  << rental2.getTotalCost() << std::endl;


        // Display fleet after rentals
        std::cout << "\nAfter rentals:\n";
        agency.displayFleet();


        // Complete first rental
        double finalCost = agency.completeRental(rental1.getRentalId());

        std::cout << "\nRental " 
                  << rental1.getRentalId() 
                  << " completed!\n";

        std::cout << "Final Cost: $" 
                  << finalCost << std::endl;


        // Customer rental history
        std::vector<Rental> customerRentals =
            agency.getCustomerRentals("C001");

        std::cout << "\nAlice's rental history: "
                  << customerRentals.size()
                  << " rental(s)\n";

    }
    catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    return 0; 
}
 
