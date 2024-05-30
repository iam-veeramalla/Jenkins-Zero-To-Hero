// package com.abhishek;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// @SpringBootApplication
// @Controller
// public class StartApplication {

//     @GetMapping("/")
//     public String index(final Model model) {
//         model.addAttribute("title", "I have successfuly built a sprint boot application using Maven");
//         model.addAttribute("msg", "This application is deployed on to Kubernetes using Argo CD");
//         return "index";
//     }

//     public static void main(String[] args) {
//         SpringApplication.run(StartApplication.class, args);
//     }

// }
package com.abhishek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

@SpringBootApplication
@Controller
public class StartApplication {

    private String sharedResource = "Initial Value";

    @GetMapping("/")
    public String index(final Model model) {
        // Hardcoded values
        model.addAttribute("title", "I have successfully built a spring boot application using Maven");
        model.addAttribute("msg", "This application is deployed on to Kubernetes using Argo CD");

        // Unnecessary code
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        model.addAttribute("randomNumber", randomNumber);

        // Duplicate logic
        String duplicateString = "Duplicate logic here";
        model.addAttribute("duplicate1", duplicateString);
        model.addAttribute("duplicate2", duplicateString);

        // Unrelated responsibilities
        someUnrelatedMethod();

        // Null pointer exception potential
        String potentialNull = null;
        if (randomNumber > 50) {
            potentialNull = "Not null anymore";
        }
        model.addAttribute("potentialNull", potentialNull.length()); // May cause NullPointerException

        // Modify shared resource (thread safety issue)
        sharedResource = sharedResource + " - Modified";
        model.addAttribute("sharedResource", sharedResource);

        return "index";
    }

 
