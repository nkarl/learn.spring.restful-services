package learn.spring.RESTfulWebServices.HelloWorld;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message + " Bean!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
