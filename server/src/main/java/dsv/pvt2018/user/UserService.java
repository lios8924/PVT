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
	
	public User registerUser(String username, String password){
		User user = new User(username, password);
		return userRepository.save(user);
	}
	
	public User addUser(User user){
		return userRepository.save(user);
	}

	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
	
}
