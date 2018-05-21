package dsv.pvt2018.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dsv.pvt2018.model.LampCapture;
import dsv.pvt2018.model.Lamp;
import dsv.pvt2018.services.LampService;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) // krävs för kommunikation med ionic
public class LampController {

	@Autowired
	private LampService lampService;
	
	@GetMapping("/lamps")
	public List<Lamp> getAllLamps() {
		System.out.println("getAllLamps");
		return lampService.getAllLamps();
	}
	
	@GetMapping("/maps/{mapId}/lamps")
	public List<Lamp> getLampsByMapId(@PathVariable (value = "mapId") Integer mapId) {
		return lampService.getLampsByMapId(mapId);
	}
	
	@PutMapping("/lamps")
	public void resetLamps() {
		lampService.resetLamps();
	}
	
	@PutMapping("lamps/capture")
	public int captureLamp(@Valid @RequestBody LampCapture lampCap) {
		System.out.println("LampCaptureToString: " + lampCap.toString());
		if (!lampService.captureLamp(lampCap)) {
			//kasta undantag  new ResourceNotFoundException("felmeddelande"));
			System.out.println("Fel vid capture, lampId: " + lampCap.getLamp());
            System.out.println("Lamp capture, lampId: " + lampCap.getLamp());
            return 0;
		}
        System.out.println("capture lyckades");
        return 1;
	}
}
