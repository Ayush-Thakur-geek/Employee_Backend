package com.example.demo.Controller;

import com.example.demo.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody --> //This controller is responsible for handling the
                    //request mapping and will send the data in ResponseBody
                    //i.e. xml or json.

//OR

@RestController //Defining it as rest API.
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.GET)

    //OR

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Ayush Thakur");
        user.setEmailId("ayush26819@gmail.com");

        return user;
    }
    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable("id2") String name) {
        return "The path variable is: " + id + ":" + name;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
        return "Your name is: " + name + " and EmailId is: " + emailId;
    }
}
