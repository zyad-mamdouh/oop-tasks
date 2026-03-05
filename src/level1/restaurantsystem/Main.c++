#include <sstream>
#include <string>
#include <stdexcept>
#include <list>
#include <chrono>

class MenuItem{
private:
   std::string itemid;
   std::string name;
   std::string description;
   double price;
   std::string category;
   bool isAvailable;
    
public:
    MenuItem(std::string itemid,std::string name ,std::string description,double price ,
          std::string category )
       :itemid(std::move(itemid)),
        name(std::move(name)),
        description(std::move(description)),
         price(price),
        category(std::move(category)),
        isAvailable(true)
    {
        if(this->itemid.empty())
        throw std::invalid_argument("ID cannot be empty");
        
        if(this->name.empty())
        throw std::invalid_argument("name cannot be empty");
        
        if(this->description.empty())
        throw std::invalid_argument("description cannot be empty");
        
        if(this->category.empty())
        throw std::invalid_argument("category cannot be empty");

         if (this->price <= 0.0)
            throw std::invalid_argument("price must be positive");
        
           }



    std::string getItemInfo()const {
      
        std::ostringstream info;

   info << "ID: " << itemid << "\n"
     << "Name: " << name << "\n"
     << "Description: " << description << "\n"
     << "Category: " << category << "\n"
     << "Price: " << price << "\n"
     << "Available: " << (isAvailable ? "Yes" : "No") << "\n";

return info.str();
    }
};
class OrderItem{
    private:
    MenuItem menuItem;
    int quantity ;
    std::string specialInstructions;

    public:
    OrderItem(const MenuItem& menuItem ,int quantity ,std::string specialInstructions ) 
    : menuItem(menuItem),
      quantity(quantity),
      specialInstructions(std::move(specialInstructions))
    {

    }


};

class Order{
    private:
    std::string orderId;
    int tableNumber;
    std::list <OrderItem> orderItems;
    std::chrono::system_clock::time_point orderTime;
    std::string status; 

    public:
    Order( std::string orderId, int tableNumber )
    :orderId(std::move(orderId)),
    tableNumber(tableNumber),
    orderTime(std::chrono::system_clock::now()),
    status("Pending")
    {}



};

class Menu{
    private:
    std::string restaurantName;
    std::list<MenuItem> menuItems;

    public:
    Menu(std::string restaurantName )
    :restaurantName(std::move(restaurantName))
    {

    }



};

class Restaurant{
    private:
     std::string restaurantName;
     Menu menu;
     std::list<Order> orders;
     double taxRate;

    public:
     Restaurant(const std::string& restaurantName,double taxRate)
     :restaurantName (restaurantName),
      menu(this->restaurantName),
     taxRate(taxRate)

     {}
     


};


int main(){

    return 0;
}