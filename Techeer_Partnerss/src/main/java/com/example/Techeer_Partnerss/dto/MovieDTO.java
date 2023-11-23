package com.example.Techeer_Partnerss.dto;

import com.example.Techeer_Partnerss.enums.Genre;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDTO {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

    private Genre genre; // Enum 타입으로 변경


}
