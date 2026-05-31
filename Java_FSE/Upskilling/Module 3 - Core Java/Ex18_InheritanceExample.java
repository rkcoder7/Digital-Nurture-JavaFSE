class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class Ex18_InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();   // Generic sound

        Dog dog = new Dog();
        dog.makeSound();      // Overridden: Bark

        // Polymorphism: Animal reference pointing to Dog object
        Animal polyDog = new Dog();
        polyDog.makeSound();  // Bark (runtime polymorphism)
    }
}