package com.springbootacademy.batch7.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {



    private String itemName;


    private double Qty;


    private double amount;

    private int oredrs;
   private int items;
}
