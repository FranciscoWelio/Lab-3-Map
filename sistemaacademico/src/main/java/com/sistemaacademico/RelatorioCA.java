package com.sistemaacademico;

import java.util.stream.Collectors;

public class RelatorioCA {
    public static void imprimirInformacoes(ControleAcademico sistema) {
        for (Professor professor : sistema.getProfessores()) {
            System.out.println("Disciplinas ministradas por " + professor.getNome() + ":");
            professor.getDisciplinas().forEach(d -> System.out.println("- " + d.getNome()));
            System.out.println("Horário do Professor: " + professor.getDisciplinas().stream()
                    .map(Disciplina::getHorario)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        
        for (Disciplina disciplina : sistema.getDisciplinas()) {
            System.out.println("Alunos de " + disciplina.getNome() + ":");
            disciplina.getAlunos().forEach(a -> System.out.println("- " + a.getNome()));
            System.out.println("Número de alunos na disciplina: " + disciplina.getAlunos().size());
            System.out.println();
        }
        
        for (Aluno aluno : sistema.getAlunos()) {
            System.out.println("Disciplinas do aluno " + aluno.getNome() + ":");
            aluno.getDisciplinas().forEach(d -> System.out.println("- " + d.getNome()));
            System.out.println("Horário do Aluno: " + aluno.getDisciplinas().stream()
                    .map(Disciplina::getHorario)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
    }
}

