package dsv.pvt2018.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//tveksamt om denna ska finnas sen, iaf som public
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("users/{username}")
	public Optional<User> getUser(@PathVariable String username){
		return userService.findUserById(username);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{username}")
	public void deleteUser(@PathVariable String username){
		userService.deleteUser(username);
	}
	
	//Ett sätt att ta emot det som behövs, vet inte om det är ok säkerhetsmässigt.
    @RequestMapping(method = RequestMethod.POST, value = "/registerUser")
    public void registerUser(@RequestParam String username, 
    		@RequestParam String password){
        userService.registerUser(username, password);
    }
    
//	@RequestMapping(method=RequestMethod.POST, value="/registerUser")
//	public void registerUser(@RequestBody User user){
//		userService.registerUser(user);
//	}
    
}
