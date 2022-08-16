package com.example.pretestquestions.controllers;

import com.example.pretestquestions.dto.RequestInputInventory;
import com.example.pretestquestions.dto.RequestedOutputInventory;
import com.example.pretestquestions.services.QuantityAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInventoryController {

    @Autowired
    QuantityAvailableService quantityAvailableService;

    @PostMapping(value = "/getInvPicture")
        public ResponseEntity<RequestedOutputInventory> getInvPicture(@RequestBody RequestInputInventory requestInputInventory){

            try{
                RequestedOutputInventory requestedOutputInventory = quantityAvailableService.quantityAvailable(requestInputInventory);
                return new ResponseEntity<RequestedOutputInventory>(requestedOutputInventory, HttpStatus.OK);
            }
            catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        }
}
