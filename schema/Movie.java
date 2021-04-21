package entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter

@Entity
@Table(name = "movies")

@XmlRootElement
@NamedQueries({@NamedQuery(
        name = "Movie.findAll",
        query = "SELECT m FROM Movie m"
), @NamedQuery(
        name = "Movie.findById",
        query = "SELECT m FROM Movie m WHERE m.id = :id"
), @NamedQuery(
        name = "Movie.findByTitle",
        query = "SELECT m FROM Movie m WHERE m.title = :title"
), @NamedQuery(
        name = "Movie.findByReleaseDate",
        query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate"
), @NamedQuery(
        name = "Movie.findByDuration",
        query = "SELECT m FROM Movie m WHERE m.duration = :duration"
), @NamedQuery(
        name = "Movie.findByScore",
        query = "SELECT m FROM Movie m WHERE m.score = :score"
)})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Basic(
            optional = false
    )
    @Column(
            name = "id"
    )
    private Integer id;
    @Column(
            name = "title"
    )
    private String title;
    @Column(
            name = "release_date"
    )
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(
            name = "duration"
    )
    private String duration;
    @Column(
            name = "score"
    )
    private Integer score;

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(duration, movie.duration) && Objects.equals(score, movie.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration='" + duration + '\'' +
                ", score=" + score +
                '}';
    }
}
