package learn.spring.RESTfulWebServices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getRequestParamPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/v2/person", params = "version=2")
    public PersonV2 getRequestParamPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
