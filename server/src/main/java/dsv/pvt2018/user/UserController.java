package dsv.pvt2018.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//tveksamt om denna ska finnas, iaf som public
	@RequestMapping("/users")
	public List<User> getAllUser(){
//		User user = new User("er", "mejl@m.com");
//		userService.registerUser(user);
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{username}")
	public Optional<User> getUser(@PathVariable String username){
		return userService.findUserById(username);
	}
	
	//Har utelämnat password eftersom jag inte vet hur vi ska göra med dem.
	@RequestMapping(method=RequestMethod.POST, value="/registerUser")
	public void registerUser(@RequestBody User user){
		userService.registerUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{username}")
	public void deleteUser(@PathVariable String username){
		userService.deleteUser(username);
	}
	
//	@RequestMapping(method = RequestMethod.POST, value= "/registerUser")
//	public void registerUser(
//			@RequestParam String username,
//			@RequestParam String email,
//			@RequestParam String password){
//	}
}
