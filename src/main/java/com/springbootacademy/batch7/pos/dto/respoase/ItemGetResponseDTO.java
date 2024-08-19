package com.springbootacademy.batch7.pos.dto.respoase;

import com.springbootacademy.batch7.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class ItemGetResponseDTO {

    private int itemId;

    private String itemName;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private  boolean active;


}
