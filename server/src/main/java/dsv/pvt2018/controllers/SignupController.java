package dsv.pvt2018.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dsv.pvt2018.model.Account;
import dsv.pvt2018.services.LoginService;
import dsv.pvt2018.model.User;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class SignupController {

    //TODO Merge this class with LoginController

    @Autowired
    private LoginService loginService;

    //Funkar, men 0 säkerhet
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public int signupUser(@RequestBody String body) throws IOException {
        // FIXME
        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(body);
        String uname = jsonNode.get("username").textValue();
        String pwd = jsonNode.get("password").textValue();
        JsonNode email = jsonNode.get("email");
        JsonNode salt = jsonNode.get("salt");
        String mailstr = "unknown@unknownhost.unknowndomain";
        String saltstr;

        // TODO Change the client code to eliminate the need for these tests
        if (email != null) {
            mailstr = email.textValue();
        }
        if (salt != null) {
            saltstr = salt.textValue();
        } else {
            saltstr = Account.createSalt();
        }

        User foundUser = loginService.validateUserByName(uname);

        // FIXME Eliminate magic numbers in the return statements; Make method return boolean instead?
        //No existing user, return ok
        if(foundUser == null){
            loginService.addUser(new User(uname, mailstr, pwd, saltstr));
            return 0;
        }
        return 1;
    }
}
