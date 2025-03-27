import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sistemaacademico.ControleAcademico;
import com.sistemaacademico.Disciplina;
import com.sistemaacademico.RDM;

public class ControleAcademicoTest {

    private ControleAcademico ca;
    
    @BeforeEach
    void setUp(){
        ca = new ControleAcademico();
    }
    @Test
    void testAddProfessor(){
        ca.adicionarProfessor("Silvanildo", 1);
        assertEquals(1, ca.getProfessores().get(0).getId());
        assertEquals("Silvanildo", ca.getProfessores().get(0).getNome());
    }
    @Test
    void testAddAluno(){
        ca.adicionarAluno("Josezinho", 1);
        assertEquals(1, ca.getAlunos().get(0).getId());
        assertEquals("Josezinho", ca.getAlunos().get(0).getNome());
    }
    @Test
    void testAddDisciplina(){
        ca.adicionarDisciplina("Português", ca.adicionarProfessor("Silvanildo", 1),"Seg 7:00");

        assertEquals("Português", ca.getDisciplinas().get(0).getNome());
        assertEquals("Seg 7:00", ca.getDisciplinas().get(0).getHorario());
    }

    @Test
    void testRDM(){
        Disciplina disc = ca.adicionarDisciplina("Português", ca.adicionarProfessor("Silvanildo", 1),"Seg 7:00");
        RDM rdm = ca.adicionarRDM(ca.adicionarAluno("Josezinho", 1), disc);
        assertEquals(disc, rdm.getDisciplina());
        assertEquals("Josezinho", rdm.getAluno().getNome());


    }
}

