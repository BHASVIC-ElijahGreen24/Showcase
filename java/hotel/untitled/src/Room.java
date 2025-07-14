import java.util.ArrayList;

public class Room {
	private int number;
	private int size;
	private ArrayList<Customer> occupants;
	private boolean clean;
	
    Room(int number, int size, boolean clean) {
        this.number = number;
        this.size = size;
        this.occupants = new ArrayList<Customer>();
        this.clean = clean;
    }

    public int get_number() {
        return this.number;
    }

    public void add_occupant(Customer occupantIn) {
        occupants.add(occupantIn);
    }

    public ArrayList<Customer> get_occupants() {
        return this.occupants;
    }

    public void cleaned() {
        this.clean = true;
    }

    public void add_occupant_feedback(Customer occupantIn) {
        if (this.occupants.size() < this.size) {
            this.add_occupant(occupantIn);
            occupantIn.edit_feedback(1);
        }
        else {
            occupantIn.edit_feedback(-1);
            return;
        }
        if (this.clean)
            occupantIn.edit_feedback(1);
        else {
            occupantIn.edit_feedback(-1);
        }
        this.clean = false;
    }

    void remove_occupant(Customer occupantOut) {
        int index = -1;
        for (int i = 0; i < this.occupants.size(); i++) {
            if (this.occupants.get(i).equals(occupantOut))
                index = i;
        }
        if (index != -1) {
            this.occupants.remove(index);
        }
    }
}