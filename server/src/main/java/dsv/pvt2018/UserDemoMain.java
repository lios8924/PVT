package dsv.pvt2018;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dsv.pvt2018.user.User;
import dsv.pvt2018.user.UserRepository;

@SpringBootApplication
public class UserDemoMain implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UserDemoMain.class);

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserDemoMain.class, args);
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("MY MESSAGE: Run started...");
        List<User> users = new ArrayList<>();

        // Save a few users
        logger.info("MY MESSAGE: Creating users...");
        users.add(new User("Hitchhiker", "ford@theguide.megadodo.ursaminor", "EroticonVI"));
        logger.info("MY INFO: Ford Prefect created.");
        users.add(new User("Clueless", "adent@heartofgold.milkyway", "password1"));
        logger.info("MY INFO: Arthur Dent created.");
        users.add(new User("PresidentOfTheGalaxy", "zaphod@heartofgold.milkyway", "Betelgeuse"));
        logger.info("MY INFO: Zaphod Beeblebrox created.");
        users.add(new User("Trillian", "trish@subetharadio.milkyway", "Astra"));
        logger.info("MY INFO: Tricia McMillan created.");
        users.add(new User("Marvin", "marvin@heartofgold.milkyway", "ImNotParanoid"));
        logger.info("MY INFO: Marvin The Paranoid Android created.");
        userRepository.saveAll(users);
        logger.info("MY MESSAGE: All users saved in repository.");
        logger.info("------------------------------------------------------");
        logger.info("MY MESSAGE: Retrieving all users...");
        logger.info("------------------------------------------------------");

        // Fetch all users
        for (User u : userRepository.findAll()) {
            logger.info("OUTPUT: " + u.toString());
        }
        logger.info("------------------------------------------------------");
        logger.info("MY MESSAGE: Run ended...");
    }
}
