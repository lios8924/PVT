package dsv.pvt2018.map;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dsv.pvt2018.lamp.Lamp;

@RestController
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping
	public List<MapCTF> getAllMaps(){
		return mapService.getAllMaps();
	}
	
	@RequestMapping("maps/{id}")
	public Optional<MapCTF> getMap(@PathVariable int id){
		return mapService.findMapById(id);
	}
	
	@RequestMapping("maps/{id}/lamps")
	public List<Lamp> getLampsForMaps(@PathVariable int id){
		return mapService.getLampsForMap(id);		
	}
	
	//För att spela en map, sätter maps variabel occupied.
    @RequestMapping(method = RequestMethod.PUT, value = "/maps/{id}")
    public void occupyMap(@RequestParam boolean occupy, @PathVariable int id){
        mapService.setMapAsOccupied(occupy, id);
    }
	
    
    
}
