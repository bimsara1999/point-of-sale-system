package com.springbootacademy.batch7.pos.dto.request;

import com.springbootacademy.batch7.pos.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemSaveReaquestDTO {




    private String itemName;



    private MeasuringUnitType measuringUnitType;


    private double balanceQty;


    private double supplierPrice;


    private double sellingPrice;

}
