package Service;

import Entity.Child;
import Entity.EducationalInstitution;
import Entity.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChildService {
    static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager=entityManagerFactory.createEntityManager();
    public static boolean createNewChild(String fullName,Long parent_id,Long educationalInstitution_id){

        entityManager.getTransaction().begin();
        Child child=new Child();
        child.setAge(fullName);
        child.setParent(entityManager.find(Parent.class,parent_id));
        child.setEducationalinstitution(entityManager.find(EducationalInstitution.class,educationalInstitution_id));
        entityManager.persist(child);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public List<Child> getAllChildren(){
        entityManager.getTransaction().begin();
        List<Child> childList=entityManager.createQuery("SELECT e FROM Child e",Child.class).getResultList();
        return childList;
    }
}
