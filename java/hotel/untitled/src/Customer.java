public class Customer {
	private int roomBooking;
	private String name;
	private int feedback;
	
    Customer(int roomBooking, String name) {
        this.roomBooking = roomBooking;
        this.name = name;
        this.feedback = 0;
    }

    public int get_room_booking() {
        return this.roomBooking;
    }

    public void edit_feedback(int num) {
        this.feedback += num;
    }

    public int get_feedback() {
        return this.feedback;
    }

    public String get_name() {
        return this.name;
    }
}