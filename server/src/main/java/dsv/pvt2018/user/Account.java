package dsv.pvt2018.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "salt", nullable = false, length = 32)
    private String salt;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    Account() { }

    public Account(String email, String clearPassword, User user) {
        System.out.println("Constructing account for user (" + user.getUserId() + ", " + user.getUsername() + ")");
        this.user = user;
        this.email = email;
        this.salt = createSalt();
        this.password = encryptPassword(clearPassword, this.salt);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected String createSalt() {
        // TODO
        return "1234567890abcdefghiklmnopqrstuvw";
    }

    public static String encryptPassword(String clearPassword, String salt) {
        // TODO
        return clearPassword;
    }

    @Override
    public String toString() {
        return "{ \"Account userId\" : " + userId +
                ", \"email\" : \"" + email + "\"" +
                ", \"salt\" : \"" + salt + "\"" +
                ", \"password\" : " + password + "\"" +
                "}";
    }
}
