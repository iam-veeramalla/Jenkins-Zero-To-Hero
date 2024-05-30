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

import java.util.Random;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(final Model model) {
        // Hardcoded values
        model.addAttribute("title", "I have successfuly built a sprint boot application using Maven");
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

        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("input") String input, final Model model) {
        model.addAttribute("response", "Form submitted with input: " + input);
        return "response";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    private void someUnrelatedMethod() {
        System.out.println("This method has nothing to do with the main functionality of the class.");
    }
}
