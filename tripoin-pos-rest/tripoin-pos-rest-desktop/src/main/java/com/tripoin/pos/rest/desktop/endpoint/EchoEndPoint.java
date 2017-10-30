package com.tripoin.pos.rest.desktop.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on Oct 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/echo")
public class EchoEndPoint {

    @GetMapping("/hello")
    @ResponseBody
    public String echo(){
        return "Hello World";
    }
}
