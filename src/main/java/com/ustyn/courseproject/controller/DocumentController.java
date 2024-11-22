package com.ustyn.courseproject.controller;

import com.ustyn.courseproject.constants.Roles;
import com.ustyn.courseproject.document.literature.Article;
import com.ustyn.courseproject.document.literature.Book;
import com.ustyn.courseproject.document.literature.Literature;
import com.ustyn.courseproject.document.reader.Reader;
import com.ustyn.courseproject.document.reader.Scientist;
import com.ustyn.courseproject.document.reader.Student;
import com.ustyn.courseproject.document.user.User;
import com.ustyn.courseproject.dto.UserDto;
import com.ustyn.courseproject.repository.KeyRepository;
import com.ustyn.courseproject.service.literature.LiteratureService;
import com.ustyn.courseproject.service.reader.ReaderService;
import com.ustyn.courseproject.service.role.RoleService;
import com.ustyn.courseproject.service.user.UserService;
import jakarta.validation.Valid;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    UserService userService;
    RoleService roleService;
    KeyRepository keyRepository;
    ReaderService readerService;
    LiteratureService literatureService;

    @Autowired
    public DocumentController(UserService userService,
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

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", userService.findAll());
        model.addAttribute("formUser", new UserDto());

        model.addAttribute("roles", Roles.asList());
        model.addAttribute("selectedRole", Roles.ROLE_GUEST.getValue());

        return "documents/users-list";
    }

    @GetMapping("users/{id}")
    public String user(@PathVariable String id, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("formUser", new UserDto(userService.findById(id)));

        model.addAttribute("roles", Roles.asList());
        model.addAttribute("selectedRole", Roles.ROLE_GUEST.getValue());

        return "documents/users-list";
    }

    @PostMapping("/users/{id}")
    public String delete(@PathVariable String id) {
        System.out.println("delete user called");

        userService.deleteById(id);

        return "redirect:/document/users";
    }

    @PostMapping("/users")
    public String users(@Valid @ModelAttribute("formUser") UserDto userDto,
                        BindingResult bindingResult,
                        Model model) {

        System.out.println(userDto);
        if (bindingResult.hasErrors()) {

            model.addAttribute("users", userService.findAll());
            model.addAttribute("formUser", userDto);

            model.addAttribute("roles", Roles.asList());
            model.addAttribute("selectedRole", Roles.ROLE_GUEST.getValue());

            return "documents/users-list";
        }

        User user = new User(userDto);
        userService.save(user);

        return "redirect:/document/users";
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
