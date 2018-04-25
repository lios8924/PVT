package dsv.pvt2018.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public List<User> getServiceUsers(){
        return loginService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String verifyLogin(@RequestParam String username, @RequestParam String password){
        User user = loginService.validateUser(username, password);
        if(user == null){
            return "login";
        }
        return "redirect:/emil";
    }

}