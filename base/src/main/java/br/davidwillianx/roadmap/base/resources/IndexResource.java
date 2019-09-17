package br.davidwillianx.roadmap.base.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i")
public class IndexResource {

    @GetMapping
    public String something() {
        return "MUUU";
    }

}
