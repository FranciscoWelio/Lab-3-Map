package com.sistemaacademico;

import java.util.*;


public class Aluno {
	private int id;
    private String nome;
    private List<Disciplina> disciplinas;
    
    public Aluno(int id, String nome) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do aluno deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode estar vazio ou ser nulo.");
        }

        this.id = id;
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new NullPointerException("Erro: Disciplina inválida (nula).");
        }
        disciplinas.add(disciplina);
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public String getHorario() {
        if (disciplinas.isEmpty()) {
            throw new IllegalStateException("O aluno não está matriculado em nenhuma disciplina.");
        }
        Set<String> horarios = new LinkedHashSet<>();
        for (Disciplina disciplina : disciplinas) {
            horarios.add(disciplina.getHorario());
        }
        return String.join(", ", horarios);
    }
}
