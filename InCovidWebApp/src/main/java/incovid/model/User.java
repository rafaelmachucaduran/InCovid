package incovid.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    private String email;

    private boolean active;

    private String roles = "";

    private String permissions = "";


    public User(String username, String password, String roles, String permissions, boolean active, String email){
        this.username = username.toUpperCase();
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = active;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.username = username.toUpperCase();
        this.password = password;
        this.email = email;
        roles = "USER";
        active = true;
    }

    public User(){}

    public long getId() {
        return id;
    }
    public void setId(long id){this.id = id;}
    public void setPassword(String password){this.password = password;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getActive() {
        return active;
    }
    public String getMail() {
        return email;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
    public void activarUser(){
        if(active == false) active = true;
        else active = false;
    }
    public String toString (){
        return "Username: "+username+", Password: "+password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
