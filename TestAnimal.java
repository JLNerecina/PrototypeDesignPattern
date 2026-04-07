public class TestAnimal {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Animal sheep = registry.createSheep();
        Animal cow = registry.createCow();
        Animal horse = registry.createHorse();
        
        System.out.println("ORIGINAL PROTOTYPES");
        ((Sheep) sheep).setName("Dolly");
        ((Cow) cow).setSound("Moo!");
        ((Horse) horse).setColor("Black");

        System.out.println("The original " + sheep.getType() + " is named " + ((Sheep) sheep).getName());
        System.out.println("The original " + cow.getType() + " says " + ((Cow) cow).getSound());
        System.out.println("The original " +horse.getType() + " is " + ((Horse) horse).getColor());

        System.out.println();

        Animal sheep2 = registry.createSheep();
        ((Sheep) sheep2).setName("Molly");

        System.out.println("CLONED ANIMALS");

        System.out.println("The cloned " + sheep2.getType() + " is named " + ((Sheep) sheep2).getName());

        Animal cow2 = registry.createCow();
        ((Cow) cow2).setFood("Grass");
        ((Cow) cow2).setSound("Maa!");
        System.out.println("The cloned " + cow2.getType() + " sounds " + ((Cow) cow2).getSound());
        System.out.println("The cloned " + cow2.getType() + " eats " + ((Cow) cow2).getFood());
        
        Animal horse2 = registry.createHorse();
        ((Horse) horse2).setColor("Brown");
        System.out.println("The cloned " + horse2.getType() + " is " + ((Horse) horse2).getColor());
    }
}