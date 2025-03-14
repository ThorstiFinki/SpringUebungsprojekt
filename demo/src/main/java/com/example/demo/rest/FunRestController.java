package com.example.demo.rest;

import com.example.demo.database.Users;
import com.example.demo.database.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FunRestController {

    //BeispielValue aus application Properties~~~~~~~~~~
    @Value("${band.name}")
    private String bandName;

    @Value("${singer.name}")
    private String singerName;
    @GetMapping ("/music")
    public String getMusic(){
        return "Band: " + bandName +", Singer: "+ singerName;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        System.out.println("Received user: " + user);
        System.out.println("Alter value: " + user.getAge()); // Debugging-Zwecke
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //expose "/" that return "Spring REST Controller"
    @GetMapping("/api")
    public String sayHello(){
        return "Rest Controller Api";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hallo, " + name + "!";
    }

}
