package MainApp;
//DISPLAY USER ACCOUNT
import domain.Account;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp3 {
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

        //DISPLAY USER ACCOUNT

        User obj=ses.get(User.class,1);
        System.out.println("User name: "+obj.getUserName());
        List<Account>data=obj.getAccountList();
        for (Account a:data){
            System.out.println("Account no: "+a.getAcNo());
            System.out.println("Account type: "+a.getAcType());
            System.out.println("==============================");
        }

    }
}
