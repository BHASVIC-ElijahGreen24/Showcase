import java.util.ArrayList;

public class Hotel {
	private ArrayList<Room> rooms;
	
    Hotel(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    public ArrayList<Room> checkRooms() {
        return this.rooms;
    }

    public ArrayList<Room> get_rooms() {
        return this.rooms;
    }
}