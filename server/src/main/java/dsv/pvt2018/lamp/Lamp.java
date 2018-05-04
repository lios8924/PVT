package dsv.pvt2018.lamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lamps")
public class Lamp {

	@Id
	private int id;
	
	@NotNull
	private double lat;
	
	@NotNull
	private double lng;
	
	public Lamp(){}
	
	public Lamp(int id, double lat, double lng) {
		this.id = id;
		this.lat = lat;
		this.lng = lng;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
