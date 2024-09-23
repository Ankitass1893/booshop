package coding.community.controllers.controller;

import coding.community.controllers.entity.Bread;
import coding.community.controllers.repository.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bread")
// .../bread
public class PlainController {

    @Autowired
    BreadRepository breadRepository;

    // GET -> /bread/5
    @GetMapping(value = "/{bread_id}", produces = "application/json")
    @ResponseBody
    public Bread getBread(@PathVariable Long bread_id) {
        Optional<Bread> bread = breadRepository.findById(bread_id);
        return bread.get();
    }

    // POST -> /bread/create
    @PostMapping(value="/create", produces = "application/json")
    @ResponseBody
    public Bread createBread(@RequestBody Bread bread) {
        return breadRepository.save(bread);
    }
}
