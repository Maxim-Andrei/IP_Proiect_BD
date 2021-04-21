package entities;

import entities.Movie;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Movie.class)
public class Movie_ {

    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Date> releaseDate;
    public static volatile SingularAttribute<Movie, String> duration;
    public static volatile SingularAttribute<Movie, Integer> score;

    public Movie_() {
    }
}
