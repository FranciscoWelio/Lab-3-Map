package com.sistemaacademico;
import java.util.*;

// Classe responsável por gerenciar o sistema acadêmico
class ControleAcademico {
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<RDM> rdms;

    public ControleAcademico() {
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.rdms = new ArrayList<>();
    }

    public Professor adicionarProfessor(String nome, int id) {
        Professor professor = new Professor(id, nome);
        professores.add(professor);
        return professor;
    }

    public Aluno adicionarAluno(String nome, int id) {
        Aluno aluno = new Aluno(id, nome);
        alunos.add(aluno);
        return aluno;
    }

    public Disciplina adicionarDisciplina(String nome, Professor professor, String horario) {
        Disciplina disciplina = new Disciplina(nome, horario, professor);
        disciplinas.add(disciplina);
        professor.adicionarDisciplina(disciplina);
        return disciplina;
    }

    public RDM adicionarRDM(Aluno aluno, Disciplina disciplina) {
        RDM rdm = new RDM(aluno, disciplina);
        rdms.add(rdm);
        return rdm;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}