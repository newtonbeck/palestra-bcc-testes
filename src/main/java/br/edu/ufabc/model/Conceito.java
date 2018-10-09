package br.edu.ufabc.model;

public class Conceito {

    private Aluno aluno;

    private Prova p1;

    private Prova p2;

    private Disciplina disciplina;

    public Conceito(Aluno aluno, Prova p1, Prova p2, Disciplina disciplina) {
        this.aluno = aluno;
        this.p1 = p1;
        this.p2 = p2;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Prova getP1() {
        return p1;
    }

    public Prova getP2() {
        return p2;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Double getNotaFinal() {
        return 0.4 * p1.getNota() + 0.6 * p2.getNota();
    }

    public char getConceitoFinal() {
        double notaFinal = getNotaFinal();
        if (notaFinal < 4) {
            return 'F';
        } else if (notaFinal < 5) {
            return 'D';
        } else if (notaFinal < 7) {
            return 'C';
        } else if (notaFinal < 9) {
            return 'B';
        } else {
            return 'A';
        }
    }
}
