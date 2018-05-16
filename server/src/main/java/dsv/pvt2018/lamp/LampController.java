package dsv.pvt2018.lamp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class LampController {

	@Autowired
	private LampService lampService;
	
	@GetMapping("/lamps")
	public List<Lamp> getAllLamps(){
		System.out.println("getAllLamps");
		return lampService.getAllLamps();
	}
	
	@GetMapping("/maps/{mapId}/lamps")
	public List<Lamp> getLampsByMapId(@PathVariable (value = "mapId") Integer mapId){
		return lampService.getLampsByMapId(mapId);
	}
	
//	@PutMapping("/lamps/{id}")
//	public void captureLamp(@RequestParam String team, @PathVariable Integer id){
//		if(!lampService.captureLamp(team, id)){
//			//kasta undantag  new ResourceNotFoundException("MapId " + id + " not found"));
//			System.out.println("fel vid capture");
//		}
//		System.out.println("capture lyckades");
//	}
	
	@PutMapping("/lamps")
	public void resetLamps(){
		lampService.resetLamps();
	}
	
	@PutMapping("lamps/capture")
	public void captureLamp(@Valid @RequestBody LampCapture lampCap){
		System.out.println("LampCaptureToString: " + lampCap.toString());
		if(!lampService.captureLamp(lampCap)){
			//kasta undantag  new ResourceNotFoundException("felmeddelande"));
			System.out.println("fel vid capture");
			System.out.println("Lamp capture, lampId: " + lampCap.getLamp());
		}
		else
			System.out.println("capture lyckades");
	
	}
}
