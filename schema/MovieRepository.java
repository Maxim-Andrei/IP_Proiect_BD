
import entities.Movie;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository {
    public MovieRepository() {
    }

    public void create(Movie movie) {
        EntityManager mag = ManagerFactory.getFactory().createEntityManager();
        mag.getTransaction().begin();
        mag.persist(movie);
        mag.getTransaction().commit();
        mag.close();
    }

    public Movie findByName(String movieName) {
        EntityManager mag = ManagerFactory.getFactory().createEntityManager();
        List<Movie> movies = mag.createNamedQuery("Movie.findByTitle").setParameter("title", movieName).getResultList();
        mag.close();
        return movies.isEmpty() ? null : (Movie)movies.get(0);
    }

    public Movie findById(int id) {
        EntityManager mag = ManagerFactory.getFactory().createEntityManager();
        List<Movie> movies = mag.createNamedQuery("Movie.findById").setParameter("id", id).getResultList();
        mag.close();
        return movies.isEmpty() ? null : (Movie)movies.get(0);
    }
}
