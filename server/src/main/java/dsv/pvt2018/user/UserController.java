package dsv.pvt2018.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import dsv.pvt2018.map.MapCTF;



>>>>>>> 4dce40081876007528a5020e0d61ed9fad6d4b3d
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
	
	//för att registrera mha av värden från url:en
    @RequestMapping(method = RequestMethod.POST, value = "/registerUser")
<<<<<<< HEAD
    	public void registerUser(@RequestParam String username, 
    		@RequestParam String password, @RequestParam String email){
        userService.registerUser(username, password, email);
    }
=======
    public void registerUser(@RequestParam String username, 
    		@RequestParam String password){
        userService.registerUser(username, password);
    }
    
    //för att registera mha jasonobjekt
    @PostMapping("/addUser")
	public User addUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}
    
    
>>>>>>> 4dce40081876007528a5020e0d61ed9fad6d4b3d
}
