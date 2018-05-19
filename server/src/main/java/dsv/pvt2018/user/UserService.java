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
	
	public Optional<User> findUserById(Long id){
		return userRepository.findById(id);
	}

	public Optional<User> findUserByUserName(String username) {
	    return userRepository.findByUserName(username);
    }
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User registerUser(String username, String email, String password){
		User user = new User(username, email, password);
		return userRepository.save(user);
	}
	
	public User addUser(User user){
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void deleteUser(String username) {
	    Optional<User> foundUser = userRepository.findByUserName(username);
	    if (foundUser.isPresent()) {
	        userRepository.deleteById(foundUser.get().getUserId());
        }
    }
	
}
