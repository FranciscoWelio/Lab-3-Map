package com.sistemaacademico;


public class Main {
    public static void main(String[] args) {
        ControleAcademico sistema = new ControleAcademico();

        Professor prof1 = sistema.adicionarProfessor("Dr. Silva", 1);
        Professor prof2 = sistema.adicionarProfessor("Dra. Souza", 2);

        Aluno aluno1 = sistema.adicionarAluno("Carlos", 101);
        Aluno aluno2 = sistema.adicionarAluno("Ana", 102);
        Aluno aluno3 = sistema.adicionarAluno("Mariana", 103);

        Disciplina disciplina1 = sistema.adicionarDisciplina("Matemática", prof1, "08:00 - 10:00");
        Disciplina disciplina2 = sistema.adicionarDisciplina("História", prof2, "10:00 - 12:00");
        Disciplina disciplina3 = sistema.adicionarDisciplina("Física", prof1, "14:00 - 16:00");



        sistema.adicionarRDM(aluno1, disciplina1);
        sistema.adicionarRDM(aluno1, disciplina2);
        sistema.adicionarRDM(aluno2, disciplina1);
        sistema.adicionarRDM(aluno3, disciplina3);

        RelatorioCA.imprimirInformacoes(sistema);
    }
}
