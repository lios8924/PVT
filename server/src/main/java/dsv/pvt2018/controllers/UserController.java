package dsv.pvt2018.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dsv.pvt2018.model.Account;
import dsv.pvt2018.model.User;
import dsv.pvt2018.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//tveksamt om denna ska finnas sen, iaf som public
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("users/{username}")
	public Optional<User> getUser(@PathVariable String username) {
		return userService.findUserByUserName(username);
	}

	@RequestMapping("users/id/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}

	//för att registrera mha parametrar från url:en
    public void registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String salt) {
        userService.registerUser(username, email, password, salt);
    }
    
    //för att registera mha jasonobjekt
    @PostMapping("/addUser")
	public User addUser(@Valid @RequestBody String body) throws IOException {
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
		return userService.addUser(new User(uname, mailstr, pwd, saltstr));
	}

}
