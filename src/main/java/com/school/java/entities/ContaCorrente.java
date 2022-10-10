
package com.school.java.entities;

/**
 *
 * @author User
 */
public class ContaCorrente extends Cliente  {

    public ContaCorrente(NomeDoBanco nomeDoBanco, String titular, Integer agencia, Long numeroDaConta, Integer digito, Double saldo, String abertura ) {
        super(nomeDoBanco, titular, agencia, numeroDaConta, digito, saldo, abertura);
    }

  
    
}
