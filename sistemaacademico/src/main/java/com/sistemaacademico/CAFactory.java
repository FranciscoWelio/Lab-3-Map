package com.sistemaacademico;

public class CAFactory {
    public static ControleAcademico criarSistemaAcademico() {
        return new ControleAcademico();
    }

    public static Professor criarProfessor(String nome, int id) {
        return new Professor(id, nome);
    }

    public static Aluno criarAluno(String nome, int id) {
        return new Aluno(id, nome);
    }

    public static Disciplina criarDisciplina(String nome, Professor professor, String horario) {
        return new Disciplina(nome, horario, professor);
    }
}
