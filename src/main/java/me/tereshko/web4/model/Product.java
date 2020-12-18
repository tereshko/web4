package me.tereshko.web4.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
}
