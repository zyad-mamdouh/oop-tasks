package level2.ZooManagementSystem;

public class Main {
    public static void main(String[] args) {

        // Create zoo
        Zoo zoo = new Zoo("Safari World");

        // Create animals
        Lion lion = new Lion("A001", "Simba", "African Lion", 5, "Healthy", 50.00, "Golden", "3");
        Elephant elephant = new Elephant("A002", "Dumbo", "African Elephant", 15, "Healthy", 80.00, 2.5, 5000);
        Parrot parrot = new Parrot("A003", "Polly", "Macaw", 8, "Healthy", 10.00, true);
        Snake snake = new Snake("A004", "Kaa", "Python", 10, "Healthy", 15.00, true, 4.5);
        Eagle eagle = new Eagle("A005", "Freedom", "Bald Eagle", 6, "Healthy", 20.00, 2.3, 320);

        // Add vocabulary to parrot
        parrot.getVocabulary().add("hello");
        parrot.getVocabulary().add("Goodbye");
        parrot.getVocabulary().add("Pretty bird");

        // Add animals to zoo
        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);
        zoo.addAnimal(parrot);
        zoo.addAnimal(snake);
        zoo.addAnimal(eagle);

        // Create zookeepers
        Zookeeper keeper1 = new Zookeeper("K001", "John Smith", "Mammals");
        Zookeeper keeper2 = new Zookeeper("K002", "Jane Doe", "Birds and Reptiles");

        zoo.getZookeepers().add(keeper1);
        zoo.getZookeepers().add(keeper2);

        // Assign animals
        zoo.assignAnimalToKeeper(lion, keeper1);
        zoo.assignAnimalToKeeper(elephant, keeper1);
        zoo.assignAnimalToKeeper(parrot, keeper2);
        zoo.assignAnimalToKeeper(snake, keeper2);
        zoo.assignAnimalToKeeper(eagle, keeper2);

        // Display animals
        zoo.displayAllAnimals();

        // Polymorphism
        System.out.println("\n=== Animal Sounds ===");
        for (Animal animal : zoo.getAnimals()) {
            System.out.println(animal.getName() + " says: " + animal.makeSound());
        }

        // Filter by habitat
        System.out.println("\n=== Savanna Animals ===");
        for (Animal animal : zoo.getAnimalsByHabitat("Savanna")) {
            System.out.println("- " + animal.getName() + " (" + animal.getSpecies() + ")");
        }

        // Cost
        double weeklyCost = zoo.calculateTotalWeeklyCost();
        System.out.println("\nTotal Weekly Cost: $" + weeklyCost);

        // Zookeeper actions
        System.out.println("\n=== Zookeeper Activities ===");
        keeper1.feedAnimal(lion);
        String health = keeper1.checkHealth(elephant);
        System.out.println("Health: " + health);
        System.out.println(keeper1.getName() + "'s workload: " + keeper1.getWorkload());


        zoo.getZooStatistics();
    }
}