import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import com.sistemaacademico.Aluno;
import com.sistemaacademico.Disciplina;
import com.sistemaacademico.RDM;
public class RDMTest {
    

    @Test
    public void testConstrutorRDM(){
        Aluno mockAluno = mock(Aluno.class);
        Disciplina  mockDisciplina = mock(Disciplina.class);

        RDM rdm = new RDM(mockAluno, mockDisciplina);

        verify(mockAluno).adicionarDisciplina(mockDisciplina);
        verify(mockDisciplina).adicionarAluno(mockAluno);

        assertEquals(mockDisciplina, rdm.getDisciplina());
        assertEquals(mockAluno, rdm.getAluno());
    }
}
