import alberson.DiaDaSemana;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TesteDiaDaSemana {
    @Test
    public void testarDiaDaSemana() {
        int diasDeTrabalho = 42;
        assertFalse(DiaDaSemana.trabalha(diasDeTrabalho, DiaDaSemana.TERCA));

        assertThat("Contém terça", DiaDaSemana.obterDiasTrabalho(diasDeTrabalho), hasItem(DiaDaSemana.SEGUNDA));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarRangeMaiorQuePermitido() {
        DiaDaSemana.obterDiasTrabalho(130);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarRangeMenorQuePermitido() {
        DiaDaSemana.obterDiasTrabalho(-1);
    }
}
