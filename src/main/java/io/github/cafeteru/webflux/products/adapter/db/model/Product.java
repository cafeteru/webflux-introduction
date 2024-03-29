package io.github.cafeteru.webflux.products.adapter.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Builder
@Data
@Table
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
    private float price;
}
