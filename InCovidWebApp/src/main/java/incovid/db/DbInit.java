package incovid.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        //pepethis.userRepository.deleteAll();

        /* Crete users
        User dan = new User("dan",passwordEncoder.encode("dan"),"USER","",1);
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2",1);
        User manager = new User("man",passwordEncoder.encode("man123467"),"MANAGER","ACCESS_TEST1",0);
        User manager1 = new User("man1","man1","MANAGER","ACCESS_TEST1",1);

        List<User> users = Arrays.asList(dan,admin,manager,manager1);

        // Save to db
        this.userRepository.saveAll(users);*/
    }
}
