package com.example.Techeer_Partnerss.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;



@Data
@Entity
public class Movie {
    @Id // 해당 필드가 엔티티의 기본 키(primary key)임을 나타냄.
    /*@GeneratedValue : 기본 키의 값을 자동으로 생성하는 방법 지정.
     * GenerationType.IDENTITY : 데이터베이스에서 자동 증가식을 사용하여 기본 키를 생성하는 것을 의미.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre; // 스릴러, 로맨스, 코믹, 액션
    private LocalDate releaseDate;
    private LocalDate endDate;
    private boolean isShowing; // 서비스 계층에서 계산

    /*@CreationTimestamp 어노테이션은 Hibernate에서 제공하는 기능으로,
    엔티티가 생성될 때 자동으로 해당 필드에 현재 시간을 기록.
    여기서는 createdDate 필드에 해당 어노테이션이 사용되었으므로,
    엔티티가 생성될 때 해당 필드에 자동으로 생성된 날짜가 기록*/
    @CreationTimestamp
    /* @Column 어노테이션은 엔티티 클래스의 필드와 컬럼 간의 매핑을 설정.
    *  createdDate 필드가 데이터베이스의 컬럼과 매핑될 때의 설정을 나타냄.
    * nullable = false 는 해당 컬럼이 널(null) 값을 허용하지 않음을 의미하고,
    * updatable = false 는 해당 컬럼의 값이 변경 되지 않음을 의미.*/
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;


}
