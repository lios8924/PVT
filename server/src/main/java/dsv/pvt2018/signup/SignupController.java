package dsv.pvt2018.signup;


import dsv.pvt2018.login.LoginService;
import dsv.pvt2018.login.MockUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class SignupController {

    @Autowired
    private LoginService loginService;

    //Funkar, men 0 säkerhet
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public int signupUser(@RequestBody MockUser user){

        MockUser foundUser = loginService.validateUserByName(user.getUsername());

        //No existing user, return ok
        if(foundUser == null){
            loginService.addUser(user);
            return 0;
        }
        return 1;
    }
}
