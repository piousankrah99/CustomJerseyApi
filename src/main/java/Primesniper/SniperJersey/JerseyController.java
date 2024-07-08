package Primesniper.SniperJersey;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = ("api/v1"))
public class JerseyController {

    private final JerseyService jerseyService;

    public JerseyController(JerseyService jerseyService) {
        this.jerseyService = jerseyService;
    }

    @GetMapping(path= "/")
   public String index(){

        return "index";
    }


    @GetMapping(path="/jerseys")
    public ResponseEntity<ResponseObject> jerseys(){

        return ResponseEntity.ok(jerseyService.allJerseys());
    }


    @GetMapping(path="/thisJersey/{id}")
    public ResponseEntity<ResponseObject> thisJersey(@PathVariable("id") UUID id){

        return ResponseEntity.ok(jerseyService.oneJersey(id));
    }

    @PostMapping(path ="/addJersey")
    public int addJersey(@RequestBody Jersey jersey) {
        return jerseyService.insertJersey(jersey);
    }

    @DeleteMapping(path= "/{id}")
    public int removeJersey(@PathVariable("id") UUID id){
        return jerseyService.deleteJersey(id);
    }

}
