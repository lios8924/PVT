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
	
	//Behöver den här returnera något? Vilka kontroller ska göras i klienten och vilka här?
	public void registerUser(String username, String password, String email){
		User user = new User(username, email);
		addUser(user);
		//gör något med password
	}
	
	public void registerUser(User user){
		addUser(user);
	}
	
	private void addUser(User user){
		userRepository.save(user);
	}

	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
	
}
