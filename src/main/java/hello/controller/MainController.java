package hello.controller;

import hello.model.User;
import hello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // URL's start with /demo (after Application path)
public class MainController {
    @Autowired // get the bean called userRepository
    private UserRepository userRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests || Probably should be @PostMapping
    public @ResponseBody String addNewUser (@RequestParam String name,
                                            @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam gets a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // return a JSON or XML with the users
        return userRepository.findAll();
    }

}
