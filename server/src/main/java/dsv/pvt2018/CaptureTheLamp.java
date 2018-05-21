package dsv.pvt2018;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import dsv.pvt2018.model.*;

@SpringBootApplication
public class CaptureTheLamp extends SpringBootServletInitializer{

    private static final Logger log = LoggerFactory.getLogger(CaptureTheLamp.class);

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDDL;

	public static void main(String[] args) {
		SpringApplication.run(CaptureTheLamp.class, args);
		System.out.println("hell");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CaptureTheLamp.class);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository, MapRepository mapRepository, LampRepository lampRepository) {
	    return (args) -> {
            // If Hibernate is set to 'create' or 'create-drop' the database
            // will be populated with some users, lamps and maps
            if (hibernateDDL.contains("create")) {
                populateDb(userRepository, mapRepository, lampRepository);
            }

            // Fetch all users
            System.out.println("-------------------------------");
            System.out.println("Users found with findAll():");
            System.out.println("-------------------------------");
            for (User user : userRepository.findAll()) {
                System.out.println("OUTPUT: " + user.toString());
            }

            System.out.println("--------------------------------");
            System.out.println("Finding user by userName");
            System.out.println("--------------------------------");
            Optional<User> optionalUser = userRepository.findByUserName("zeron");
            if (optionalUser.isPresent()) {
                System.out.println("User found with findByUserName(zeron):");
                User foundUser = optionalUser.get();
                System.out.println("userID: " + foundUser.getUserId() + ", userName: " + foundUser.getUsername() +
                        ", created: " + foundUser.getCreationTime());
                System.out.println("pwd: " + foundUser.getPassword() + ", salt: " + foundUser.getSalt());
                Account foundAccount = foundUser.getAccount();
                System.out.println("Account for user: " + foundAccount.getUserId() + ", email: " +
                        foundAccount.getEmail() + ", pwd: " + foundAccount.getPassword() + ", salt: " + foundAccount.getSalt());
                UserDetail fuDetail = foundUser.getUserDetail();
                System.out.println("Details for user: " + fuDetail.getUserId() + ", 1st name: " +
                        fuDetail.getFirstName() + ", lst name: " + fuDetail.getLastName() + ", profile: " + fuDetail.getProfile());
                System.out.println("Reverse user from account");
                User revUser = foundAccount.getUser();
                System.out.println("Reverse user toString: " + revUser.toString());
            }

        };
    }

    public boolean populateDb(UserRepository userRepository, MapRepository mapRepository, LampRepository lampRepository) {
        // Add some users
        log.info("POPULATE DB: Creating users...");

        User user1 = new User("Hitchhiker", "ford@theguide.megadodo.ursaminor", "EroticonVI", Account.createSalt());
        user1.setDetails("Ford", "Prefect", "");
        User user2 = new User("Clueless", "adent@heartofgold.milkyway", "password1", Account.createSalt());
        user2.setDetails("Arthur", "Dent", "");
        User user3 = new User("PresidentOfTheGalaxy", "zaphod@heartofgold.milkyway", "Betelgeuse", Account.createSalt());
        user3.setDetails("Zaphod", "Beeblebrox", "");
        User user4 = new User("Trillian", "trish@subetharadio.milkyway", "Astra", Account.createSalt());
        user4.setDetails("Tricia", "McMillan", "Saved the Universe from the Krikketers. " +
                "Currently the most popular Sub-Etha Radio reporter, reporting under the name Trillian Astra. " +
                "Mother of one Random Dent.");
        User user5 = new User("Marvin", "marvin@heartofgold.milkyway", "ImNotParanoid", Account.createSalt());
        user5.setDetails("Marvin", "The Paranoid Android", ":(");
        User user6 = new User("Random", "rdent@lamuella.milkyway", "YellowSubmarine", Account.createSalt());
        user6.setDetails("Random", "Dent", "The only daughter of Tricia Marie McMillan " +
                "(aka Trillian Astra) and A. Dent. Sad.");
        User user7 = new User("Fen", "fenny@milliways.uk.earth", "SoLongAndThanks", Account.createSalt());
        user7.setDetails("Fenchurch", "Unknown-Dent", "Conceived in the ticket queue at the Fenchurch Street " +
                "railway station. Currently in a relationship with Arthur.");
        User user8 = new User("Slartibartfast42", "sbf@magrathea.hiddendimension", "YouKnowIT", Account.createSalt());
        user8.setDetails("Slartibartfast", "", "Designer of planets. Fjords are my specialty: the coastline of " +
                "Norway on the planet Earth is my masterpiece!");
        User user9 = new User("Eccentrica", "eccentrica@eroticon6.milkyway", "ErosEtc", Account.createSalt());
        user9.setDetails("Eccentrica", "Gallumbits", "The far-famed triple-breasted whore of Eroticon VI. " +
                "The author of 'The Big Bang Theory - A Personal View by Eccentrica Gallumbits' and 'It's Just One Boob After Another'. " +
                "Some people claim my erogenous zones start four miles from my actual body. Do not be deceived -- it's actually 6 miles! " +
                "The Big Bang was one of my orgasms.");
        User user10 = new User("zeron", "zzz@gmail.com", "HatulMadan", Account.createSalt());
        user10.setDetails("Victor", "S", "");

        log.info("POPULATE DB: Adding users...");
//            userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));
        // Populating users through Set interface so that the order between users is different at each run
        userRepository.saveAll(Stream
                .of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10)
                .collect(Collectors.toSet()
                ));
//            Stream.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10).forEach(user -> userRepository.save(user));

        // Add a few maps
        log.info("POPULATE DB: Creating maps...");
        MapCTF map1 = new MapCTF("Map 1");
        MapCTF map2 = new MapCTF("Map 2");
        MapCTF map3 = new MapCTF("Map 3");
        MapCTF map4 = new MapCTF("Map 4");
        mapRepository.saveAll(Arrays.asList(map1, map2, map3, map4));

        // Add a few lamps
        log.info("POPULATE DB: Creating lamps...");
        Lamp lamp1 = new Lamp(59.407979, 17.945867);
        lamp1.setMap(map1);
        Lamp lamp2 = new Lamp(59.406722, 17.942627);
        lamp2.setMap(map1);
        Lamp lamp3 = new Lamp(59.410099, 17.941377);
        lamp3.setMap(map2);
        Lamp lamp4 = new Lamp(59.407732, 17.947039);
        lamp4.setMap(map3);
        Stream.of(lamp1, lamp2, lamp3, lamp4).forEach(lamp -> lampRepository.save(lamp));

	    return true;
    }
}
