/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entitybeans.Users;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sessionbeans.AccountSessionFacade;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class AuthenticationBean {

    @EJB
    AccountSessionFacade accountFacade;

    private Users newUser = new Users();
    
    /**
     * Creates a new instance of AuthenticationBean
     */
    public AuthenticationBean() {
    }

    public void loginUser() {
        loginUser(newUser.getUsername(), newUser.getPassword());
    }
    
    public void loginUser(String username, String password) {
        Users user = accountFacade.loginUser(username, password);
        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Incorrect login or password"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Logged In Successfully!"));
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.setAttribute("user", user);
            newUser = user;
        }
    }

    public boolean isLoggedIn() {
        LocalDateTime time = LocalDateTime.now();
        return (time.getMinute() % 2 == 0);
    }

    public Users getNewUser() {
        return newUser;
    }
}
