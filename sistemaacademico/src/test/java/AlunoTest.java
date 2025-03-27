import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sistemaacademico.Aluno;
import com.sistemaacademico.Disciplina;
import com.sistemaacademico.Professor;
public class AlunoTest {
    @Test
    void testConstrutorAluno() throws Exception{
        Aluno a1 = new Aluno(101, "Roberval");

        assertEquals("Roberval", a1.getNome());
        assertEquals (101, a1.getId());
        
    }
    @Test
    void testConstrutorAlunoAddDisciplina() throws Exception{
        Aluno a1 = new Aluno(101, "Roberval");


        assertEquals ("Disciplina Adicionada", a1.adicionarDisciplina( new Disciplina("Matemática", "08:00 Seg", new Professor(1, "Dr. Silva"))));
        
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
}
