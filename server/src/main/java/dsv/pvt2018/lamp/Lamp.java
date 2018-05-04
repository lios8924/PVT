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
	private float lat;
	
	@NotNull
	private float lng;
	
	public Lamp(int id, float lat, float lng) {
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
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	
	
}
