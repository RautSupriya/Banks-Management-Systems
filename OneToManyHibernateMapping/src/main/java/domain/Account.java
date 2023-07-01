package domain;

import javax.persistence.*;

@Entity
@Table(name = "account_info")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_id")
    private int acId;
    @Column(name = "ac_no")
    private int acNo;
    @Column(name = "ac_type")
    private String acType;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="user_ref")
    private User userRef;


    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public int getAcNo() {
        return acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public User getUserRef() {
        return userRef;
    }

    public void setUserRef(User userRef) {
        this.userRef = userRef;
    }
}
