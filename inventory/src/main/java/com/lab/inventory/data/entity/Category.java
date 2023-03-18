package com.lab.inventory.data.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="category_id_seq")
    private int id;
    @Column
    private String description;
    @Column(name="last_updated")
    private LocalDate lastUpdated;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="category")
    private List<SubCategory> subCategories;
}
