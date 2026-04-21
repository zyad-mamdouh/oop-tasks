package level2.ZooManagementSystem;

public abstract class Animal {
    protected  String animalId;
    protected String name;
    protected  String species;
    protected int age;
    protected  String healthStatus;
    protected double  dailyFoodCost;

    Animal(String animalId, String name, String species, int age, String healthStatus, double dailyFoodCost) {
        this.animalId = animalId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.dailyFoodCost = dailyFoodCost;
    }

    abstract  String makeSound() ;
    abstract  String getHabitat();
    abstract  String getAnimalInfo();
    abstract  double calculateWeeklyCost();

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public double getDailyFoodCost() {
        return dailyFoodCost;
    }

    public void setDailyFoodCost(double dailyFoodCost) {
        this.dailyFoodCost = dailyFoodCost;
    }
    void eat() {
        this.healthStatus = "Good";
    }



}
