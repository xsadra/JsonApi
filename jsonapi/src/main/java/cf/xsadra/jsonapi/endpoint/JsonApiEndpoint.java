package cf.xsadra.jsonapi.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/")
public class JsonApiEndpoint {

    private RestTemplate rest;

    public JsonApiEndpoint(RestTemplate rest) {
        this.rest = rest;
    }

    @RequestMapping(params = {"url"}, method = GET)
    String returnResult(@RequestParam("url") String url ) {

        System.out.println(url);
        String response = rest.getForObject(url, String.class);
        System.out.println(response);
        return response;

    }

    @GetMapping
    String wrongRequest() {
        System.out.println("\n ---! Request is wrong !");
        return "---! Request is wrong !";
    }

}
