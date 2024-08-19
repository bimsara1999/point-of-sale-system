package com.springbootacademy.batch7.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@TypeDefs({
        @TypeDef(name = "json" , typeClass = JsonStringType.class),
})

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id" ,length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "order_date" , columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total" , nullable = false)
    private Double total;



}
