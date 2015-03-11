/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Users;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Facade for managing login sessions
 *
 * @author Matthew Robinson
 */
@Stateful
public class AccountSessionFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "RNAseqPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountSessionFacade() {
        super(Users.class);
    }

    public Users loginUser(String username, String password) {
        Query q = em.createQuery("SELECT u FROM Users u WHERE u.username=:username AND u.password=:password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            return (Users) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public boolean userExists(String username) {
        Query q = em.createQuery("SELECT u FROM Users u WHERE u.username=:username AND u.password=:password");
        q.setParameter("username", username);
        try {
            // return true if any record matching username is found in database
            // can getSingleResult ever return null and not throw NoResultException?
            if (q.getSingleResult() != null) {
                return true;
            }
        } catch (NoResultException ex) {
            return false;
        }
        // should never reach here, so trap with assert, but return true anyway as IDE complains otherwise
        assert false;
        return true;
    }

    public void registerUser(Users newUser) {
        create(newUser);
    }

}
