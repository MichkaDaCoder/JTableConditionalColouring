package jtableconditionalcolouring.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import jtableconditionalcolouring.utils.JFrameUtils;

/**
 * GenericDAO.java: abstract generic class which contains all CRUD operations.
 * All implementation classes inherit from it.
 * @author MichkaDaCoder
 * @param <T>
 */
public abstract class GenericDAO<T> implements Serializable {

    EntityManagerFactory emf;
    EntityManager em;

    Properties prop=new Properties();
    private final Class<T> entityClass;
    InputStream is;
    final String PROPERTIES_FILE="/jtableconditionalcolouring/config/params";
    
    
    /**
     * Default constructor of the class.
     * @param entityClass 
     */
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Getter of EntityManagerFactory object
     * @return EntityManagerFactory
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * Setter of EntityManagerFactory object.
     * @param emf 
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Getter of EntityManager object.
     * @return <b>EntityManager</b>
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * Setter of EntityManager object.
     * @param em 
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Getter of the template class classEntite
     * @return
     */
    public Class<T> getClasseEntite() {
        return entityClass;
    }
    
    /**
     * Initialize a new connection to SQLite Database.
     * @throws java.io.IOException
     */
    public void connexion() throws IOException{
        try {
        JFrameUtils.loadConfigFile();
        }
        catch(IOException |NullPointerException ex) {
            JFrameUtils.showErrorMessage(ex.getMessage(), "Error");
        }
        emf = Persistence.createEntityManagerFactory(JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "PERSISTENCE_NAME"));
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    /**
     * Persists a new entity class to database.
     * @param ettClass 
     */
    public void create(T ettClass) {
        if(em.getTransaction()==null) {
        this.em.getTransaction().begin();
        }
        this.em.persist(ettClass);
        this.em.flush();
        this.em.getTransaction().commit();
    }
    
    /**
     * Deletes an existing entity.
     * @param ettClass 
     */
    public void delete(T ettClass) {
        this.em.remove(ettClass);
        this.em.flush();
    }
    
    /**
     * Updates an existing Entity Class.
     * @param ettClass
     * @return T
     */
    public T update(T ettClass) {
        return this.em.merge(ettClass);
    }
    
    /**
     * Lists all existing objects.
     * @return List
     */
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
    /**
     * Returns one entity according of its given <b>NamedQuery</b>, and given parameters.
     * @param namedQuery
     * @param parameters
     * @return ettClass
     */
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
        try {
            Query query = em.createNamedQuery(namedQuery);
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No results found for the named query: " + namedQuery);
        } catch (Exception e) {
            System.out.println("An error occured trying to execute this named query: " + e.getMessage());
        }
        return result;
    }
    
    /**
     * Lists an entity object according to its given ID.
     * @param id
     * @return ettClass
     */
    public T find(int id) {
        return em.find(entityClass, id);
    }
   
    /**
     * Maps given parameters to the <b>NamedQuery</b> ones.
     * @param query
     * @param parameters 
     */
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    
    /**
     * Returns the number of a given entity object
     * @return int
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}

