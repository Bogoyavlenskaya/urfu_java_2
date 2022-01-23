package Service;

import Entity.EducationalInstitution;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EducationalInstitutionService {

    static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager=entityManagerFactory.createEntityManager();

    public static boolean createNewEducationalInstitution(String number, String address){
        entityManager.getTransaction().begin();
        EducationalInstitution educationalInstitution=new EducationalInstitution();
        educationalInstitution.setAddress(address);
        educationalInstitution.setNumber(address);
        entityManager.persist(educationalInstitution);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public List<EducationalInstitution> getAllEducationalInstitution(){
        entityManager.getTransaction().begin();
        List<EducationalInstitution> educationalInstitutionList=entityManager.createQuery("SELECT e FROM EducationalInstitution e",EducationalInstitution.class).getResultList();
        return educationalInstitutionList;
    }
}
