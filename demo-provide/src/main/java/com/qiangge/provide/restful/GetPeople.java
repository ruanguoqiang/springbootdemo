package com.qiangge.provide.restful;

import com.qiangge.model.People;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPeople {

    @PostMapping(value ="/getPeople" )
    public People getPeople(@RequestBody People people){
        people.setTall(158);
        return people;
    }
}
