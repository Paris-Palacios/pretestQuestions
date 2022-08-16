package com.example.pretestquestions.controllers;

import com.example.pretestquestions.dto.InputJsonAvailability;
import com.example.pretestquestions.services.CheckAvailabilityAndCapacity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProdAvailabilityController {

    @Autowired
    private CheckAvailabilityAndCapacity checkAvailabilityAndCapacity;

    @GetMapping(value = "/getProdAvailability", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProdAvailability(@RequestBody InputJsonAvailability inputJsonAvailability) throws Exception {
        JSONObject output = checkAvailabilityAndCapacity.checkAvailabilityAndCapacity(inputJsonAvailability);

                if(output.get("status") == "404"){
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }else {
                        return new ResponseEntity<>(output.toString(),HttpStatus.OK);
                }
    }
}
