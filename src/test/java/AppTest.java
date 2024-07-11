package com.example.Application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        Application app1 = new Application();
        Application app2 = new Application();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        Application app = new Application();
        assertEquals("Hello World!", Application.getMessage());
    }
}
