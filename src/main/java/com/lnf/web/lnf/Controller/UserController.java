package com.lnf.web.lnf.Controller;

import com.lnf.web.lnf.Data.User;
import com.lnf.web.lnf.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {



    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String create(User user){
        System.out.print("user="+user);
        userRepository.save(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }
}
