package br.edu.ufabc;

import br.edu.ufabc.db.ConceitoDao;
import br.edu.ufabc.model.Conceito;
import br.edu.ufabc.model.Disciplina;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class App {

    public static void main(String[] args) {
        get("/conceitos/:codigo_disciplina", (req, res) -> {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tests",
                    "root",
                    "");
            ConceitoDao dao = new ConceitoDao(conexao);

            String codigoDisciplina = req.params("codigo_disciplina");
            List<Conceito> conceitos = dao.listaPor(new Disciplina(codigoDisciplina));

            Map<String, Object> params = new HashMap<>();
            params.put("codigo_disciplina", codigoDisciplina);
            params.put("conceitos", conceitos);
            return new ThymeleafTemplateEngine().render(
                    new ModelAndView(params, "conceitos")
            );
        });
    }

}
