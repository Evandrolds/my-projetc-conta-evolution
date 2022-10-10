package com.school.java.entities;

import com.scholl.java.impl.funcoesBasicas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author Evandro
 */
@Data
public class Cliente extends Banco implements funcoesBasicas {

    private String titular;
    private Integer agencia;
    private Long numeroDaConta;
    private Integer digito;
    private NomeDoBanco nomeDoBanco;
    private Double saldo;
    private String dateConta;

    public Cliente(NomeDoBanco nomeDoBanco, String titular, Integer agencia, Long numeroDaConta, Integer digito, Double saldo, String dateConta) {
        super(nomeDoBanco);
        this.titular = titular;
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.digito = digito;
        this.nomeDoBanco = nomeDoBanco;
        this.saldo = saldo;
        this.dateConta = dateConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "\n Data de abertura: " + dateConta + "\n Banco: " + nomeDoBanco + "\n Titular: " + titular
                + "\n Agencia: " + agencia
                + "\n Conta: " + numeroDaConta
                + "\n Digito: " + digito
                + "\n Saldo: R$ " + String.format("%.2f\n", saldo);
    }
    // Comparando se o titular e o numero da conta são iguais

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.titular);
        hash = 41 * hash + Objects.hashCode(this.numeroDaConta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return Objects.equals(this.numeroDaConta, other.numeroDaConta);
    }

    
    @Override
    public void depositar(Cliente conta, Double value) {
        if (value.isNaN()) {
            System.out.println(" Digite apenas numero!");

        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        saldo += value;
         System.out.println("\n----------- Realizando deposito -----------\n");
        LocalDateTime date = LocalDateTime.now();
        String hoje = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("  Deposito realizado com sucesso!   \n  Valor R$ " + String.format("%.2f", value)
                + "\n  Titular: "+ conta.getTitular()+ "\n  Conta: " + conta.getNumeroDaConta() + "\n  Data: " + hoje + "\n");
        
    }
   
     @Override
    public void tranferir(Cliente partida, Cliente destino, Double value) {
        if (partida.numeroDaConta.equals(destino.getNumeroDaConta())) {
            System.out.println(" Não é possível tranferir para a mesma conta!");
            return;
        }
        if (value.isNaN()) {
            System.out.println(" Digite apenas numero!");
        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        saldo -= value;
         System.out.println("--------- Realizando tranferencia ----------\n\n");
        partida.depositar(destino, value);
        LocalDateTime date = LocalDateTime.now();
        String hoje = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        System.out.println("    Valor tranferido com sucesso! ------\n\n");
        System.out.println(partida.getTitular() + " fez a transferência no valor de R$ " + String.format("%.2f", value)
                + " para " + destino.getTitular()
                + "\n  Data: " + hoje);

    }
     @Override
    public void sacar(Cliente conta, Double value) {

        if (value.isNaN()) {
            System.out.println(" Digite apenas numero!");
        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        if (value > this.saldo) {
            System.out.println(" Valor inválido, tente um valor menor!");
            System.out.println(" Seu saldo atual é de R$ " + String.format("%.2f", this.getSaldo()));
        }
        saldo -= value;
        System.out.println("\n-------- Realizando saque ------------\n");
        LocalDateTime date = LocalDateTime.now();
        String hoje = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("  Saque realizado por " + conta.getTitular() + "\n  Valor R$ "
                + String.format("%.2f", value)
                + "\n  Data: " + hoje + "\n");

    }


   
}
