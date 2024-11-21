package com.ustyn.courseproject;

import com.ustyn.courseproject.entity.Subscription;
import com.ustyn.courseproject.entity.literature.Article;
import com.ustyn.courseproject.entity.literature.Book;
import com.ustyn.courseproject.entity.literature.Literature;
import com.ustyn.courseproject.entity.reader.Scientist;
import com.ustyn.courseproject.entity.reader.Student;
import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.entity.user.Role;
import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.repository.LiteratureRepository;
import com.ustyn.courseproject.service.key.KeyService;
import com.ustyn.courseproject.service.literature.LiteratureService;
import com.ustyn.courseproject.service.reader.ReaderService;
import com.ustyn.courseproject.service.subscription.SubscriptionService;
import com.ustyn.courseproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final LiteratureService literatureService;
    private final ReaderService readerService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public DataInitializer(UserService userService,
                           LiteratureService literatureService,
                           ReaderService readerService,
                           SubscriptionService subscriptionService) {
        this.userService = userService;
        this.literatureService = literatureService;
        this.readerService = readerService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void run(String... args) {
        addUsers();
        addLiterature();
        addReaders();
    }

    private void addLiterature() {
        if (!literatureService.existsByTitle("book")) {
            Literature book = new Book("book", "author", "j38dg3", true, 190);
            literatureService.save(book);
        }
        if (!literatureService.existsByTitle("article")) {
            Literature article = new Article("article", "author", "l29dh4", true, LocalDate.now());
            literatureService.save(article);
        }
        System.out.println("literature saved");
    }

    private void addUsers() {
        if(!userService.existsByUsername("admin")) {
            Key key1 = new Key("Test123");
            User adminUser = new User("admin", key1, true, List.of(new Role("ROLE_ADMIN")));
            userService.save(adminUser);
        }
        if(!userService.existsByUsername("operator")) {
            Key key2 = new Key("Something");
            User operatorUser = new User("operator", key2, true, List.of(new Role("ROLE_OPERATOR")));
            userService.save(operatorUser);
        }
        if(!userService.existsByUsername("guest")) {
            Key key3 = new Key("BibaBoba");
            User guestUser = new User("guest", key3, true, List.of(new Role("ROLE_GUEST")));
            userService.save(guestUser);
        }

        System.out.println("users saved");
    }

    private void addReaders() {
        if (!readerService.existsByName("John Doe")) {
            Student student = new Student("John Doe", "123 Elm Street", new Subscription(), LocalDate.now(), "University of Example");

            // TODO: Can't find a codec for CodecCacheKey{clazz=class com.ustyn.courseproject.entity.Subscription, types=null}
            readerService.save(student);
        }

        if (!readerService.existsByName("Dr. Alice Smith")) {
            Scientist scientist = new Scientist("Dr. Alice Smith", "456 Oak Avenue", new Subscription(), LocalDate.now(), "Physics");
            readerService.save(scientist);
        }

        System.out.println("readers saved");
    }
}
