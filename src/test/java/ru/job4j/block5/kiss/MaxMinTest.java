package ru.job4j.block5.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    private List<User> userList = new ArrayList<>();

    @Before
    public void setUp() {
        userList.add(new User(1, "Саша"));
        userList.add(new User(2, "Миша"));
        userList.add(new User(3, "Сергей"));
        userList.add(new User(4, "Андрей"));
    }

    @Test
    public void maxUserId() {
        MaxMin maxMin = new MaxMin();
        UserComparatorId ucid = new UserComparatorId();
        User user = maxMin.max(userList, ucid);
        assertThat(user.id, is(4));
    }

    @Test
    public void minUserId() {
        MaxMin maxMin = new MaxMin();
        UserComparatorId ucid = new UserComparatorId();
        User user = maxMin.min(userList, ucid);
        assertThat(user.id, is(1));
    }

    @Test
    public void maxUserName() {
        MaxMin maxMin = new MaxMin();
        UserComparatorName compName = new UserComparatorName();
        User user = maxMin.max(userList, compName);
        assertThat(user.name, is("Сергей"));
    }

    @Test
    public void minUserName() {
        MaxMin maxMin = new MaxMin();
        UserComparatorName compName = new UserComparatorName();
        User user = maxMin.min(userList, compName);
        assertThat(user.name, is("Андрей"));
    }
}