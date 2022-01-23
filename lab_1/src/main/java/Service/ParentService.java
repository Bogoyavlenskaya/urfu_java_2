package Service;

import Entity.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ParentService {

    static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager=entityManagerFactory.createEntityManager();
    public static boolean createNewParent(String fullName, String address){
        entityManager.getTransaction().begin();
        Parent parent=new Parent();
        parent.setFullname(fullName);
        parent.setAddress(address);
        entityManager.persist(parent);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public List<Parent> getAllParents(){
        entityManager.getTransaction().begin();
        List<Parent> parentList=entityManager.createQuery("SELECT e FROM Parent e",Parent.class).getResultList();
        return parentList;
    }
}
