public class Turtle extends Reptile {
    Turtle() {
        this.tail = true;
        this.legs = 4;
        this.arms = 0;
        this.wings = 0;
    }

    protected void move() {
        System.out.println("This animal crawls and swims");
    }

    protected void eat() {
        System.out.println("This animal is an omnivore");
    }

    protected void getInfo() {
        System.out.println("Turtle:");
        super.getInfo();
    }
}