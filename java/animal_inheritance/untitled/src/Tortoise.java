public class Tortoise extends Reptile {
    Tortoise() {
        this.tail = true;
        this.legs = 4;
        this.arms = 0;
        this.wings = 0;
    }

    protected void move() {
        System.out.println("This animal walks");
    }

    protected void eat() {
        System.out.println("This animal is a herbivore");
    }

    protected void getInfo() {
        System.out.println("Tortoise:");
        super.getInfo();
    }
}