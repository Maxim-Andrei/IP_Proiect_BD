package root;

import jakarta.persistence.*;

public class ManagerFactorySingleton {
    private static EntityManagerFactory fact = null;

    public static EntityManagerFactory getFactory() {
        if (fact == null) {
            fact = Persistence.createEntityManagerFactory("proiectIP");
        }

        return fact;
    }

    public static void closeFact() {
        fact.close();
    }
}
