package alberson;

import java.util.ArrayList;
import java.util.List;

public enum DiaDaSemana {
    DOMINGO(0b1000000), // 64
    SEGUNDA(0b0100000), // 32
    TERCA  (0b0010000), // 16
    QUARTA (0b0001000), //  8
    QUINTA (0b0000100), //  4
    SEXTA  (0b0000010), //  2
    SABADO (0b0000001); //  1

    private int valor;

    DiaDaSemana(int valor) {
        this.valor = valor;
    }

    public static List<DiaDaSemana> obterDiasTrabalho(int valor) {
        if (valor > 0b1111111 || valor < 0)
            throw new IllegalArgumentException("Valor está fora do range de dias da semana");

        ArrayList<DiaDaSemana> lista = new ArrayList<>();

        if (trabalha(valor, DOMINGO)) lista.add(DOMINGO);
        if (trabalha(valor, SEGUNDA)) lista.add(SEGUNDA);
        if (trabalha(valor, TERCA))   lista.add(TERCA);
        if (trabalha(valor, QUARTA))  lista.add(QUARTA);
        if (trabalha(valor, QUINTA))  lista.add(QUINTA);
        if (trabalha(valor, SEXTA))   lista.add(SEXTA);
        if (trabalha(valor, SABADO))  lista.add(SABADO);

        return lista;
    }

    public static boolean trabalha(int valor, DiaDaSemana dia) {
        return ((valor & dia.valor) == dia.valor);
    }
}