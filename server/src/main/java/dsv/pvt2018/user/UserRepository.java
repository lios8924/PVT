package dsv.pvt2018.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Gjorde om denna till JPA istället för Crud. Kan ju ändras tillbaka.
public interface UserRepository extends JpaRepository<User, String> {

}
