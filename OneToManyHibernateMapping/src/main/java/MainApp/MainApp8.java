package MainApp;
//WRITE A PROGRAM TO DELETE USER
import domain.Account;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp8 {
    public static void main(String[] args) {
        //DECLARE THE RESOURCES
        Configuration cfg = null;
        Session ses = null;
        SessionFactory factory = null;
        Transaction tx = null;

        //CREATE THE OBJECT
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg.addAnnotatedClass(Account.class);
        cfg.addAnnotatedClass(User.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //WRITE A PROGRAM TO DELETE USER

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id: ");
        int id=sc.nextInt();
        //CREATE A OBJECT
        User u1=ses.get(User.class,id);
        if (u1!=null)
        {
            tx= ses.beginTransaction();
            ses.delete(u1);
            tx.commit();
            System.out.println("USER DELETED ALONG WITH ACCOUNT SUCCESSFULLY");
        }
        else {
            System.out.println("INVALID USER ID");
        }
    }
}
