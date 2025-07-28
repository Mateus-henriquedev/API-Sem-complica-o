package Transferencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @Test
    public void realizarTransacao() {

        xuxa = new Cliente("Xuxa", "47935673212", "113469516");
        silvioSantos = new Cliente("Silvio Santos", "45138904285", "134690314");

        contaXuxa = new Conta("0023", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0023", "2312", 10000.00, silvioSantos);

        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(11000.00, contaSilvio.getSaldo());

    }

    @Test
    public void validarTransferenciaInvalida(){
        xuxa = new Cliente("Xuxa", "47935673212", "113469516");
        silvioSantos = new Cliente("Silvio Santos", "45138904285", "134690314");

        contaXuxa = new Conta("0023", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0023", "2312", 10000.00, silvioSantos);

       boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);
    }
}