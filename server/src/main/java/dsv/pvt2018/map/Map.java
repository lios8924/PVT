package dsv.pvt2018.map;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import dsv.pvt2018.lamp.Lamp;

@Entity
@Table(name = "maps")
public class Map {

	@Id
	private int id;
	
	@NotNull
	private double lat;
	
	@NotNull
	private double lng;
	
	@NotNull
	private List<Lamp> lamps;
	
	private boolean occupied;
	
	public Map(){}

	public Map(int id, @NotNull double lat, @NotNull double lng, @NotNull List<Lamp> lamps, boolean occupied) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.lamps = lamps;
		this.occupied = occupied;
	}

	public int getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public List<Lamp> getLamps() {
		return lamps;
	}

	public void setLamps(List<Lamp> lamps) {
		this.lamps = lamps;
	}
	
	public void addLamp(Lamp lamp){
		lamps.add(lamp);
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	
}
