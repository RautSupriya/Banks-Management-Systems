package MainApp;

import domain.Account;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//OLD USER NEW ACCOUNT
public class MainApp2 {
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

        //OLD USER WITH NEW ACCOUNT
        User s1=ses.get(User.class,1);
        Account a1=new Account();
        a1.setAcNo(767654);
        a1.setAcType("Loan");

        s1.addAccount(a1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("RECORD INSERTED");
    }
}
