package MainApp;

import domain.Account;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//NEW USER NEW ACCOUNT
public class MainApp1 {
    public static void main(String[] args) {
        //DECLARE THE RESOURCES
        Configuration cfg = null;
        Session ses = null;
        SessionFactory factory = null;
        Transaction tx = null;

        //CREATE THE OBJECT
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Account.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //NEW USER NEW ACCOUNT

        //CREATE OBJECT USER
        User u1=new User();
        u1.setUserName("Anushka");
        u1.setAge(33);
        u1.setContactNo(987656768);

        //CREATE THE OBJECT OF ACCOUNT
        Account a1=new Account();
        a1.setAcNo(765094);
        a1.setAcType("Saving");
        a1.setUserRef(u1);

        //ANOTHER OBJECT
        Account a2=new Account();
        a2.setAcNo(43512);
        a2.setAcType("Current");
        a2.setUserRef(u1);

        u1.addAccount(a1);
        u1.addAccount(a2);

        tx= ses.beginTransaction();
        ses.save(u1);
        tx.commit();
        System.out.println("ACCOUNT CREATED SUCCESSFULLY");

    }
}
