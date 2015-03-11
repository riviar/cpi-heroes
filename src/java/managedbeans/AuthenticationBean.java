/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entitybeans.Users;
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
        // lookup username/password combination in database
        Users user = accountFacade.loginUser(username, password);
        // if no matching user found, show error message
        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Incorrect login or password"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Logged In Successfully!"));
            // get current session
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            // set user attribute of session
            session.setAttribute("user", user);
            newUser = user;
        }
    }

    public boolean isLoggedIn() {
        //gets current session
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        //returns true if user attribute for current session is not null
        return (session.getAttribute("user") != null);        
    }

    public Users getNewUser() {
        return newUser;
    }
    
    public void registerNewUser() {
        String password = newUser.getPassword();
        // check if user with specified login already exists
        if (accountFacade.userExists(newUser.getUsername())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("This username is already registered!"));
        } else {
            accountFacade.registerUser(newUser);
            this.loginUser(newUser.getUsername(), newUser.getPassword());
        }
    }
}
