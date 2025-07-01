package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.EventsDAO;
import zairastra.entities.Event;
import zairastra.entities.EventType;

import java.time.LocalDate;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); //è LUI A GESTIRE LE RELAZIONI COL DB TRAMITE I METODI IN EVENTSDAO
        EventsDAO ed = new EventsDAO(em);

        //CREO UNA SERIE DI EVENTI - come controllo nel programma per il db???
        Event matrimonio = new Event("Matrimonio Virgi", LocalDate.of(2025, 6, 28), "Matrimonio a Torino", EventType.PUBLIC, 134);
        Event concerto = new Event("Concerto in Sila", LocalDate.of(2025, 8, 3), "BeAlternativeFest", EventType.PUBLIC, 789);
        Event controllo = new Event("Mappatura nei", LocalDate.of(2025, 7, 6), "Appuntamento dermatologico", EventType.PRIVATE, 2);

        //RICORDATI DI CHIUDERE DOPO CHE LO USI
        em.close();
        emf.close();
    }
}
