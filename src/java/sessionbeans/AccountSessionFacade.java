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
            return (Users)q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    } 
    
}
