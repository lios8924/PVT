package dsv.pvt2018.user;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 32)
    private String userName;

    @Column(name = "creation_time")
    private Timestamp creationTime;

    @OneToOne(mappedBy = "user", optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    @OneToOne(mappedBy = "user", optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetail userDetail;

    User() { }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.account = new Account(email, password, this);
        this.userDetail = new UserDetail(this);
//        Date currentDate = new Date();
//        this.creationTime = new Timestamp(currentDate.getTime());
        this.creationTime = new Timestamp((new Date()).getTime());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String name) {
        this.userName = name;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        System.out.println("Setting account for user (" + userId + ", " + userName + ")");
        if (account == null) {
            if (this.account != null) {
                this.account.setUser(null);
            }
        } else {
            account.setUser(this);
        }
        this.account = account;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        System.out.println("Setting details for user (" + userId + ", " + userName + ")");
        if (userDetail == null) {
            if (this.userDetail != null) {
                this.userDetail.setUser(null);
            }
        } else {
            userDetail.setUser(this);
        }
        this.userDetail = userDetail;
    }

    public String getPassword() {
        return account.getPassword();
    }

    public String getSalt() {
        return account.getSalt();
    }

/*
    public String toString() {
        return String.format("User[id=%1d, userName='%2s', creationTime='%3tF %3tT', accountDetails=%4s, profileDetails=%5s]",
                userId, userName, creationTime, account.toString(), userDetail.toString());
    }
*/

    @Override
    public String toString() {
        return "{ \"User userId\" : " + userId +
                ", \"userName\" : \"" + userName + "\"" +
                ", \"creationTime\" : \"" + creationTime + "\"" +
                ", \"account\" : " + account.toString() +
                ", \"userDetail\" : " + userDetail.toString() +
                "}";
    }
}
