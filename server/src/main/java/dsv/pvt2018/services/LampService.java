package dsv.pvt2018.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dsv.pvt2018.model.LampCapture;
import dsv.pvt2018.model.Lamp;
import dsv.pvt2018.model.LampRepository;

@Service
public class LampService {

	@Autowired
	private LampRepository lampRepo;
	
	public List<Lamp> getAllLamps() {
		List<Lamp> lamps = new ArrayList<>();
		lampRepo.findAll().forEach(lamps::add);
		return lamps;
	}
	
	//Ta bort sen
	public void addLamp(Integer id, double lat, double lng) {
		Lamp lamp = new Lamp(lat, lng);
		lampRepo.save(lamp);
	}
	
	public void addLamp(Lamp lamp) {
		lampRepo.save(lamp);
	}

	public List<Lamp> getLampsByMapId(Integer mapId) {
		return lampRepo.findByMapId(mapId);
	}

//	public boolean captureLamp(String team, Integer id) {
//		Optional<Lamp> lamp = lampRepo.findById(id);
//		
//		if(lamp.isPresent()){
//			lamp.get().capture(team);
//			lampRepo.save(lamp.get());
//			return true;
//		}
//		
//		return false;	
//	}
	
	public boolean captureLamp(LampCapture lampCap) {
		Optional<Lamp> lamp = lampRepo.findById(lampCap.getLamp());
		
		if(lamp.isPresent()){
			System.out.println("lamp ID: " + lamp.get().getId());
			lamp.get().capture(lampCap.getTeam());
			lampRepo.save(lamp.get());
			return true;
		}
		System.out.println("Lamp present? : " + lamp.isPresent());
		return false;	
	}

	public void resetLamps() {
		lampRepo.findAll().forEach(l -> l.unCapture());
	}
	
}