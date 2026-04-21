package level2.ZooManagementSystem;

public class Lion extends Animal{
    final private String mainColor;
    final private  String prideSize;

    Lion(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,String mainColor ,String prideSize ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.mainColor=mainColor;
        this.prideSize=prideSize;
    }
    @Override
    String makeSound(){

        return "Roar!";
    }
    @Override
    String getHabitat(){
   return "Savanna";

    }
    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"Color: " + mainColor + "\n"
                +"prideSize: "+prideSize+"\n" ;
    }
    @Override
  double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }

}
