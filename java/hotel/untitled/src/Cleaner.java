import java.util.ArrayList;

public class Cleaner {
	private String name;
	
    Cleaner(String name) {
        this.name = name;
    }

    void cleanRooms(Hotel hotel) {
        ArrayList<Room> rooms = hotel.get_rooms();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).get_occupants().isEmpty()) {
                rooms.get(i).cleaned(); // = true;
                System.out.println(this.name + " cleaned Room " + rooms.get(i).get_number());
            }
        }
    }
}