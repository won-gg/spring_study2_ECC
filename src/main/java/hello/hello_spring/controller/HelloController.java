package hello.hello_spring.controller;


import org.springframework.resilience.annotation.EnableResilientMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello"; // templates/hello.html로 연결
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model)  {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody // http body에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // hello spring (html X)
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
