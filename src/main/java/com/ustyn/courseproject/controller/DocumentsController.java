package com.ustyn.courseproject.controller;

import com.ustyn.courseproject.document.literature.Article;
import com.ustyn.courseproject.document.literature.Book;
import com.ustyn.courseproject.document.literature.Literature;
import com.ustyn.courseproject.document.reader.Reader;
import com.ustyn.courseproject.document.reader.Scientist;
import com.ustyn.courseproject.document.reader.Student;
import com.ustyn.courseproject.repository.KeyRepository;
import com.ustyn.courseproject.service.literature.LiteratureService;
import com.ustyn.courseproject.service.reader.ReaderService;
import com.ustyn.courseproject.service.role.RoleService;
import com.ustyn.courseproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentsController {

    UserService userService;
    RoleService roleService;
    KeyRepository keyRepository;
    ReaderService readerService;
    LiteratureService literatureService;

    @Autowired
    public DocumentsController(UserService userService,
                               RoleService roleService,
                               KeyRepository keyRepository,
                               ReaderService readerService,
                               LiteratureService literatureService) {
        this.userService = userService;
        this.roleService = roleService;
        this.keyRepository = keyRepository;
        this.readerService = readerService;
        this.literatureService = literatureService;
    }

    @GetMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", userService.findAll());

        return "documents/users-list";
    }

    @GetMapping("/roles")
    public String roles(Model model) {

        model.addAttribute("roles", roleService.findAll());

        return "documents/roles-list";
    }


    @GetMapping("/keys")
    public String keys(Model model) {

        model.addAttribute("keys", keyRepository.findAll());

        return "documents/keys-list";
    }


    @GetMapping("/readers")
    public String readers(Model model) {

        Collection<Reader> readers = readerService.findAll();

        List<Student> students = readers.stream()
                .filter(reader -> reader instanceof Student)
                .map(reader -> (Student) reader)
                .toList();

        List<Scientist> scientists = readers.stream()
                .filter(reader -> reader instanceof Scientist)
                .map(reader -> (Scientist) reader)
                .toList();

        model.addAttribute("students", students);
        model.addAttribute("scientists", scientists);

        return "documents/readers-list";
    }


    @GetMapping("/literatures")
    public String literatures(Model model) {

        List<Literature> literatures = literatureService.findAll();

        List<Book> books = literatures.stream()
                .filter(literature -> literature instanceof Book)
                .map(literature -> (Book) literature)
                .toList();

        List<Article> articles = literatures.stream()
                .filter(literature -> literature instanceof Article)
                .map(literature -> (Article) literature)
                .toList();

        model.addAttribute("books", books);
        model.addAttribute("articles", articles);

        return "documents/literatures-list";
    }
}
