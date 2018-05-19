package dsv.pvt2018.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "profile", nullable = true, columnDefinition = "TEXT")
    private String profile;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public UserDetail() { }

    public UserDetail(User user) {
        System.out.println("Constructing/1 details for user (" + user.getUserId() + ", " + user.getUsername() + ")");
        this.user = user;
        this.firstName = user.getUsername();
        this.lastName = "";
        this.profile = "";
    }

    public UserDetail(String firstName, String lastName, String profile, User user) {
        System.out.println("Constructing/4 details for user (" + user.getUserId() + ", " + user.getUsername() + ")");
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profile = profile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

/*
    @Override
    public String toString() {
        return String.format("UserDetail[id=%1d, firstName='%2s', lastName='%3s', profile='%4s']",
                userId, firstName, lastName, profile);
    }
*/

    @Override
    public String toString() {
        return "{\"UserDetail userId\" : " + userId +
                ", \"firstName\" : " + firstName + "\"" +
                ", \"lastName\" : " + lastName + "\"" +
                ", \"profile\" : " + profile + "\"" +
                "}";
    }
}
