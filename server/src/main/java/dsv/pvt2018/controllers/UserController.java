package dsv.pvt2018.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
	public User addUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}

}
