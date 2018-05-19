package dsv.pvt2018.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dsv.pvt2018.services.LoginService;
import dsv.pvt2018.model.User;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class SignupController {

    @Autowired
    private LoginService loginService;

    //Funkar, men 0 säkerhet
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public int signupUser(@RequestBody User user) {

        User foundUser = loginService.validateUserByName(user.getUsername());

        //No existing user, return ok
        if(foundUser == null){
            loginService.addUser(user);
            return 0;
        }
        return 1;
    }
}
