package MainApp;

import domain.Account;
import domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

//TO FIND THE WHICH USER HAVING MORE THAN TWO ACCOUNTS
public class MainApp5 {
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

        //TO FIND THE WHICH USER HAVING MORE THAN TWO ACCOUNTS

        Criteria crt= ses.createCriteria(User.class);
        List<User>data=crt.list();
        for (User u1 : data){
            List<Account>data2=u1.getAccountList();
            if(data2.size()>2){
                System.out.println("User name: "+u1.getUserName());
                //DATA OF THIS USER
                for (Account a:data2){
                    System.out.println("Account Number: "+a.getAcNo());
                    System.out.println("Account Type: "+a.getAcType());

                }
                System.out.println("=================================");
            }
        }

    }
}
