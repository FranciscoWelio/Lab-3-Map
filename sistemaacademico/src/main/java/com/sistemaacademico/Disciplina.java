package com.sistemaacademico;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private String nome;
    private String horario;
    private List<Aluno> alunos;
    private Professor professor;
    
    public Disciplina(String nome, String horario, Professor professor) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da disciplina não pode ser nulo ou vazio.");
        }
        if (horario == null || horario.trim().isEmpty()) {
            throw new IllegalArgumentException("O horário da disciplina não pode ser nulo ou vazio.");
        }
        if (professor == null) {
            throw new NullPointerException("A disciplina deve ter um professor associado.");
        }
        this.nome = nome;
        this.horario = horario;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public String adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new NullPointerException("O aluno não pode ser nulo.");
        }
        alunos.add(aluno);
        return "Aluno Adicionado";
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public int getNumeroDeAlunos() {
        return alunos.size();
    }
}
