package com.springbootacademy.batch7.pos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestSaveDTO {


    private int customers;

    private Date date;

    private Double total;
}
