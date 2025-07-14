public abstract class Reptile extends Animal {
    Reptile() {
        this.coldBlooded = true;
        this.skinType = "scales";
    }

    protected void birth() {
        System.out.println("This animal lays eggs");
    }

    protected void hibernate() {
        System.out.println("This animal hibernates");
    }
}
