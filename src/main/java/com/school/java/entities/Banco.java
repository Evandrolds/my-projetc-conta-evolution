package com.school.java.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Evandro
 */
public class Banco   {

    private List<ContaCorrente> contasCorrente = new ArrayList<>();
    private List<ContaPoupanca> contasPoupanca = new ArrayList<>();
    private NomeDoBanco nomeDoBanco;
    private List<Cliente> clientes = new ArrayList<>();

    public Banco(NomeDoBanco nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }
    
    public Banco() {

    }

    public List<ContaCorrente> getContasCorrente() {
        return contasCorrente;
    }

    public void setContasCorrente(List<ContaCorrente> contasCorrente) {
        this.contasCorrente = contasCorrente;
    }

    public List<ContaPoupanca> getContasPoupanca() {
        return contasPoupanca;
    }

    public void setContasPoupanca(List<ContaPoupanca> contasPoupanca) {
        this.contasPoupanca = contasPoupanca;
    }

   

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public NomeDoBanco getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(NomeDoBanco nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public NomeDoBanco qualSeuBanco(int codigo) {
        /*
            BANCO_DO_BRASIL, // 001
            BANCO_SANTANDER, // 033,
            BANCO_BRADESCO, // 237,
            CAIXA, // 104
            BANCO_REAL, // 356
            BANCO_ITAU, // 341
            HSBC_BANK, // 399
         */
        NomeDoBanco banco = null;
        switch (codigo) {
            case 001: {
                banco = NomeDoBanco.BANCO_DO_BRASIL;
                break;
            }
            case 033: {
                banco = NomeDoBanco.BANCO_SANTANDER;
                break;
            }
            case 237: {
                banco = NomeDoBanco.BANCO_BRADESCO;
                break;
            }
            case 104: {
                banco = NomeDoBanco.CAIXA;
                break;
            }
            case 356: {
                banco = NomeDoBanco.BANCO_REAL;
                break;
            }
            case 341: {
                banco = NomeDoBanco.BANCO_ITAU;
                break;
            }
            case 399: {
                banco = NomeDoBanco.HSBC_BANK;
                break;
            }
            default: {
                System.out.println("CÓDIGO DE BANCO INEXISTENTE!");
                break;
            }
        }
        return banco;
    }

    

    public void estratoContaCorrente(List<Cliente> contas) {
        for (Banco obj : contas) {
            System.out.println(" Conta corrente " + obj.toString());
        }

    }

    public void estratoContaPoupanca(List<Cliente> contas) {

        for (Banco obj : contas) {
            System.out.println(" Conta poupança " + obj.toString());
        }

    }

}
