package level2.ZooManagementSystem;

public class Elephant  extends Animal{
    final private double tuskLength;
    final private  double weight;

    Elephant(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,double tuskLength ,double weight ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.tuskLength=tuskLength;
        this.weight=weight;
    }

    @Override
    String makeSound(){

        return "Trumpet!";
    }
    @Override
    String getHabitat(){
        return "Grassland";

    }
    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"tuskLength: " + tuskLength + "\n"
                +"weight: "+weight+"\n" ;
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }

}
