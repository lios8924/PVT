package dsv.pvt2018.lamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dsv.pvt2018.map.MapService;

@RestController
public class LampController {

	@Autowired
	private LampService lampService;
	
//	@Autowired
//	private MapService mapService;
	
	@GetMapping("/lamps")
	public List<Lamp> getAllLamps(){
		return lampService.getAllLamps();
	}
	
	@GetMapping("/maps/{mapId}/lamps")
	public List<Lamp> getLampsByMapId(@PathVariable (value = "mapId") Integer mapId){
		return lampService.getLampsByMapId(mapId);
	}
}
