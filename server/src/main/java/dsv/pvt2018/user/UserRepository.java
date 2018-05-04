package dsv.pvt2018.user;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//Gjorde om denna till JPA istället för Crud. Kan ju ändras tillbaka.
public interface UserRepository extends CrudRepository<User, String> {

}
