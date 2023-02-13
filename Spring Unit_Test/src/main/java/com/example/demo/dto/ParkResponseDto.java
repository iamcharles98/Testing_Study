package com.example.demo.dto;

import com.example.demo.domain.Park;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class ParkResponseDto {
    @Getter
    private Long id;
    private String name;
    private String address;
    private String content;
    private LocalDateTime lastModifiedTime;
    public ParkResponseDto toParkResponseDto(Park park) {
        this.id = park.getId();
        this.name = park.getName();
        this.address = park.getAddress().fullAddress();
        this.content = park.getContent();
        this.lastModifiedTime = park.getLastModifiedTime();

        return this;
    }
}
