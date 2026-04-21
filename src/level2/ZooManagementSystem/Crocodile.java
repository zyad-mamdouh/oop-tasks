package level2.ZooManagementSystem;

public class Crocodile extends Animal{
    final private double jawStrength;
    final private double weight ;

    Crocodile(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,double jawStrength,double weight  ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.jawStrength=jawStrength;
        this.weight=weight;
    }


    @Override
    String makeSound(){

        return "Growl!";
    }

    @Override
    String getHabitat(){
       return "Swamp";

    }
    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"jawStrength: " + jawStrength + "\n"
                +"weight: "+weight +"\n";
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }
}
