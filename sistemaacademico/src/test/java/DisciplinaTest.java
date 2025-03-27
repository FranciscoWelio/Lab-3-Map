import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sistemaacademico.Aluno;
import com.sistemaacademico.Disciplina;
import com.sistemaacademico.Professor;
public class DisciplinaTest {
    @Test
    void testConstrutorDisciplina() throws Exception{
        Professor prof1 = new Professor(1, "Dr. Silva");
        Disciplina d1 = new Disciplina("Matemática", "08:00 Seg", prof1);

        assertEquals("Matemática", d1.getNome());
        assertEquals("08:00 Seg", d1.getHorario());
        assertEquals("Dr. Silva", d1.getProfessor().getNome());
    }


    @Test
    void testConstrutorDisciplinaAddAluno() throws Exception{
       
        Professor prof1 = new Professor(1, "Dr. Silva");
        Disciplina d1 = new Disciplina("Matemática", "08:00 Seg", prof1);
        
        assertEquals("Aluno Adicionado", d1.adicionarAluno( new Aluno(1, "Silvano")));
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
