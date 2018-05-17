package dsv.pvt2018.lamp.capture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:8100", "file://" }) // krävs för kommunikation med ionic
public class LampCaptureController {

}
