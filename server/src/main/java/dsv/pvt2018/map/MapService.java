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
	
	public List<Map> getAllMaps() {
		List<Map> maps = new ArrayList<>();
		mapRepo.findAll().forEach(maps::add);
		return maps;
	}

	public Optional<Map> findMapById(int id) {
		return mapRepo.findById(id);
	}

	public void setMapAsOccupied(boolean occupied, int id) {
		Optional<Map> map = mapRepo.findById(id);
		
		if(map.isPresent()){
			map.get().setOccupied(occupied);
			mapRepo.save(map.get());
		}
		
	}

}
