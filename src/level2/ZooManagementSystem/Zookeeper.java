package level2.ZooManagementSystem;

import java.util.ArrayList;

public class Zookeeper {
    private  String employeeId;
    private String name;
    private  String specialization;
   private ArrayList<Animal> assignedAnimals;

    Zookeeper(String employeeId , String name , String specialization ){
       this.employeeId=employeeId;
       this.name=name;
       this.specialization=specialization;
       this.assignedAnimals=new ArrayList<>();
    }
    void  feedAnimal(Animal animal){
        animal.eat();
    }
    String  checkHealth(Animal animal){
        return  animal.getHealthStatus();
    }
    int getWorkload(){
        return assignedAnimals.size();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public ArrayList<Animal> getAssignedAnimals() {
        return assignedAnimals;
    }

    public void AssignedAnimals(Animal animal) {
        assignedAnimals.add(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
