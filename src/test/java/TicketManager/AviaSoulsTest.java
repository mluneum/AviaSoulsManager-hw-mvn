package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void sortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18);
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12);
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12);
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Saratov", "Samara");
        Ticket[] expected = {ticket3, ticket5, ticket7, ticket2, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18);
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12);
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12);
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SPB", "Samara");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18);
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12);
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12);
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SPB", "Moscow");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18); //7
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9); //2
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12); //3
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12); //1
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12); //8
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Saratov", "Samara", comparator);
        Ticket[] expected = {ticket7, ticket3, ticket5, ticket2, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18);
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12);
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12);
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "Samara", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saratov", "Moscow", 140, 10, 12);
        Ticket ticket2 = new Ticket("Saratov", "Samara", 350, 11, 18);
        Ticket ticket3 = new Ticket("Saratov", "Samara", 150, 7, 9);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 250, 11, 14);
        Ticket ticket5 = new Ticket("Saratov", "Samara", 200, 9, 12);
        Ticket ticket6 = new Ticket("Moscow", "Samara", 210, 9, 12);
        Ticket ticket7 = new Ticket("Saratov", "Samara", 340, 11, 12);
        Ticket ticket8 = new Ticket("Saratov", "Samara", 450, 4, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "Moscow", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
}

