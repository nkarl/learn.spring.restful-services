package learn.spring.kotlinRESTfulWebServices.p00_HelloWorld

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @RequestMapping(method = [RequestMethod.GET], path = ["/hello-world"])
    public fun helloWorld(): String {
        return "Hello World!"
    }
}