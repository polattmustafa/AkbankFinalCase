package polat.mustafa.controller.webcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import polat.mustafa.dto.UserDtoWeb;
import polat.mustafa.model.User;
import polat.mustafa.service.UserServiceWeb;


/**
 * @author MPolat
 */

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceWeb userServiceWeb;

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDtoWeb user = new UserDtoWeb();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDtoWeb userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userServiceWeb.findByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userServiceWeb.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/weather")
    public String weather(){
        return "weather";
    }

}
