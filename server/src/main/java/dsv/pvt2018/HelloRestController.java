package dsv.pvt2018;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* Kan tas bort!
*/
@RestController
@RequestMapping("/emil")
public class HelloRestController {

    @RequestMapping("/sayHello")
    public String greeting() {
        return "Hello Everyone, Hej Emil";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "Hello Everyone, Hej Oskar";
    }

}
