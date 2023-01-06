package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping(path="/api/order" produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@GetMapping
	public ResponseEntity<String> custValid(@PathVariable String name) {

        if(name = null) {

			return ResponseEntity
			.status(HttpStatus.valueOf(404))
			.contentType(MediaType.APPLICATION_JSON)
			.body("error: customer" + name + "not found");
	}


        List<customer> customers = custRepo.getAllCustomers(limit, offset);
        //name not type 






        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (customer cust: customers){
        //looping thru xust list 
        //CURLY BRACES if, ele, whiloe, BLOCK, for loops 
            arrBuilder.add(cust.toJSON());}
        JsonArray result = arrBuilder.build();

        //usually goes with list - cuz array 
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
    }


   
