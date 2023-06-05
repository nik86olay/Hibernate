
import model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Persons> Profile(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
