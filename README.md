# 🐑 Prototype Design Pattern - Animal Farm Edition

<div align="center">

[![Design Pattern](https://img.shields.io/badge/Design%20Pattern-Prototype-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Prototype_pattern)
[![Language](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)](https://github.com/JLNerecina/PrototypeDesignPattern)

*Creating perfect copies of animals without knowing their specific types – it's cloning made simple!* 🧬

</div>

---

## 📖 Overview

Welcome to the **Prototype Design Pattern** implementation! This project demonstrates how to efficiently create object copies using the Prototype design pattern. Instead of creating objects from scratch, we clone existing prototypes, making the process faster and more flexible.

Imagine an animal farm where you need multiple cows, sheep, and horses. Rather than instantiating each animal individually, we maintain prototypes in a registry and simply clone them when needed. It's elegant, efficient, and delightfully creative! 🌾

---

## 🎯 What is the Prototype Pattern?

The **Prototype Pattern** is a creational design pattern that solves the problem of creating objects without specifying their exact classes. Instead of using constructors, we create new objects by copying an existing object prototype.

### Key Benefits:
- ✅ **Reduced Complexity**: Simplifies object creation
- ✅ **Performance**: Faster than creating objects from scratch
- ✅ **Flexibility**: Easily create variations by modifying clones
- ✅ **Runtime Configuration**: Determine object types at runtime
- ✅ **Decoupling**: Clients don't need to know concrete classes

---

## 🏗️ Architecture & UML Diagram

### Class Diagram:

![Prototype Design Pattern UML](Prototype%20Design%20Pattern%20UML.png)

### Architecture Overview:

```
┌─────────────────────────────────────────────────────┐
│                  Prototype Pattern                  │
├─────────────────────────────────────────────────────┤
│                                                     │
│  ┌──────────────────────────────────────────────┐   │
│  │ <<interface>> Animal (Cloneable)             │   │
│  ├──────────────────────────────────────────────┤   │
│  │ + clone(): Animal                            │   │
│  │ + makeSound(): void                          │   │
│  │ + getType(): String                          │   │
│  └──────────────────────────────────────────────┘   │
│           △        △         △                    │
│           │         │         │                     │
│    ┌──────┴─┐  ┌────┴──┐  ┌───┴─────┐               │
│    │ Sheep  │  │  Cow  │  │ Horse   │               │
│    │ (clone)│  │(clone)│  │ (clone) │               │
│    └────────┘  └───────┘  └─────────┘               │
│                                                     │
│  ┌──────────────────────────────────────────────┐   │
│  │ AnimalRegistry (Prototype Manager)           │   │
│  ├──────────────────────────────────────────────┤   │
│  │ - sheepPrototype: Sheep                      │   │
│  │ - cowPrototype: Cow                          │   │
│  │ - horsePrototype: Horse                      │   │
│  ├──────────────────────────────────────────────┤   │
│  │ + createSheep(): Animal                      │   │
│  │ + createCow(): Animal                        │   │
│  │ + createHorse(): Animal                      │   │
│  └──────────────────────────────────────────────┘   │
│                                                     │
└─────────────────────────────────────────────────────┘
```

---

## 📁 Project Structure

```
PrototypeDesignPattern/
├── Animal.java              # Interface defining animal contracts
├── Sheep.java               # Concrete prototype: Sheep
├── Cow.java                 # Concrete prototype: Cow
├── Horse.java               # Concrete prototype: Horse
├── AnimalRegistry.java       # Registry managing prototypes
├── TestAnimal.java          # Demonstration & testing
├── Prototype Design Pattern UML.png  # UML diagram
└── README.md                # This file
```

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Compilation

```bash
javac *.java
```

### Running the Demo

```bash
java TestAnimal
```

### Expected Output:
```
ORIGINAL PROTOTYPES
The original Sheep is named Dolly
The original Cow says Moo!
The original Horse is Black

CLONED ANIMALS
The cloned Sheep is named Molly
The cloned Cow sounds Maa!
The cloned Cow eats Grass
The cloned Horse is Brown
```

---

## 💻 Code Examples

### Creating the Animal Interface

```java
public interface Animal extends Cloneable {    
    public Animal clone();
    public void makeSound();
    public String getType();
}
```

### Implementing Sheep Prototype

```java
public class Sheep implements Animal {
    private String name;
    private String sound;
    
    public Sheep() {
        this.name = "Fluffy";
        this.sound = "Baaa!";
    }
    
    // Copy constructor for cloning
    public Sheep(Sheep sheep) {
        this.name = sheep.name;
        this.sound = sheep.sound;
    }
    
    @Override
    public Animal clone() {
        return new Sheep(this);  // Create a copy
    }
}
```

### Using the Registry

```java
AnimalRegistry registry = new AnimalRegistry();

// Create sheep prototype
Animal sheep = registry.createSheep();
((Sheep) sheep).setName("Dolly");

// Clone the sheep
Animal sheep2 = registry.createSheep();
((Sheep) sheep2).setName("Molly");
```

---

## 🔑 Key Concepts

### 1. **The Prototype Interface**
- Declares the `clone()` method that all concrete prototypes must implement
- Extends `Cloneable` for deep copying

### 2. **Concrete Prototypes**
- `Sheep`, `Cow`, and `Horse` implement the Animal interface
- Each has a copy constructor for efficient cloning
- Copy constructor creates independent copies of all attributes

### 3. **The Registry**
- Maintains instances of each prototype
- Provides factory methods (`createSheep()`, `createCow()`, `createHorse()`)
- Returns clones instead of original prototypes
- Shields clients from concrete class knowledge

### 4. **Deep Copy vs Shallow Copy**
Our implementation uses **copy constructors** for true deep copies:
```java
public Sheep(Sheep sheep) {
    this.legs = sheep.legs;      // Primitive copy
    this.name = sheep.name;      // Reference copy (String is immutable)
    this.sound = sheep.sound;
    this.food = sheep.food;
}
```

---

## 🎨 Design Patterns Demonstrated

| Pattern | Role | Implementation |
|---------|------|-----------------|
| **Prototype** | Primary Pattern | Clone animals using prototypes |
| **Registry** | Supportive | Manages prototype storage |
| **Factory** | Supportive | `createX()` methods return clones |
| **Cloneable** | Mechanism | Java standard for object copying |

---

## 📊 When to Use Prototype Pattern

✅ **Use it when:**
- Creating objects is expensive (time, memory, computation)
- You need to create objects with slight variations
- Object creation logic is complex
- Runtime type determination is needed

❌ **Avoid it when:**
- Object creation is simple and cheap
- You have only a few fixed object types
- Deep copying overhead isn't justified

---

## 🏆 Real-World Applications

- **Game Development**: Cloning game entities (players, enemies, items)
- **UI Frameworks**: Creating widget instances from templates
- **CAD Software**: Duplicating design elements
- **Database Systems**: Caching and reusing object templates
- **Configuration Management**: Cloning system configurations with variations

---

## 📚 Learning Resources

- [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns) - Gang of Four
- [Java Object Cloning](https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html)
- [Prototype Pattern Explanation](https://refactoring.guru/design-patterns/prototype)

---

## 🔧 How to Extend

Want to add more animals? Follow these three simple steps:

### Step 1: Create a new class
```java
public class Pig implements Animal {
    private String name;
    
    public Pig() {
        this.name = "Peppa";
    }
    
    public Pig(Pig pig) {
        this.name = pig.name;
    }
    
    @Override
    public Animal clone() {
        return new Pig(this);
    }
    
    @Override
    public String getType() {
        return "Pig";
    }
}
```

### Step 2: Update the Registry
```java
public class AnimalRegistry {
    private Pig pigPrototype;
    
    public AnimalRegistry() {
        pigPrototype = new Pig();
    }
    
    public Animal createPig() {
        return pigPrototype.clone();
    }
}
```

### Step 3: Use in TestAnimal
```java
Animal pig = registry.createPig();
((Pig) pig).setName("George");
```

---

## 🎓 Educational Value

This implementation demonstrates:
- Object cloning with copy constructors
- Interface-based design
- Factory pattern concepts
- Separation of concerns
- SOLID principles in action

Perfect for learning or teaching design patterns in Java! 

---

## 📝 License

This project is open source and available for educational purposes.

---

## 👨‍💻 Author

**JLNerecina** - Prototype Pattern Implementation  
*Making animal farming code beautiful, one clone at a time* 🎯

---

<div align="center">

**⭐ If you found this project helpful, please consider starring it!**

[Back to Top](#-prototype-design-pattern---animal-farm-edition)

</div>
