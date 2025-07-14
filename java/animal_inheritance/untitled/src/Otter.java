public class Otter extends Mammal {
    Otter() {
        this.tail = true;
        this.legs = 4;
        this.arms = 0;
        this.wings = 0;
    }

    protected void move() {
        System.out.println("This animal walks and swims");
    }

    protected void eat() {
        System.out.println("This animal is an omnivore");
    }

    protected void getInfo() {
        System.out.println("Otter:");
        super.getInfo();
    }
}