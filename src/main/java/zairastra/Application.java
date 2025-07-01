package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.EventsDAO;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("u4w3d2pu")

    public static void main(String[] args) {
        EntityManager em= emf.createEntityManager(); //è LUI A GESTIRE LE RELAZIONI COL DB TRAMITE I METODI IN EVENTSDAO
        EventsDAO ed=new EventsDAO(em);

        //RICORDATI DI CHIUDERE DOPO CHE LO USI
        em.close();
        emf.close();
    }
}
