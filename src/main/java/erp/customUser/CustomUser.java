package erp.customUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CustomUser {

    @Id
    @GeneratedValue
    private long id;

    private String password;

    private int privilegeLevel;
    private String name;

    public CustomUser(String password, int privilegeLevel, String name) {
        this.password = password;
        this.privilegeLevel = privilegeLevel;
        this.name = name;
    }

    public CustomUser() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(int privilege) {
        this.privilegeLevel = privilege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", privilegeLevel=" + privilegeLevel +
                ", name='" + name + '\'' +
                '}';
    }
}
