package dsv.pvt2018.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

	@Autowired
	private MapRepository mapRepo;
	
	public List<MapCTF> getAllMaps() {
		List<MapCTF> maps = new ArrayList<>();
		mapRepo.findAll().forEach(maps::add);
		return maps;
	}

	public Optional<MapCTF> findMapById(Integer id) {
		return mapRepo.findById(id);
	}

	public MapCTF addMap(MapCTF map) {
		return mapRepo.save(map);
	}
	
	
	//returnerar true eller false beroende på om det fanns en map med id
	public boolean setMapAsOccupied(boolean occupy, Integer id) {
		Optional<MapCTF> map = mapRepo.findById(id);
		
		if(map.isPresent()){
			map.get().setOccupied(occupy);
			mapRepo.save(map.get());
			return true;
		}
		return false;	
	}

}
