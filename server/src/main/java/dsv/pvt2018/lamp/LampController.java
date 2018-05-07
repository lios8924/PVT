package dsv.pvt2018.lamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LampController {

	@Autowired
	private LampService lampService;
	
	@RequestMapping("lamps")
	public List<Lamp> getAllLamps(){
		return lampService.getAllLamps();
	}
}
