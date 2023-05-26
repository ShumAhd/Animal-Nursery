package ru.shum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetRegistry implements AutoCloseable {

  private List<Animal> animals = new ArrayList<>();

  private static Counter counter = new Counter();

  public void addNewAnimal(Animal animal) {
    animals.add(animal);
    counter.add();
  }

  public void teachCommand(Animal animal, String command) {
    animal.setCommand(command);
  }

  public List<String> getCommands(Animal animal) {
    List<String> commands = new ArrayList<>();
    commands.add(animal.getCommand());
    return commands;
  }


  public static void main(String[] args) throws Exception {
    try (PetRegistry petRegistry = new PetRegistry()) {
      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.println("1. Add new animal");
        System.out.println("2. Teach command");
        System.out.println("3. Get commands");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1:
            System.out.println("Enter animal type: ");
            String type = scanner.nextLine();
            System.out.println("Enter animal name: ");
            String name = scanner.nextLine();
            Animal animal;
            switch (type) {
              case "Dog":
                animal = new Dog(name);
                break;
              case "Cat":
                animal = new Cat(name);
                break;
              case "Hamster":
                animal = new Hamster(name);
                break;
              case "Horse":
                animal = new Horse(name);
                break;
              case "Camel":
                animal = new Camel(name);
                break;
              case "Donkey":
                animal = new Donkey(name);
                break;
              default:
                throw new IllegalStateException("Unexpected value: " + type);
            }
            petRegistry.addNewAnimal(animal);
            break;
          case 2:
            System.out.println("Enter animal name: ");
            String animalName = scanner.nextLine();
            Animal foundAnimal = petRegistry.animals.stream()
                .filter(a -> a.getName().equals(animalName)).findFirst().orElse(null);
            if (foundAnimal == null) {
              System.out.println("No such animal");
              break;
            }
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            petRegistry.teachCommand(foundAnimal, command);
            break;
          case 3:
            System.out.println("Enter animal name: ");
            String aName = scanner.nextLine();
            Animal fAnimal = petRegistry.animals.stream().filter(a -> a.getName().equals(aName))
                .findFirst().orElse(null);
            if (fAnimal == null) {
              System.out.println("No such animal");
              break;
            }
            List<String> commands = petRegistry.getCommands(fAnimal);
            for (String cmd : commands) {
              System.out.println(cmd);
            }
            break;
          case 4:
            return;
        }
      }
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public void close() throws Exception {
    if (counter.getCount() == 0) {
      throw new Exception("Counter was not used in try-with-resources block");
    } else {
      counter.resetCount();
    }
  }

}

class Counter {

  private int count;

  public void add() {
    count++;
  }

  public int getCount() {
    return count;
  }

  public void resetCount() {
    count = 0;
  }

}