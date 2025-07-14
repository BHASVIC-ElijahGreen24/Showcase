public class Manager {
	private String name;
	
    Manager(String name) {
        this.name = name;
    }

    public void take_feedback(Customer customer) {
        if (customer.get_feedback() > 0)
            System.out.println(this.name + " says: " + customer.get_name() + " was happy with their stay!");
        else if (customer.get_feedback() < 0)
            System.out.println(this.name + " says: " + customer.get_name() + " was unhappy with their stay!");
        else
            System.out.println(this.name + " says: " + customer.get_name() + " found their stay ok.");
    }
}