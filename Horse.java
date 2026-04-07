public class Horse implements Animal {
    private int legs;
    private String sound;
    private String food;
    private String color;
    private String name;

    public Horse() {
        this.legs = 4;
        this.sound = "Neigh!";
        this.food = "Grass";
        this.color = "Black";
        this.name = "Horsy";
    }

    public Horse(Horse horse) {
        this.legs = horse.legs;
        this.sound = horse.sound;
        this.food = horse.food;
        this.color = horse.color;
        this.name = horse.name; 
    }

    @Override
    public Animal clone() {
        return new Horse(this);
    }

    @Override
    public void makeSound() {
        System.out.println("Neigh!");
    }

    @Override
    public String getType() {
        return "Horse";
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

    public String getColor() {
        return color;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", sound='" + sound + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}