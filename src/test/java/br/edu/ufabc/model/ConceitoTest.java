package br.edu.ufabc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConceitoTest {

    @Test
    public void p1_deve_valer_40_porcento_da_nota() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(10.0);
        Prova p2 = new Prova(0.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        Double notaFinal = conceito.getNotaFinal();

        // Espero que
        assertEquals(4.0, notaFinal, 0.001);
    }

    @Test
    public void p2_deve_valer_60_porcento_da_nota() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(0.0);
        Prova p2 = new Prova(10.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        Double notaFinal = conceito.getNotaFinal();

        // Espero que
        assertEquals(6.0, notaFinal, 0.001);
    }

    @Test
    public void nota_final_abaixo_de_4_deve_ter_conceito_final_f() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(9.0);
        Prova p2 = new Prova(0.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        char conceitoFinal = conceito.getConceitoFinal();

        // Espero que
        assertEquals('F', conceitoFinal);
    }

    @Test
    public void nota_final_entre_4_e_5_deve_ter_nota_final_d() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(10.0);
        Prova p2 = new Prova(1.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        char conceitoFinal = conceito.getConceitoFinal();

        // Espero que
        assertEquals('D', conceitoFinal);
    }

    @Test
    public void nota_final_entre_5_e_7_deve_ter_nota_final_c() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(10.0);
        Prova p2 = new Prova(3.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        char conceitoFinal = conceito.getConceitoFinal();

        // Espero que
        assertEquals('C', conceitoFinal);
    }

    @Test
    public void nota_final_entre_7_e_9_deve_ter_nota_final_b() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(10.0);
        Prova p2 = new Prova(6.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        char conceitoFinal = conceito.getConceitoFinal();

        // Espero que
        assertEquals('B', conceitoFinal);
    }

    @Test
    public void nota_final_acima_de_9_deve_ter_nota_final_a() {
        // Dado que
        Aluno aluno = new Aluno("21006012");
        Prova p1 = new Prova(10.0);
        Prova p2 = new Prova(9.0);
        Disciplina disciplina = new Disciplina("abc-123");
        Conceito conceito = new Conceito(aluno, p1, p2, disciplina);

        // Quando
        char conceitoFinal = conceito.getConceitoFinal();

        // Espero que
        assertEquals('A', conceitoFinal);
    }

}
