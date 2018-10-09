package br.edu.ufabc.db;

import br.edu.ufabc.model.Conceito;
import br.edu.ufabc.model.Disciplina;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ConceitoDaoTest {

    @Test
    public void deve_buscar_somente_alunos_da_mesma_disciplina() throws SQLException {
        // Dado que
        Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tests_test",
                "root",
                "");

        insereConceito(conexao, "12345678", 5.0, 7.0, "abc-123");
        insereConceito(conexao, "87654321", 9.0, 9.0, "def-456");

        ConceitoDao dao = new ConceitoDao(conexao);
        Disciplina disciplina = new Disciplina("abc-123");

        // Quando
        List<Conceito> conceitos = dao.listaPor(disciplina);

        // Espero que
        assertEquals(1, conceitos.size());
        assertEquals("12345678", conceitos.get(0).getAluno().getRa());

        limpaTabela(conexao);
    }

    @Test
    public void deve_retornar_uma_lista_vazia_quando_nao_tiver_nenhum_aluno_na_disciplina() throws SQLException {
        // Dado que
        Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tests_test",
                "root",
                "");

        insereConceito(conexao, "87654321", 9.0, 9.0, "def-456");

        ConceitoDao dao = new ConceitoDao(conexao);
        Disciplina disciplina = new Disciplina("abc-123");

        // Quando
        List<Conceito> conceitos = dao.listaPor(disciplina);

        // Espero que
        assertTrue(conceitos.isEmpty());

        limpaTabela(conexao);
    }

    private void insereConceito(Connection conexao, String nomeAluno, Double notaP1, Double notaP2, String codigoDisciplina) throws SQLException {
        PreparedStatement comando = conexao
                .prepareStatement("insert into conceitos(ra_aluno, nota_p1, nota_p2, codigo_disciplina) values(?, ?, ?, ?)");
        comando.setString(1, nomeAluno);
        comando.setDouble(2, notaP1);
        comando.setDouble(3, notaP2);
        comando.setString(4, codigoDisciplina);
        comando.execute();
    }

    private void limpaTabela(Connection conexao) throws SQLException {
        PreparedStatement comando = conexao
                .prepareStatement("truncate table conceitos");
        comando.execute();
    }

}