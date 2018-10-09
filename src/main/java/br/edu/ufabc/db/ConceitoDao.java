package br.edu.ufabc.db;

import br.edu.ufabc.model.Aluno;
import br.edu.ufabc.model.Conceito;
import br.edu.ufabc.model.Disciplina;
import br.edu.ufabc.model.Prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConceitoDao {

    private Connection conexao;

    public ConceitoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Conceito> listaPor(Disciplina disciplina) throws SQLException {
        // Cria o comando SQL com seus parâmetros
        String sql = "select * from conceitos where codigo_disciplina = ?";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, disciplina.getCodigo());

        // Executa o comando SQL
        ResultSet resultado = comando.executeQuery();

        // Converte o resultado em objetos Java
        List<Conceito> conceitos = new ArrayList<>();

        while (resultado.next()) {
            Aluno aluno = new Aluno(resultado.getString("ra_aluno"));
            Prova p1 = new Prova(resultado.getDouble("nota_p1"));
            Prova p2 = new Prova(resultado.getDouble("nota_p2"));
            Disciplina disciplinaPorAluno = new Disciplina(resultado.getString("codigo_disciplina"));

            Conceito conceito = new Conceito(aluno, p1, p2, disciplinaPorAluno);

            conceitos.add(conceito);
        }

        return conceitos;
    }
}
