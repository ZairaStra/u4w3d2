package zairastra.dao;

import jakarta.persistence.EntityManager;

public class EventsDAO {
    //ENTITYMANAGER SERVE A GESTIRE I METODI TUTTI NEL DAO PASSANDOLA COME PARAMETRO IN MODO DA LASCIARE PULITO IL MAIN
    //E NON RISCRIVERE I METODI OGNI VOLTA CHE VOGLIO RICHIAMARLI SU UN ELEMENTO DELLA TABELLA
    private EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {

    }
}
