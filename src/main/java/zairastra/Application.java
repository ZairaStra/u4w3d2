package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.EventsDAO;
import zairastra.entities.Event;
import zairastra.entities.EventType;
import zairastra.exceptions.NotFound;

import java.time.LocalDate;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); //è LUI A GESTIRE LE RELAZIONI COL DB TRAMITE I METODI IN EVENTSDAO
        EventsDAO ed = new EventsDAO(em);

        //CREO UNA SERIE DI EVENTI - come controllo nel programma per il db???
        //vai in pgAdmin->tables->events->tasto dx->view/edit data
        Event matrimonio = new Event("Matrimonio Virgi", LocalDate.of(2025, 6, 28), "Matrimonio a Torino", EventType.PUBLIC, 134);
        Event concerto = new Event("Concerto in Sila", LocalDate.of(2025, 8, 3), "BeAlternativeFest", EventType.PUBLIC, 789);
        Event controllo = new Event("Mappatura nei", LocalDate.of(2025, 7, 6), "Appuntamento dermatologico", EventType.PRIVATE, 2);
        Event cena = new Event("Cena a La vela", LocalDate.of(2025, 9, 3), "Cena con Clara, Paolo e Agata", EventType.PRIVATE, 4);
        //SALVO GLI EVENTI - SE NON USO SAVEEVENT NON SUCCEDE NIENTE ALLA TABELLA
        ed.saveEvent(matrimonio);
        ed.saveEvent(concerto);
        ed.saveEvent(controllo);
        ed.saveEvent(cena);

        //CERCO PER ID, STAMPO e CANCELLO

        //1
        try {
            Event firstEventFound = ed.getById(5);
            System.out.println(firstEventFound.toString());
            ed.deleteEvent(firstEventFound);

        } catch (NotFound ex) {
            System.out.println(ex.getMessage());
        }

        //2
        try {
            Event secondEventFound = ed.getById(7);
            System.out.println(secondEventFound.toString());
            ed.deleteEvent(secondEventFound);

        } catch (NotFound ex) {
            System.out.println(ex.getMessage());
        }

        //3
        try {
            Event thirdEventFound = ed.getById(11);
            System.out.println(thirdEventFound.toString());
            ed.deleteEvent(thirdEventFound);

        } catch (NotFound ex) {
            System.out.println(ex.getMessage());
        }

        //RICORDATI DI CHIUDERE DOPO CHE LO USI
        em.close();
        emf.close();
    }
}
