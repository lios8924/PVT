package dsv.pvt2018.lamp;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import dsv.pvt2018.map.MapCTF;

@Entity
@Table(name = "lamps")
public class Lamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private double lat;
	
	@NotNull
	private double lng;
	
	@ManyToOne
	@JoinColumn(name = "map_id") //, nullable = false
	//	@JsonIgnore
	private MapCTF map;
	
	public Lamp(){}
	
	public Lamp(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	public Integer getId() {
		return id;
	}
	public double getLat() {
		return lat;
	}
	public double getLng() {
		return lng;
	}
	public MapCTF getMap(){
		return map;
	}
	public void setMap(MapCTF map){
		this.map = map;
	}
	
	
}
