package entity;

/**
 * Created by Vinty on 07.04.2017.
 */
public class Users {
    private long id;
    private String nameUser;
    private String familyUser;
    private String eMailUser;
    private String passwordUser;
    private Privileges privileges;

    public Users(long id, String nameUser, String familyUser, String eMailUser, String passwordUser, Privileges privileges) {
        this.id = id;
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privileges = privileges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getFamilyUser() {
        return familyUser;
    }

    public void setFamilyUser(String familyUser) {
        this.familyUser = familyUser;
    }

    public String geteMailUser() {
        return eMailUser;
    }

    public void seteMailUser(String eMailUser) {
        this.eMailUser = eMailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }
}