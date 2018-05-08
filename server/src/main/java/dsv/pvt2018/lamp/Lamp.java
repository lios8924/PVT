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
	
	@NotNull
	private int mapId;
	
	public Lamp(){}
	
	public Lamp(int id, double lat, double lng, int mapId) {
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.mapId = mapId;
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
	public int getMapId(){
		return mapId;
	}
//	public void setMapId(int id){
//		mapId = id;
//	}
	
	
}
