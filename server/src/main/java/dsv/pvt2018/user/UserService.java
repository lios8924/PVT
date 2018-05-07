package dsv.pvt2018.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findUserById(String username){
		return userRepository.findById(username);
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void registerUser(String username, String password, String email){
		User user = new User(username, email, password);
		userRepository.save(user);
	}


	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
	
}
