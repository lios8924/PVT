package dsv.pvt2018.map;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	
	@GetMapping("/maps")
	public List<MapCTF> getAllMaps(){
		return mapService.getAllMaps();
	}
	
	
	//antingen göra såhär, eller göra som med occupyMap och kasta undantag.
	@GetMapping("/maps/{id}")
	public Optional<MapCTF> getMap(@PathVariable Integer id){
		return mapService.findMapById(id);
	}
	
	@PostMapping("/maps")
	public MapCTF createMap(@Valid @RequestBody MapCTF map){
		return mapService.addMap(map);
	}
	
	@PutMapping("/maps/{id}")
	public void occupyMap(@RequestParam boolean occupy, @PathVariable Integer id){
		if(!mapService.setMapAsOccupied(occupy, id)){
			//kasta undantag  new ResourceNotFoundExcption("MapId " + id + " not found"));
		}
	}
	
//	@RequestMapping
//	public List<MapCTF> getAllMaps(){
//		return mapService.getAllMaps();
//	}
//	
//	@RequestMapping("maps/{id}")
//	public Optional<MapCTF> getMap(@PathVariable Integer id){
//		return mapService.findMapById(id);
//	}
//	
////	@RequestMapping("maps/{id}/lamps")
////	public List<Lamp> getLampsForMaps(@PathVariable int id){
////		return mapService.getLampsForMap(id);		
////	}
//	
//	//För att spela en map, sätter maps variabel occupied.
//    @RequestMapping(method = RequestMethod.PUT, value = "/maps/{id}")
//    public void occupyMap(@RequestParam boolean occupy, @PathVariable Integer id){
//        mapService.setMapAsOccupied(occupy, id);
//    }
	
    
    
}
