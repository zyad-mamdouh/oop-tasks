package level2.ZooManagementSystem;

import java.util.ArrayList;

public class Zoo {

    private String zooName;
    private ArrayList<Animal> animals;
    private ArrayList<Zookeeper> zookeepers;

    public Zoo(String zooName) {
        this.zooName = zooName;
        this.animals = new ArrayList<>();
        this.zookeepers = new ArrayList<>();
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
    }


    public void removeAnimal(String animalId) {
        animals.removeIf(animal -> animal.getAnimalId().equals(animalId));
    }


    public void assignAnimalToKeeper(Animal animal, Zookeeper keeper) {
      keeper.AssignedAnimals(animal);
    }


    public ArrayList<Animal> getAnimalsByHabitat(String habitat) {
        ArrayList<Animal> result = new ArrayList<>();
        for (Animal a : animals) {
            if (a.getHabitat().equalsIgnoreCase(habitat)) {
                result.add(a);
            }
        }
        return result;
    }


    public ArrayList<Animal> getAnimalsBySpecies(String species) {
        ArrayList<Animal> result = new ArrayList<>();
        for (Animal a : animals) {
            if (a.getSpecies().equalsIgnoreCase(species)) {
                result.add(a);
            }
        }
        return result;
    }

    // Total cost
    public double calculateTotalWeeklyCost() {
        double total = 0;
        for (Animal a : animals) {
            total += a.calculateWeeklyCost();
        }
        return total;
    }

    // Display animals
    public void displayAllAnimals() {
        System.out.println("\n=== " + zooName + " - All Animals ===");
        for (Animal a : animals) {
            System.out.println(
                    a.getAnimalId() + " - " +
                            a.getName() + " (" + a.getSpecies() + ") - Age: " +
                            a.getAge() + " - Habitat: " +
                            a.getHabitat()
            );
        }
    }

    // Statistics
    public void getZooStatistics() {
        System.out.println("\n=== " + zooName + " Statistics ===");

        int totalAnimals = animals.size();
        int totalKeepers = zookeepers.size();

        double totalCost = calculateTotalWeeklyCost();

        double avgAge = 0;
        for (Animal a : animals) {
            avgAge += a.getAge();
        }
        if (totalAnimals > 0) {
            avgAge /= totalAnimals;
        }

        System.out.println("Total Animals: " + totalAnimals);
        System.out.println("Total Zookeepers: " + totalKeepers);
        System.out.println("Total Weekly Maintenance: $" + totalCost);
        System.out.println("Average Animal Age: " + avgAge);
    }

    // Getters
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Zookeeper> getZookeepers() {
        return zookeepers;
    }
}