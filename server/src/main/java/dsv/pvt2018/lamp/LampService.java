package dsv.pvt2018.lamp;

import org.springframework.stereotype.Service;

import dsv.pvt2018.map.MapCTF;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public boolean captureLamp(String team, Integer id) {
		Optional<Lamp> lamp = lampRepo.findById(id);
		
		if(lamp.isPresent()){
			lamp.get().capture(team);
			lampRepo.save(lamp.get());
			return true;
		}
		
		return false;	
	}

	public void resetLamps() {
		lampRepo.findAll().forEach(l->l.unCapture());
	}
	
}
