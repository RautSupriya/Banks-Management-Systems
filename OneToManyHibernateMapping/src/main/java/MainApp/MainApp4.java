package MainApp;

import domain.Account;
import domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp4 {
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

        Criteria crt=ses.createCriteria(User.class);
        List<User>data=crt.list();
        //FIRST USER WILL BE FIND
        for (User u1:data){
            System.out.println("User name: "+u1.getUserName());
            List<Account>data2=u1.getAccountList();
            //DATA OF THIS USER
            for (Account a:data2)
            {
                System.out.println("Account Number: "+a.getAcNo());
                System.out.println("Account Type: "+a.getAcType());

            }
            System.out.println("=================================");
        }

}
}
