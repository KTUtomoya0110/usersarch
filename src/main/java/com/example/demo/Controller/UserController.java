package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/search")
    public String searchUser(@RequestParam(name = "id", required = false) String id, Model model) {
        if (id != null) {// 入力されたIDの検証
            UserEntity user = userRepository.findById(id).orElse(null);
            if (user != null) {// 入力されたIDにusernameがあれば,userにusernamaを代入
                model.addAttribute("user", user);
            } else {
                model.addAttribute("errorMessage", "ユーザーが見つかりません");
            }
        } else {
            model.addAttribute("errorMessage", "ユーザーIDが指定されていません");
        }
        return "result";
    }
}
