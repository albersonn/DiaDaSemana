package alberson;

import java.util.ArrayList;
import java.util.List;

public final class DiaDaSemana {

    private DiaDaSemana() {
    }

    public enum EDiaDaSemana {
        DOMINGO,
        SEGUNDA,
        TERCA,
        QUARTA,
        QUINTA,
        SEXTA,
        SABADO
    }

    public static final int DOMINGO = 0b1000000; // 64
    public static final int SEGUNDA = 0b0100000; // 32
    public static final int TERCA = 0b0010000; // 16
    public static final int QUARTA = 0b0001000; //  8
    public static final int QUINTA = 0b0000100; //  4
    public static final int SEXTA = 0b0000010; //  2
    public static final int SABADO = 0b0000001; //  1


    public static List<EDiaDaSemana> obterDiasTrabalho(int valor) {
        if (valor > 0b1111111 || valor < 0)
            throw new IllegalArgumentException("Valor está fora do range de dias da semana");

        ArrayList<EDiaDaSemana> lista = new ArrayList<>();

        if (trabalha(valor, DOMINGO)) lista.add(EDiaDaSemana.DOMINGO);
        if (trabalha(valor, SEGUNDA)) lista.add(EDiaDaSemana.SEGUNDA);
        if (trabalha(valor, TERCA)) lista.add(EDiaDaSemana.TERCA);
        if (trabalha(valor, QUARTA)) lista.add(EDiaDaSemana.QUARTA);
        if (trabalha(valor, QUINTA)) lista.add(EDiaDaSemana.QUINTA);
        if (trabalha(valor, SEXTA)) lista.add(EDiaDaSemana.SEXTA);
        if (trabalha(valor, SABADO)) lista.add(EDiaDaSemana.SABADO);

        return lista;
    }

    public static boolean trabalha(int valor, int dia) {
        return ((valor & dia) == dia);
    }

}