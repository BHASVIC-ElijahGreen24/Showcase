public class Tile {
    private Animal animal;
    private String display;

    public Tile(String d, Animal a) {
        this.display = d;
        this.animal = a;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public String getDisplay() {
        return this.display;
    }
}
