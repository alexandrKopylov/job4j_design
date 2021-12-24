package ru.job4j.block5.tdd;

import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CinemaTest {


    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.DECEMBER, 16, 21, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void whenNotBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.DECEMBER, 16, 21, 0);
        cinema.buy(account, 1, 1, date);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Test
    public void notFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(Collections.emptyList()));
    }


    public interface Session {
    }

    public interface Account {
    }

    public interface Ticket {
    }


    public interface Cinema {
        List<Session> find(Predicate<Session> filter);

        Ticket buy(Account account, int row, int column, Calendar date);

        void add(Session session);
    }

    public class AccountCinema implements Account {
    }

    public class Cinema3D implements Cinema {

        @Override
        public List<Session> find(Predicate<Session> filter) {
            return null;
        }

        @Override
        public Ticket buy(Account account, int row, int column, Calendar date) {
            return null;
        }

        @Override
        public void add(Session session) {

        }
    }

    public class Ticket3D implements Ticket {

    }

    public class Session3D implements Session {

    }

}