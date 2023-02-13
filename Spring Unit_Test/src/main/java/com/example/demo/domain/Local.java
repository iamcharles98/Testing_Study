package com.example.demo.domain;

import lombok.Getter;

@Getter
public class Local {


    private String localname;
    private Double x_pos;
    private Double y_pos;

    public Local(){
    }

    public Local(String localname, Double x_pos, Double y_pos) {
        this.localname = localname;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }


}

