package com.school.java.entities;

/**
 *
 * @author Evandro
 */
public class ContaPoupanca extends Cliente {

    public ContaPoupanca(NomeDoBanco nomeDoBanco, String titular, Integer agencia, Long numeroDaConta, Integer digito, Double saldo, String abertura) {
        super(nomeDoBanco, titular, agencia, numeroDaConta, digito, saldo, abertura);
    }

  
  
}
