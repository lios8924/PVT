package dsv.pvt2018.controllers;
//DETTA FUNKAR 123

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dsv.pvt2018.model.User;
import dsv.pvt2018.services.LoginService;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "file://"}) //krävs för kommunikation med ionic
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public List<User> getServiceUsers() {
        return loginService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int verifyLogin(@RequestBody String body) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        // TODO Handle exceptions and null
        // readTree throws JsonParseException in case of a parsing problem;
        // Can throw IOException if some other problem occurs;
        // Returns null if no jsonNode is found
        JsonNode jsonNode = objectMapper.readTree(body);
        System.err.println("called /login with user: " + jsonNode.asText("Either a missing node or a null."));
        // TODO Handle null
        // get-methods return null if the object is of the wrong node-type,
        // or if it doesn't have a value for specified field, or if there is no field with such name
        JsonNode uname = jsonNode.get("username");
        JsonNode pwd = jsonNode.get("password");

        // TODO Handle null
        // textValue returns null for non-String values
        User foundUser = loginService.validateUser(uname.textValue(), pwd.textValue());
//        User foundUser = loginService.validateUser(user.getUsername(), user.getPassword());

        // FIXME Eliminate magic numbers in the return statements; Make method return boolean instead?
        if (foundUser != null) {
            System.err.println("login success");
            return 0;
        }

        System.err.println("login failed");
        return 1;
    }

}
