package com.example.demo.controller;


import com.example.demo.dto.NearestParkDto;
import com.example.demo.dto.ParkResponseDto;
import com.example.demo.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/parks")
public class ParkController {
    private final ParkService parkService;

    @GetMapping("/{parkId}")
    public ResponseEntity<ParkResponseDto> getParkInfoById(@PathVariable Long parkId){
        return new ResponseEntity<>(parkService.findOne(parkId), HttpStatus.OK);
    }

    @GetMapping("/nearest")
    public ResponseEntity<NearestParkDto> getNearestPark(@RequestParam Double x, @RequestParam Double y){
        return new ResponseEntity<>(parkService.findNearestPark(x, y), HttpStatus.OK);
    }
}
