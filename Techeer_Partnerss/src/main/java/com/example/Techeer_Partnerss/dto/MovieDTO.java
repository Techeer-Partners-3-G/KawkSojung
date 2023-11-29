package com.example.Techeer_Partnerss.dto;

import com.example.Techeer_Partnerss.enums.Genre;

import java.time.LocalDate;

public class MovieDTO {
    private String title;   // 제목을 나타내는 문자열
    private LocalDate releaseDate;  // 개봉 날짜
    private LocalDate endDate;  // 종영 날짜

    private Genre genre; // Enum 타입으로 변경

    public Genre getGenre() {
        return genre;
    }   // 영화 장르

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
