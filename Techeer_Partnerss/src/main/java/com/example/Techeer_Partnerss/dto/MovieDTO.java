package com.example.Techeer_Partnerss.dto;

import com.example.Techeer_Partnerss.enums.Genre;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDTO {
    private String title;   // 제목을 나타내는 문자열
    private LocalDate releaseDate;  // 개봉 날짜
    private LocalDate endDate;  // 종영 날짜

    private Genre genre; // Enum 타입으로 변경

    

}
