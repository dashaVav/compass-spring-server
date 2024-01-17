package com.example.compass.controller;

import com.example.compass.dtos.RangesOfCardinalDirectionsDTO;
import com.example.compass.dtos.ResponseDTO;
import com.example.compass.logic.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private static final Model compassModel = Model.getInstance();

    @PostMapping(value = "/init", consumes = "application/json")
    public void initCompass(@RequestBody RangesOfCardinalDirectionsDTO ranges) {
        compassModel.setCoordinates(ranges);
    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public ResponseDTO getSide(@RequestBody Map<String, Integer> degree) {
        return new ResponseDTO(compassModel.findSide(degree.get("degree")));
    }
}
