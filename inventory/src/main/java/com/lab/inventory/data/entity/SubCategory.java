package com.lab.inventory.data.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;
    @Column
    private String description;
    @Column(name="last_updated")
    private LocalDate lastUpdated;
}
