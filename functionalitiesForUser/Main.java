import entity.Needer;
import entity.User;
import repository.NeederRepo;
import repository.UserRepo;
import root.ManagerFactorySingleton;

import java.lang.management.ManagementFactory;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //un user
        User u = new User(1);
        u.setUsername("ip");
        u.setPassword("wrv");
        u.setFirstName("erbb");
        u.setLastName("verv");
        u.setAddress("brfv");
        u.setTelephone("098765");
        u.setDate("oiuytr");

        //il bag in baza de date
        UserRepo r = new UserRepo();
        r.create(u);

        //un needer
        Needer needer1 = new Needer(1,true);

        //il bag in baza de date
        NeederRepo n = new NeederRepo();
        n.create(needer1);

        ManagerFactorySingleton.closeFact();

    }
}
