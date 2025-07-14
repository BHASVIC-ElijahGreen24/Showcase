public class Bat extends Mammal {
	Bat() {
        this.tail = true;
        this.legs = 2;
        this.arms = 0;
        this.wings = 2;
	}

    protected void move() {
        System.out.println("This animal flies");
    }

    protected void eat() {
        System.out.println("This animal is an omnivore");
    }

    protected void getInfo() {
        System.out.println("Bat:");
        super.getInfo();
    }
}