public abstract class Animal {
    protected boolean coldBlooded;
    protected String skinType;
    protected boolean tail;
    protected int legs;
    protected int arms;
    protected int wings;

    protected abstract void eat();
    protected abstract void move();
    protected abstract void birth();
    protected abstract void hibernate();

    protected void getInfo() {
        if (this.coldBlooded)
            System.out.println("This animal is cold-blooded");
        else
            System.out.println("This animal is warm-blooded");
        if (this.skinType != null)
            System.out.println("This animal is covered in " + this.skinType);
        if (this.tail)
            System.out.println("This animal has a tail");
        if (this.legs > 0)
            System.out.println("This animal has " + this.legs + " legs");
        if (this.arms > 0)
            System.out.println("This animal has " + this.arms + " arms");
        if (this.wings > 0)
            System.out.println("This animal has " + this.wings + " wings");
        this.move();
        this.eat();
        this.birth();
        this.hibernate();
        System.out.println();
    }
}
