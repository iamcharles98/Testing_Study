package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class NearestParkDto {

    public Long id;
    public String name;
    public Double x_pos;
    public Double y_pos;
}
