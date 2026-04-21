package level2.ZooManagementSystem;

import java.util.ArrayList;

public class Parrot extends Animal{
    final private boolean canTalk;
    private ArrayList<String> vocabulary ;

    Parrot(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost,boolean canTalk  ){
        super(animalId, name, species, age, healthStatus, dailyFoodCost);
        this.canTalk=canTalk;
        this.vocabulary=new ArrayList<>();
    }

    public ArrayList<String> getVocabulary() {
        return vocabulary;
    }

    public void Vocabulary(){
        for(String s:vocabulary){
       System.out.print(s + " ");
        }
        System.out.println();
    }
    public String speak(){
        int randomIndex = (int)(Math.random() * vocabulary.size());
        String randomElement = vocabulary.get(randomIndex);
        return randomElement;
    }

    @Override
    String makeSound(){

        return "Squawk";
    }
    @Override
    String getHabitat(){
        return  "Rainforest";

    }
    @Override
    String getAnimalInfo(){
        return  "Animal Id: "+  animalId +"\n"
                +"Name: "+ name +"\n"
                +"Species: " + species +"\n"
                +"Age: "+age  +"\n"
                +"healthStatus: " + healthStatus +"\n"
                +"dailyFoodCost: "+dailyFoodCost +"\n"
                +"canTalk: " + canTalk + "\n" ;
    }
    @Override
    double  calculateWeeklyCost(){
        return dailyFoodCost * 7.0;
    }

    public void setVocabulary(ArrayList<String> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public boolean isCanTalk() {
        return canTalk;
    }
}
