public class Sheep implements Animal {
    private int legs;
    private String sound;
    private String food;
    private String name;

    public Sheep() {
        this.legs = 4;
        this.sound = "Baaa!";
        this.food = "Grass";
        this.name = "Fluffy";
    }

    public Sheep(Sheep sheep) {
        this.legs = sheep.legs;
        this.sound = sheep.sound;
        this.food = sheep.food;
        this.name = sheep.name; 
    }

    @Override
    public Animal clone() {
        return new Sheep(this);
    }

    @Override
    public void makeSound() {
        System.out.println("Baaa!");
    }

    @Override
    public String getType() {
        return "Sheep";
    }

    public int getLegs() {
        return legs;
    }

    public String getSound() {
        return sound;
    }

    public String getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", sound='" + sound + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}