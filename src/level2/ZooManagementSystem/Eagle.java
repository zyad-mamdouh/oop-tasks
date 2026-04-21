package level2.ZooManagementSystem;

import java.util.ArrayList;

public class Eagle extends Animal{
    final private double wingspan;
    final private double diveSpeed ;

    Eagle(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,double wingspan,double diveSpeed  ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.wingspan=wingspan;
        this.diveSpeed=diveSpeed;
    }


    @Override
    String makeSound(){

        return "Ooh ooh ah ah!!";
    }

    @Override
    String getHabitat(){
        return "Rainforest";

    }
    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"wingspan: " + wingspan + "\n"
                +"diveSpeed: "+diveSpeed +"\n";
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }
}
