package dsv.pvt2018.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsv.pvt2018.lamp.Lamp;
import dsv.pvt2018.lamp.LampRepository;

@Service
public class MapService {

	@Autowired
	private MapRepository mapRepo;
	
	@Autowired
	private LampRepository lampRepo;
	
	public List<MapCTF> getAllMaps() {
		List<MapCTF> maps = new ArrayList<>();
		mapRepo.findAll().forEach(maps::add);
		return maps;
	}

	public Optional<MapCTF> findMapById(int id) {
		return mapRepo.findById(id);
	}

	public void setMapAsOccupied(boolean occupied, int id) {
		Optional<MapCTF> map = mapRepo.findById(id);
		
		if(map.isPresent()){
			map.get().setOccupied(occupied);
			mapRepo.save(map.get());
		}
		
	}

	public List<Lamp> getLampsForMap(int id) {
		List<Lamp> lamps = new ArrayList<>();
		
		Iterator<Lamp> it = lampRepo.findAll().iterator();
		
		while(it.hasNext()){
			Lamp l = it.next();
			if(l.getMapId() == id){
				lamps.add(l);
			}
		}
		return lamps;
	}

}
