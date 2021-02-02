package ru.sber.school.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
    @JsonProperty("id_kinopoisk")
    private Long id;

    private String title;

    @JsonProperty("poster")
    private String posterURL;

    private int year;

    private String[] countries;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return year == film.year &&
                Objects.equals(id, film.id) &&
                Objects.equals(title, film.title) &&
                Objects.equals(posterURL, film.posterURL) &&
                Arrays.equals(countries, film.countries) &&
                Objects.equals(description, film.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, posterURL, year, description);
        result = 31 * result + Arrays.hashCode(countries);
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", year=" + year +
                ", countries=" + Arrays.toString(countries) +
                ", description='" + description + '\'' +
                '}';
    }
}
