import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {

    private static EntityManagerFactory fact = null;

    private ManagerFactory() {
    }

    public static EntityManagerFactory getFactory() {
        if (fact == null) {
            fact = Persistence.createEntityManagerFactory("pa_lab9");
        }

        return fact;
    }


    public static void close() {
        fact.close();
    }

}
