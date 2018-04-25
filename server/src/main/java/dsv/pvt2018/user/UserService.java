package dsv.pvt2018.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private List<User> users = Arrays.asList(
			new User("Erik", "asd@asdasd.com"),
			new User("Maja", "asd@sppp.com"),
			new User("Mats", "asd@asd.com")
			);
	
	public Optional<User> findUserById(Integer ID){
		return userRepository.findById(ID);
	}
	
	
	//bara för test
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	//Behöver den här returnera något? Vilka kontroller ska göras i klienten och vilka här?
	public void registerUser(User user){
		//kolla att den inte redan finns.
		addUser(user);
	}
	
	private void addUser(User user){
		userRepository.save(user);
	}
	
}
