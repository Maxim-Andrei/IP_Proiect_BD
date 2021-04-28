package repository;

import entity.Needer;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import root.ManagerFactorySingleton;

import java.util.ArrayList;
import java.util.List;


public class UserRepo {

    public void create(User object) {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();
        mag.persist(object);
        mag.getTransaction().commit();
        mag.close();
    }

    public List<User> findAll() throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findAll").getResultList();
        mag.close();


        if (users.size() == 0) {
            throw new Exception("No users found!");
        } else {
            return users;
        }
    }

    public User findById(int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findById").setParameter("id", id).getResultList();
        mag.close();

        if (users.size() > 1) {
            throw new Exception("More than one user have the ID: " + id);
        } else if (users.size() == 0) {
            throw new Exception("The user with ID" + id + " doesn't exist!");
        } else {
            return users.get(0);
        }
    }

    public User findByUsername(String username) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByUsername").setParameter("username", username).getResultList();
        mag.close();

        if (users.size() > 1) {
            throw new Exception("More than one user have the username: " + username);
        } else if (users.size() == 0) { //va fi mapat si transmis prin http la client
            throw new Exception("The user with username " + username + " doesn't exist!");
        } else {
            return users.get(0);
        }
    }

    public List<User> findByFirstname(String firstName) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByFirstName").setParameter("firstName", firstName).getResultList();
        mag.close();


        if (users.size() == 0) {
            throw new Exception("The user with first name " + firstName + " doesn't exist!");
        } else {
            return users;
        }
    }

    public List<User> findByLastname(String lastName) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByLastName").setParameter("lastName", lastName).getResultList();
        mag.close();


        if (users.size() == 0) {
            throw new Exception("The user with last name " + lastName + " doesn't exist!");
        } else {
            return users;
        }
    }

    public List<User> findByAddress(String address) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByAddress").setParameter("address", address).getResultList();
        mag.close();


        if (users.size() == 0) {
            throw new Exception("The user with address " + address + " doesn't exist!");
        } else {
            return users;
        }
    }

    public User findByTelephone(String telephone) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByTelephone").setParameter("telephone", telephone).getResultList();
        mag.close();


        if (users.size() > 1) {
            throw new Exception("More than one user have the number: " + telephone);
        } else if (users.size() == 0) {
            throw new Exception("The user with number " + telephone + " doesn't exist!");
        } else {
            return users.get(0);
        }
    }

    public List<User> findByDate(String date) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByDate").setParameter("date", date).getResultList();
        mag.close();


        if (users.size() == 0) {
            throw new Exception("No account was created at date: " + date);
        } else {
            return users;
        }
    }

    public List<User> findByType(String type) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        List<User> users = mag.createNamedQuery("User.findByType").setParameter("type", type).getResultList();
        mag.close();

        if (users.size() == 0) {
            throw new Exception("No user with type " + type + " was found!");
        } else {
            return users;
        }
    }

    public void updateUsername(String username, int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        User checkUserById = findById(id);

        List<User> allUsers = findAll();
        for (User current : allUsers) {
            if (current.getUsername().equals(username) && current.getId() != id) {
                throw new Exception("An user with username " + username + " already exists!");
                //tot mapat
            } else {
                if (current.getId() == id && current.getUsername().equals(username)) {

                    throw new Exception("You already have username " + username);
                }
            }
        }

        mag.createNamedQuery("User.updateUsername").setParameter("username", username).setParameter("id", id).executeUpdate();

        User user = findById(id);
        user.setUsername(username);
        mag.getTransaction().commit();
        mag.close();

    }

    public void updatePassword(String password, int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        User checkUserById = findById(id);

            if(checkUserById.getPassword().equals(password)) {

                throw new Exception("You already have password " + password);
            }

        mag.createNamedQuery("User.updatePassword").setParameter("password", password).setParameter("id", id).executeUpdate();

        User user = findById(id);
        user.setPassword(password);
        mag.getTransaction().commit();
        mag.close();

    }

    public void updateAddress(String address, int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        User checkUserById = findById(id);

        List<User> allUsers = findAll();
        for (User current : allUsers) {
                if (current.getId() == id && current.getAddress().equals(address)) {

                    throw new Exception("You have already introduced address " + address);
                }
            }

        mag.createNamedQuery("User.updateAddress").setParameter("address", address).setParameter("id", id).executeUpdate();

        User user = findById(id);
        user.setAddress(address);
        mag.getTransaction().commit();
        mag.close();

    }

    public void updateTelephone(String telephone, int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        User checkUserById = findById(id);

        if(checkUserById.getTelephone().equals(telephone)) {

            throw new Exception("You have already introduced number " + telephone);
        }

        mag.createNamedQuery("User.updateTelephone").setParameter("telephone", telephone).setParameter("id", id).executeUpdate();

        User user = findById(id);
        user.setTelephone(telephone);
        mag.getTransaction().commit();
        mag.close();

    }

    public void updateType(String type, int id) throws Exception {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        mag.createNamedQuery("User.updateType").setParameter("type", type).setParameter("id", id).executeUpdate();

        User user = findById(id);
        user.setType(type);
        mag.getTransaction().commit();
        mag.close();

    }

    public void remove(int id) {
        EntityManager mag = ManagerFactorySingleton.getFactory().createEntityManager();
        mag.getTransaction().begin();

        NeederRepo n = new NeederRepo();
        User u = (User) mag.createNamedQuery("User.findById").setParameter("id", id).getResultList().get(0);

        n.remove(id);
        mag.remove(u);
        mag.getTransaction().commit();
        mag.close();

    }







}



