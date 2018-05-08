package dsv.pvt2018.lamp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LampService {

	@Autowired
	private LampRepository lampRepo;
	
	public List<Lamp> getAllLamps(){
		List<Lamp> lamps = new ArrayList<>();
		lampRepo.findAll().forEach(lamps::add);
		return lamps;
	}
	
	//Ta bort sen
	public void addLamp(Integer id, double lat, double lng){
		Lamp lamp = new Lamp(lat, lng);
		lampRepo.save(lamp);
	}
	
	public void addLamp(Lamp lamp){
		lampRepo.save(lamp);
	}

	public List<Lamp> getLampsByMapId(Integer mapId) {
		return lampRepo.findByMapId(mapId);
	}
	
}
