package br.edu.ufabc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {

    @Test
    public void deve_visualizar_a_pagina_da_disciplina() {
        // Dado que
        WebDriver browser = new ChromeDriver();
        String codigoDisciplina = "abc-123";

        // Quando
        browser.get("http://localhost:4567/conceitos/" + codigoDisciplina);

        // Espero que
        assertEquals("abc-123", browser.findElement(By.tagName("h1")).getText());
        assertTrue(browser.findElement(By.tagName("table")).isDisplayed());

        browser.close();
    }

    @Test
    public void deve_receber_erro_404_quando_disciplina_nao_existe() {
        // Dado que
        WebDriver browser = new ChromeDriver();
        String codigoDisciplina = "def-456";

        // Quando
        browser.get("http://localhost:4567/conceitos/" + codigoDisciplina);

        // Espero que
        assertEquals("404 Not found", browser.findElement(By.tagName("h2")).getText());

        browser.close();
    }

}
