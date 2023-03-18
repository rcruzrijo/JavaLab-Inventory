package com.lab.inventory.data.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="sub_category")
public class SubCategory {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="sub_category_id_seq")
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
