package Transferencia;

public class Conta {

    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente propietario;

    public Conta(String agencia, String numeroConta, double saldo, Cliente propietario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void realizarDeposito(double valor) {
        saldo += valor;
    }

    public boolean realizarSaque(double valor) {
        if (valor > saldo) {
            return false;
        } else {
            saldo -= valor;
            return true;
        }
    }

    public boolean realizarTransferencia(double valor, Conta destino) {
        if (realizarSaque(valor)) {
            destino.realizarDeposito(valor);
            return true;
        }
        return false;
    }

}