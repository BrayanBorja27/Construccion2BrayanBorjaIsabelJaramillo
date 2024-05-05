package tdea.construccion2.appVeterinary.Dto;

import tdea.construccion2.appVeterinary.Models.Session;

public class SessionDto {

    private long id;
    private String userName;
    private String role;

    public SessionDto(Session session) {
    	this.id = session.getId();
		this.userName = session.getUserName();
		this.role = session.getRol();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
