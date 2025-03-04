package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /**
     * URL의 쿼리스트링에 name 값을 넣어줘야 함
     * 그럼 name값을 받아 model에 저장하고 템플릿으로 name 값을 넘김
     * @param name
     * @param model
     * @return
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody //HTTP의 Header부와 Body부에서 Body부의 데이터를 내가 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {

        //JAVA BEAN 규약 (표준 방식) or Property 접근 방식
        //변수는 private으로 만듦 , 변경사항은 public 메서드를 통해 접근
        private String name; //키

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
