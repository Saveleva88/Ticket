package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1,2500,"DME","LED",120); //из Домодедово до СПб
    private Ticket second = new Ticket(2,18000,"LED","KJA",300); //из Спб до Красноярска
    private Ticket third = new Ticket(3,3500,"KJA","OVB",100); // из Красноясрка до Новосибирска
    private Ticket fourth = new Ticket(4,8000,"OVB","DME",240); //из Новосибирска до Домодедово
    private Ticket fifth = new Ticket(5,15000,"DME","KJA",280); //из Домодедово до Красноярска
    private Ticket sixth = new Ticket(6,2000,"DME","LED",130); //из Домодедово до СПб
    private Ticket seventh = new Ticket(7,35000,"SVO","BKK", 600); //из Шереметьево до Банкока

    @Test
    public void shouldFindByAirports() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        Ticket[] actual = manager.searchBy("DME", "LED");
        Ticket[] expected = new Ticket[]{sixth, first};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFindByAirports2() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        Ticket[] actual = manager.searchBy("SVO", "BKK");
        Ticket[] expected = new Ticket[]{seventh};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldNotFind() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        Ticket[] actual = manager.searchBy("SVO","OVB");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(expected, actual);
    }

}