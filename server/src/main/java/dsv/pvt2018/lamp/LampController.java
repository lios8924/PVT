package dsv.pvt2018.lamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class LampController {

	@Autowired
	private LampService lampService;
	
	@GetMapping("/lamps")
	public List<Lamp> getAllLamps(){
		return lampService.getAllLamps();
	}
	
	@GetMapping("/maps/{mapId}/lamps")
	public List<Lamp> getLampsByMapId(@PathVariable (value = "mapId") Integer mapId){
		return lampService.getLampsByMapId(mapId);
	}
}
