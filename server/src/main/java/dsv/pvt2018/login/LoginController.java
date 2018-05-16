package dsv.pvt2018.login;
//DETTA FUNKAR 123
import dsv.pvt2018.user.User;
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
    public int verifyLogin(@RequestBody User user) {
        System.err.println("called /login");

        User foundUser = loginService.validateUser(user.getUsername(), user.getPassword());
        if (foundUser != null) {
            System.err.println("login success");
            return 0;
        }

        System.err.println("login failed");
        return 1;
    }

}