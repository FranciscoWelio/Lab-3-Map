
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sistemaacademico.Disciplina;
import com.sistemaacademico.Professor;
public class ProfessorTest {
    @Test
    void testConstrutorProfessor() throws Exception{
        Professor prof1 = new Professor(1, "Juresvaldo");
        
        assertEquals("Juresvaldo", prof1.getNome());
        assertEquals(1, prof1.getId());
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
    void testConstrutorProfessorException3_5() throws Exception{
        Professor prof1 = new Professor(1, "Juresvaldo");
        assertEquals("Disciplina Adicionada", prof1.adicionarDisciplina(new Disciplina("Matemática", "08:00 Seg", prof1)));

    }
    @Test
    void testConstrutorProfessorException4() throws Exception{
        Exception exception = assertThrows(IllegalStateException.class, () -> {
           Professor prof = new Professor(1, "Juresvaldo");
           prof.getHorario();
        });
        
        assertEquals("O professor não possui disciplinas cadastradas.",exception.getMessage());
    }
}
