package learn.spring.RESTfulWebServices.p03_Versioning;

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

    @GetMapping(path = "/person/header", params = "X-API-VERSION=1")
    public PersonV1 getRequestHeaderPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getAcceptHeaderPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getRequestParamPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", params = "X-API-VERSION=1")
    public PersonV2 getRequestHeaderPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getAcceptHeaderPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
