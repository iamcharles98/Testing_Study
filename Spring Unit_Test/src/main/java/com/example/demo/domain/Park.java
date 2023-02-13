package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String contentId;
    @Column(nullable = false, unique = true)
    private String name;
    @Embedded
    private Local local;
    @Embedded
    private Address address;
    private String content;
    private LocalDateTime lastModifiedTime;

    public Park(String name, Local local, Address address, String content, LocalDateTime lastModifiedTime) {
        this.name = name;
        this.local = local;
        this.address = address;
        this.content = content;
        this.lastModifiedTime = lastModifiedTime;
    }



}
