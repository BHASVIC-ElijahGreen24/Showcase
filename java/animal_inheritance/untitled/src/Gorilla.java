public class Gorilla extends Mammal {
    Gorilla() {
        this.tail = false;
        this.legs = 2;
        this.arms = 2;
        this.wings = 0;
    }
    
    protected void move() {
        System.out.println("This animal walks and climbs");
    }
    
    protected void eat() {
        System.out.println("This animal is a herbivore");
    }
    
    protected void getInfo() {
        System.out.println("Gorilla:");
        super.getInfo();
    }
}