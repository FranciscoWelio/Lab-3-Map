package com.sistemaacademico;

import java.util.*;

public class Professor {

	private int id;
    private String nome;
    private List<Disciplina> disciplinas;
    
    public Professor(int id, String nome) {
	if (id <= 0) {
            throw new IllegalArgumentException("O ID do professor deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do professor não pode ser nulo ou vazio.");
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
            throw new NullPointerException("A disciplina não pode ser nula.");
        }
        disciplinas.add(disciplina);
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public String getHorario() {
        if (disciplinas.isEmpty()) {
            throw new IllegalStateException("O professor não possui disciplinas cadastradas.");
        }
        Set<String> horarios = new LinkedHashSet<>();
        for (Disciplina disciplina : disciplinas) {
            horarios.add(disciplina.getHorario());
        }
        return String.join(", ", horarios);
    }
} 
