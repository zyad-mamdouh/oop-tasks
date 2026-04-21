package level2.ZooManagementSystem;

public class Monkey extends Animal{
    final private double tailLength;
    final private  String favoriteFood;

    Monkey(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,double tailLength ,String favoriteFood ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.tailLength=tailLength;
        this.favoriteFood=favoriteFood;
    }
    @Override
    String makeSound(){

        return "Ooh ooh ah ah";
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
                +"tailLength: " + tailLength + "\n"
                +"favoriteFood: "+favoriteFood+"\n" ;
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }
}
