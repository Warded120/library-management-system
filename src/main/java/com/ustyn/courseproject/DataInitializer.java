package com.ustyn.courseproject;

import com.ustyn.courseproject.constants.Roles;
import com.ustyn.courseproject.document.Ticket;
import com.ustyn.courseproject.document.library.Library;
import com.ustyn.courseproject.document.literature.Article;
import com.ustyn.courseproject.document.literature.Book;
import com.ustyn.courseproject.document.literature.Literature;
import com.ustyn.courseproject.document.reader.Scientist;
import com.ustyn.courseproject.document.reader.Student;
import com.ustyn.courseproject.document.user.Key;
import com.ustyn.courseproject.document.user.Role;
import com.ustyn.courseproject.document.user.User;
import com.ustyn.courseproject.service.library.LibraryService;
import com.ustyn.courseproject.service.libraryStaff.LibraryStaffService;
import com.ustyn.courseproject.service.literature.LiteratureService;
import com.ustyn.courseproject.service.reader.ReaderService;
import com.ustyn.courseproject.service.ticket.TicketService;
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
    private final TicketService ticketService;
    private final LibraryStaffService libraryStaffService;
    LibraryService libraryService;

    @Autowired
    public DataInitializer(UserService userService,
                           LiteratureService literatureService,
                           ReaderService readerService,
                           TicketService ticketService,
                           LibraryStaffService libraryStaffService,
                           LibraryService libraryService) {
        this.userService = userService;
        this.literatureService = literatureService;
        this.readerService = readerService;
        this.ticketService = ticketService;
        this.libraryStaffService = libraryStaffService;
        this.libraryService = libraryService;
    }

    @Override
    public void run(String... args) {
        addUsers();
        addLiterature();
        addReaders();
        addLibrary();
    }

    private void addLibrary() {
        Library library = new Library("BaseLibrary", literatureService.findAll(), libraryStaffService.findAll(), readerService.findAll());

        libraryService.save(library);
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

    private void addReaders() {
        if (!readerService.existsByName("John Doe")) {
            Ticket ticket = new Ticket(List.of(literatureService.findByTitle("book")));
            Ticket savedTicket = ticketService.save(ticket);
            System.out.println("saved ticket: " + savedTicket);

            Student student = new Student("John Doe", "123 Elm Street", savedTicket, LocalDate.now(), "University of Example");

            readerService.save(student);
        }

        if (!readerService.existsByName("Dr. Alice Smith")) {
            Ticket ticket = new Ticket(List.of(literatureService.findByTitle("article")));
            Ticket savedTicket = ticketService.save(ticket);
            System.out.println("saved ticket: " + savedTicket);

            Scientist scientist = new Scientist("Dr. Alice Smith", "456 Oak Avenue", savedTicket, LocalDate.now(), "Physics");
            readerService.save(scientist);
        }

        System.out.println("readers saved");
    }

    private void addUsers() {
        if(!userService.existsByUsername("admin")) {
            Key key1 = new Key("Test123");
            User adminUser = new User("admin", key1, true, List.of(new Role(Roles.ROLE_ADMIN.getValue())));
            userService.save(adminUser);
        }
        if(!userService.existsByUsername("operator")) {
            Key key2 = new Key("Something");
            User operatorUser = new User("operator", key2, true, List.of(new Role(Roles.ROLE_OPERATOR.getValue())));
            userService.save(operatorUser);
        }
        if(!userService.existsByUsername("guest")) {
            Key key3 = new Key("BibaBoba");
            User guestUser = new User("guest", key3, true, List.of(new Role(Roles.ROLE_GUEST.getValue())));
            userService.save(guestUser);
        }

        System.out.println("users saved");
    }
}
