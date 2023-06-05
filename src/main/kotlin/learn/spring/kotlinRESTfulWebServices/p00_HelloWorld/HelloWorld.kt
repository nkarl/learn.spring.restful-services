package learn.spring.kotlinRESTfulWebServices.p00_HelloWorld

import learn.spring.RESTfulWebServices.p00_HelloWorld.HelloWorldBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @RequestMapping(method = [RequestMethod.GET], path = ["/hello-world"])
    public fun helloWorld(): String {
        return "Hello World!"
    }

    @GetMapping(path = ["/hello-world-bean"])
    public fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hello World!")
    }
}