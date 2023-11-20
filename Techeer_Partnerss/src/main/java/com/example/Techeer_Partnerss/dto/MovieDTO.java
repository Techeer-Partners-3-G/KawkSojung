package com.example.Techeer_Partnerss.dto;

import com.example.Techeer_Partnerss.enums.Genre;

import java.time.LocalDate;

public class MovieDTO {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

    private Genre genre; // Enum 타입으로 변경

    public Genre getGenre() {
        return genre;
    }

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
