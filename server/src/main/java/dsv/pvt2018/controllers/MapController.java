package dsv.pvt2018.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dsv.pvt2018.model.MapCTF;
import dsv.pvt2018.services.MapService;

@RestController
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	
	@GetMapping("/maps")
	public List<MapCTF> getAllMaps() {
		return mapService.getAllMaps();
	}
	
	//antingen göra såhär, eller göra som med occupyMap och kasta undantag.
	@GetMapping("/maps/{id}")
	public Optional<MapCTF> getMap(@PathVariable Integer id) {
		return mapService.findMapById(id);
	}
	
	@PostMapping("/maps")
	public MapCTF createMap(@Valid @RequestBody MapCTF map) {
		return mapService.addMap(map);
	}
	
	@PutMapping("/maps/{id}")
	public void occupyMap(@RequestParam boolean occupy, @PathVariable Integer id) {
		if(!mapService.setMapAsOccupied(occupy, id)){
			//kasta undantag  new ResourceNotFoundException("MapId " + id + " not found"));
		}
	}

}
