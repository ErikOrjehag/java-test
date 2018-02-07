package main;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
    void getFirstElement() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn(5);
        Main main = new Main();
        assertEquals(5, main.getFirstElement(mockedList), "Should return first element of list");
        verify(mockedList).get(0);
    }

    @Test
    void sayHello() {
        Main main = new Main();
        assertEquals("Hello Erik!", main.sayHello("Erik"), "Should say hello to Erik");
    }

    @Test
    void testTest() {
        assertTrue(1 == 1);
    }
}