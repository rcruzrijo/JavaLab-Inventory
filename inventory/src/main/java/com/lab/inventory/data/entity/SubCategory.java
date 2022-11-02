package com.lab.inventory.data.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="sub_category")
public class SubCategory {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
    @Column
    private String description;
    @Column(name="last_updated")
    private LocalDate lastUpdated;
}
