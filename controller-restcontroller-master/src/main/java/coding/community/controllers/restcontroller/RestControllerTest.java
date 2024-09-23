package coding.community.controllers.restcontroller;

import coding.community.controllers.entity.Bread;
import coding.community.controllers.repository.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestControllerTest {

    @Autowired
    BreadRepository breadRepository;

    // GET -> /rest/5
    @GetMapping(value = "/{bread_id}", produces = "application/json")
    public Bread getBread(@PathVariable Long bread_id) {
        Optional<Bread> bread = breadRepository.findById(bread_id);
        return bread.get();
    }

    // POST -> /rest/create
    @PostMapping(value="/create", produces = "application/json")
    public Bread createBread(@RequestBody Bread bread) {
        return breadRepository.save(bread);
    }
}
