package repository;

import entity.Needer;
import entity.User;
import jakarta.persistence.EntityManager;
import root.ManagerFactorySingleton;

import java.util.List;

public class NeederRepo {

    public void create(Needer object) {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();
        mag.persist(object);
        mag.getTransaction().commit();
        mag.close();
    }

    public List<Needer> findAll() throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<Needer> needers = mag.createNamedQuery("Needer.findAll").getResultList();
        mag.close();

        if (needers.size() == 0) {
            throw new Exception("No needers found!");
        } else {
            return needers;
        }
    }

    //aici e un join intre user si needer si se afiseaza tot despre un needer
    public List<Object[]> findAllInfo() {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        List<Object[]> users = mag.createNamedQuery("Needer.findNeeders").getResultList();

        mag.close();
        return users;
    }

    public Needer findById(int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<Needer> needers = mag.createNamedQuery("Needer.findById").setParameter("idUser", id).getResultList();
        mag.close();

        if (needers.size() > 1) {
            throw new Exception("More than one needer have the ID: " + id);
        } else if (needers.size() == 0) {
            throw new Exception("The needer with ID" + id + " doesn't exist!");
        } else {
            return needers.get(0);
        }
    }

    public List<Needer> findByIsolated(Boolean isIsolated) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<Needer> needers = mag.createNamedQuery("Needer.findByIsolated").setParameter("isIsolated", isIsolated).getResultList();
        mag.close();

        if (needers.size() == 0) {
            if(isIsolated == true)
            throw new Exception("No isolated needers found!");
            else
                throw new Exception("No free needers found!");
        } else {
            return needers;
        }
    }

    public void updateIsolated(Boolean isIsolated , int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        Needer checkNeederById = findById(id);

        List<Needer> allNeeders = findAll();
        for (Needer current : allNeeders) {
                if (current.getIsIsolated().equals(isIsolated) && current.getIdUser() != id) {

                    if(current.getIsIsolated() == true)
                    throw new Exception("You are already isolated!");
                    else
                        throw new Exception("You are already free!");
                }
            }
        }

    public void remove(int id) {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        Needer n = (Needer) mag.createNamedQuery("Needer.findById").setParameter("idUser", id).getResultList().get(0);
        mag.remove(n);

        mag.getTransaction().commit();
        mag.close();

    }






}
