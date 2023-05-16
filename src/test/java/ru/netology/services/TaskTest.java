package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testMatchesSimpleTaskWhenTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesSimpleTaskWhenFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("другу");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesEpicWhenTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesEpicWhenTrue2() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesEpicWhenFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Сыр");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesMeetingWhenTrue() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("3й версии приложения");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesMeetingWhenFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("2й версии приложения");
        Assertions.assertFalse(actual);

    }

    @Test
    public void testMatchesMeetingProjectWhenTrue() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("НетоБанка");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testMatchesMeetingProjectWhenFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("НедоБанка");
        Assertions.assertFalse(actual);
    }
}