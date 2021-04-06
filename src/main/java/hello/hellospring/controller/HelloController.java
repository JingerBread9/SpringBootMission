package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "무야호~~~!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //중요! ResponseBody는 html형태가 아닌 Data 값만 전달
    //ResponseBody는 viewResolveBody를 사용하지 않음
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") String age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        System.out.println("이름 : " +name);
        System.out.println("나이 : " +age);

        return hello;
    }

    static class Hello{
        private String name;
        private String age;

        public String getName() {
            return name;
        }
        public String getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) { this.age = age; }
    }

}
