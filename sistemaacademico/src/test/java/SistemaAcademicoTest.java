import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sistemaacademico.Aluno;
import com.sistemaacademico.Disciplina;
import com.sistemaacademico.Professor;

public class SistemaAcademicoTest {

    @Test
    void testConstrutorDisciplina() throws Exception{
        Professor prof1 = new Professor(1, "Dr. Silva");
        Disciplina d1 = new Disciplina("Matemática", "08:00 Seg", prof1);

        assertEquals("Matemática", d1.getNome());
        assertEquals("08:00 Seg", d1.getHorario());
        assertEquals("Dr. Silva", d1.getProfessor().getNome());
    }

    @Test
    void testConstrutorProfessor() throws Exception{
        Professor prof1 = new Professor(1, "Juresvaldo");
        
        assertEquals("Juresvaldo", prof1.getNome());
        assertEquals(1, prof1.getId());
    }

    @Test
    void testConstrutorAluno() throws Exception{
        Aluno a1 = new Aluno(101, "Roberval");

        assertEquals("Roberval", a1.getNome());
        assertEquals (101, a1.getId());
        
    }

    @Test
    void testConstrutorProfessorException() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Professor(-1, "Juresvaldo");
        });
        
        assertEquals("O ID do professor deve ser maior que zero.",exception.getMessage());
    }

    @Test
    void testConstrutorProfessorException2() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Professor(1, null);
        });
        
        assertEquals("O nome do professor não pode ser nulo ou vazio.",exception.getMessage());
    }

    @Test
    void testConstrutorProfessorException3() throws Exception{
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Professor prof = new Professor(1, "Juresvaldo");
            prof.adicionarDisciplina(null);
        });
        
        assertEquals("A disciplina não pode ser nula.",exception.getMessage());
    }

    @Test
    void testConstrutorProfessorException4() throws Exception{
        Exception exception = assertThrows(IllegalStateException.class, () -> {
           Professor prof = new Professor(1, "Juresvaldo");
           prof.getHorario();
        });
        
        assertEquals("O professor não possui disciplinas cadastradas.",exception.getMessage());
    }

    @Test
    void testConstrutorAlunoException() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno(-1, "José Cleison");
        });
        
        assertEquals("O ID do aluno deve ser maior que zero.",exception.getMessage());
    }

    @Test
    void testConstrutorAlunoException2() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno(1, null);
        });
        
        assertEquals("Nome do aluno não pode estar vazio ou ser nulo.",exception.getMessage());
    }

    @Test
    void testConstrutorAlunoException3() throws Exception{
        Exception exception = assertThrows(NullPointerException.class, () -> {
           Aluno aluno = new Aluno(1, "Robert Richards");
           aluno.adicionarDisciplina(null);
            
        });
        
        assertEquals("Erro: Disciplina inválida (nula).",exception.getMessage());
    }

    @Test
    void testConstrutorAlunoException4() throws Exception{
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            Aluno aluno = new Aluno(1, "Robert Richards");
           aluno.getHorario();
        });
        
        assertEquals("O aluno não está matriculado em nenhuma disciplina.",exception.getMessage());
    }

    @Test
    void testConstrutorDisciplinaException() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Disciplina(null, "09:00 Seg", new Professor(1, "Juresvaldo"));
        });
        
        assertEquals("O nome da disciplina não pode ser nulo ou vazio.",exception.getMessage());
    }

    @Test
    void testConstrutorDisciplinaException2() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Disciplina("Calculo 1", null, new Professor(1, "Juresvaldo"));
        });
        
        assertEquals("O horário da disciplina não pode ser nulo ou vazio.",exception.getMessage());
    }

    @Test
    void testConstrutorDisciplinaException3() throws Exception{
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Disciplina("Calculo 1", "09:00 Seg", null);
        });
        
        assertEquals("A disciplina deve ter um professor associado.",exception.getMessage());
    }

    @Test
    void testConstrutorDisciplinaException4() throws Exception{
        Exception exception = assertThrows(NullPointerException.class, () -> {
           Disciplina disc = new Disciplina("Calculo 1", "09:00 Seg", new Professor(1, "Juresvaldo"));
            disc.adicionarAluno(null);
        });
        
        assertEquals("O aluno não pode ser nulo.",exception.getMessage());
    }
}

