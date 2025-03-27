package com.sistemaacademico;

public class RDM {
    private Aluno aluno;
    private Disciplina disciplina;

    public RDM(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        aluno.adicionarDisciplina(disciplina);
        disciplina.adicionarAluno(aluno);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
