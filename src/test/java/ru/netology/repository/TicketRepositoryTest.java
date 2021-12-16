package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, 4_500, "MOW", "KUF", 120);
    private Ticket ticket2 = new Ticket(2, 5_800, "MOW", "GOJ", 145);
    private Ticket ticket3 = new Ticket(3, 3_200, "MOW", "OGZ", 60);
    private Ticket ticket4 = new Ticket(4, 14_000, "MOW", "LED", 130);
    private Ticket ticket5 = new Ticket(5, 58_100, "MOW", "TXN", 230);
    private Ticket ticket6 = new Ticket(6, 2_800, "MOW", "KUF", 230);


    @Test
    void shouldOneTicket() {
        repository.save(ticket1);
        Ticket[] actual = repository.getAll();
        Ticket[] expected = new Ticket[]{ticket1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldTwoTickets() {
        repository.save(ticket5);
        repository.save(ticket6);
        Ticket[] actual = repository.getAll();
        Ticket[] expected = new Ticket[]{ticket5, ticket6};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveById() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.removeById(3);
        Ticket[] actual = repository.getAll();
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket4, ticket5, ticket6};
        assertArrayEquals(actual, expected);
    }
}