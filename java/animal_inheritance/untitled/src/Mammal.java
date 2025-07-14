public abstract class Mammal extends Animal {
    Mammal() {
        this.coldBlooded = false;
        this.skinType = "fur";
    }

    protected void birth() {
        System.out.println("This animal gives birth to live young");
    }

    protected void hibernate() {
        System.out.println("This animal hibernates");
    }
}
