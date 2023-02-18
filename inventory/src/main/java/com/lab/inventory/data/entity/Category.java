package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.sql.Select;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String description;
    @Column(name="last_updated")
    private LocalDate lastUpdated;
    @OneToMany(mappedBy="category")
    private Set<SubCategory> subCategories;
}
