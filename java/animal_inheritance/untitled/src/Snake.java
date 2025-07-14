public class Snake extends Reptile {
    Snake() {
        this.tail = true;
        this.legs = 0;
        this.arms = 0;
        this.wings = 0;
    }

    protected void move() {
        System.out.println("This animal slithers");
    }

    protected void eat() {
        System.out.println("This animal is a carnivore");
    }

    protected void getInfo() {
        System.out.println("Snake:");
        super.getInfo();
    }
}