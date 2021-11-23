package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket first = new Ticket(1,2500,"DME","LED",120); //из Домодедово до СПб
    private Ticket second = new Ticket(2,18000,"LED","KJA",300); //из Спб до Красноярска
    private Ticket third = new Ticket(3,3500,"KJA","OVB",100); // из Красноясрка до Новосибирска
    private Ticket fourth = new Ticket(4,8000,"OVB","DME",240); //из Новосибирска до Домодедово

    @Test
    public void shouldSortByPrice() {
        Ticket[] expected = new Ticket[]{first,third,fourth,second};
        Ticket[] actual = new Ticket[]{first,second,third,fourth};
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }

}