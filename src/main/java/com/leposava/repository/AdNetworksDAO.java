package com.leposava.repository;

import com.leposava.model.AdNetwork;
import com.leposava.model.Detail;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import javax.naming.NamingException;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdNetworksDAO {

    private static AdNetworksDAO instance;

    protected AdNetworksDAO() {
        // initialization
    }

    public static AdNetworksDAO getInstance() {
        if (instance == null) {
            instance = new AdNetworksDAO();
        }
        return instance;
    }

    private EntityManager entityManager;

    protected EntityManager getEntityManager() throws NamingException {
        if(this.entityManager == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                SQLServerDriver driver = new SQLServerDriver();


                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ad");
                EntityManager em = emf.createEntityManager();
                em.setFlushMode(FlushModeType.AUTO);

                this.entityManager = em;
                return em;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  this.entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        if( this.entityManager == null)
            try {
                this.entityManager = getEntityManager();
            }catch (NamingException e){
                e.printStackTrace();
            }
    }


    public <T> T persist(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            T entity_r =  getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return  entity_r;
        }catch (NamingException e){
            e.printStackTrace();
        }
        return null;
    }


    public <T> T find(Class<? extends T> entityClass, Object primaryKey) {
        try{
            return getEntityManager().find(entityClass, primaryKey);

        }catch (NamingException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<AdNetwork> getAllNetworks(String order) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdNetwork> cq = cb.createQuery(AdNetwork.class);
        Root<AdNetwork> actor = cq.from(AdNetwork.class);
        if("desc".equals(order)){
            cq.orderBy(cb.desc(actor.get("name")));
        }else{
            cq.orderBy(cb.asc(actor.get("name")));
        }
        TypedQuery<AdNetwork> tp = entityManager.createQuery(cq);

        return tp.getResultList();
    }

    public AdNetwork saveNetwork(AdNetwork adNetwork) {
        Detail  detail =  persist(adNetwork.getDetails());
        adNetwork.setDetails(detail);
        return  persist(adNetwork);

    }

    public AdNetwork updateNetwork(AdNetwork adNetwork) {
        AdNetwork updatedNetwork = find(AdNetwork.class, adNetwork.getId());
        updatedNetwork.setName(adNetwork.getName());
        updatedNetwork.setDescription(adNetwork.getDescription());
        Detail  detail =  persist(adNetwork.getDetails());
        updatedNetwork.setDetails(detail);
        return  persist(adNetwork);

    }
}
