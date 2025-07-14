import java.util.ArrayList;

public class Receptionist {
    private String name;
    
	Receptionist(String name) {
        this.name = name;
	}

    void checkIn(Hotel hotel, Customer customer) {

        hotel.get_rooms().get(customer.get_room_booking() - 1).add_occupant_feedback(customer);
        System.out.println(this.name + " checked in " + customer.get_name());
    }

    void checkOut(Hotel hotel, Customer customer, Manager manager) {
        hotel.get_rooms().get(customer.get_room_booking() - 1).remove_occupant(customer);
        System.out.println(this.name + " checked out " + customer.get_name());
        manager.take_feedback(customer);
    }
}