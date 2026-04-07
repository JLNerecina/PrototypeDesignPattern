public class Cow implements Animal {
    private int legs;
    private String sound;
    private String food;
    private String name;

    public Cow() {
        this.legs = 4;
        this.sound = "Moooo!";
        this.food = "Grass";
    }

    public Cow(Cow cow) {
        this.legs = cow.legs;
        this.sound = cow.sound;
        this.food = cow.food;
        this.name = cow.name; 
    }

    @Override
    public Animal clone() {
        return new Cow(this);
    }

    @Override
    public void makeSound() {
        System.out.println("Moooo!");
    }

    @Override
    public String getType() {
        return "Cow";
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

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", sound='" + sound + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}