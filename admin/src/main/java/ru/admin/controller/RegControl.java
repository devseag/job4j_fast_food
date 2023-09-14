package ru.admin.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.admin.repository.AuthorityRepository;
import ru.admin.repository.UserRepository;
import ru.domain.model.User;


@Controller
@RequestMapping("/admin")
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserRepository users;
    private final AuthorityRepository authorities;

    public RegControl(PasswordEncoder encoder, UserRepository users, AuthorityRepository authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        try {
            users.save(user);
            return "redirect:/admin/login";
        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
        }
        model.addAttribute("message", "Oshibka sohranenija logina. Vozmozhno, login uzhe sushhestvuet");
        return "errors/404";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}