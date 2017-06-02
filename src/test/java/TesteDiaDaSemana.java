import alberson.DiaDaSemana;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TesteDiaDaSemana {

    @Test
    public void deveTrabalharDeSegundaESexta() {
        int diasDeTrabalho = 42;
        assertTrue(DiaDaSemana.trabalha(diasDeTrabalho, DiaDaSemana.SEGUNDA | DiaDaSemana.SEXTA));
    }

    @Test
    public void deveConterQuintaEDomingo() {
        int diasDeTrabalho = 0b1000101;
        assertThat(DiaDaSemana.obterDiasTrabalho(diasDeTrabalho), hasItems(DiaDaSemana.EDiaDaSemana.QUINTA, DiaDaSemana.EDiaDaSemana.DOMINGO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveEstarComORangeMaior() {
        DiaDaSemana.obterDiasTrabalho(130);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveEstarComORangeMenor() {
        DiaDaSemana.obterDiasTrabalho(-1);
    }
}
