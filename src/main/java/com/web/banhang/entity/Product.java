package com.web.banhang.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameProduct;

    @NotNull
    private Double priceProduct;



    private String describeProduct;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

}
