package com.springboot.demo.domain.category;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private Category parentCategory;
}
