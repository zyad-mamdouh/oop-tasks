package level2.ZooManagementSystem;

public class Snake extends Animal{
    final private boolean isVenomous;
    final private double length ;

    Snake(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,boolean isVenomous,double length  ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.isVenomous=isVenomous;
        this.length=length;
    }


    @Override
    String getHabitat() {
        return "Desert";
    }

    @Override
    String makeSound(){
        return "Hiss !";
    }



    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"isVenomous: " + isVenomous + "\n"
                +"length: "+length +"\n";
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }
}
