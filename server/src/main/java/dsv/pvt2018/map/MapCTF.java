package dsv.pvt2018.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maps")
public class MapCTF {

	@Id
	private int id;
	
	private boolean occupied;
	
	public MapCTF(){}

	public MapCTF(int id, boolean occupied) {
		super();
		this.id = id;
		this.occupied = occupied;
	}

	public int getId() {
		return id;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	
}
