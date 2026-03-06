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



   const std::string&  getId()const{
    return itemid;
   }
   
   const std::string&  getName()const{
    return name;
   }
   const std::string&  getDescription() const{
    return description;
   }
   
    const std::string&  getCategory() const{
    return category;
   }
    double getPrice()const{
    return price;
   }
     bool Available()const{
        return isAvailable;
    }
    void setAvailability (bool  Available){
        this->isAvailable=Available;
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
        if (quantity <= 0)
      throw std::invalid_argument("quantity must be positive");

    }
    int getQuantity() const {
    return quantity;
}
const MenuItem& getMenuItem() const {
    return menuItem;
}

const std::string& getSpecialInstructions() const {
    return specialInstructions;
}
double getSubtotal() const {
    return quantity*menuItem.getPrice();
}
 std::string getOrderItemDetails()const{
    std::ostringstream info;

    info << "Name: " << menuItem.getName() << '\n'
     << "Quantity: " << quantity << '\n'
     << "Special Instructions: " << specialInstructions << '\n'
     << "Subtotal: " << getSubtotal() << '\n';

return info.str();
}
};
enum class OrderStatus
{
    Pending,
    Preparing,
    Ready,
    Served,
    Completed
};
class Order{
    private:
    std::string orderId;
    int tableNumber;
    std::vector <OrderItem> orderItems;
    std::chrono::system_clock::time_point orderTime;
     OrderStatus status; 

    public:
    Order( std::string orderId, int tableNumber )
    :orderId(std::move(orderId)),
    tableNumber(tableNumber),
    orderTime(std::chrono::system_clock::now()),
   status(OrderStatus::Pending)
    {
        if (this->orderId.empty())
        throw std::invalid_argument("orderId can't be empty");
        if(tableNumber <=0)
        throw std::invalid_argument("tableNumber must be positive");
        
    }
    // - `addItem(menuItem, quantity, instructions)`: Adds item to order

    void addItem( const MenuItem&  menuItem , int quantity ,const  std::string&  instructions) {
       orderItems.emplace_back(menuItem, quantity, instructions);
    }
    void remove(const std::string& id){
         for (auto it = orderItems.begin(); it != orderItems.end(); ++it){
            if(id==it->getMenuItem().getId()){
             orderItems.erase(it);
             return;
            }
          
        }
            throw std::logic_error("Item dosent exist in order");
        
    }

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