package com.qiangge.provide.restful;

import com.qiangge.model.House;
import com.qiangge.model.Way;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindWayController {

    @RequestMapping(method = RequestMethod.POST,value = "/getway" )
    public Way getWay(@RequestBody Way way){
        way.setFrom("改版");
        way.setHouse(new House("moji","西城区","100平米"));
        return way;
    }
}
