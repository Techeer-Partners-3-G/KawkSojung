package com.example.Techeer_Partnerss.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre; // 스릴러, 로맨스, 코믹, 액션
    private LocalDate releaseDate;
    private LocalDate endDate;
    private boolean isShowing; // 서비스 계층에서 계산

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;


}
