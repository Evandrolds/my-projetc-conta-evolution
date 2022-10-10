package com.scholl.java.impl;

import com.school.java.entities.Cliente;

/**
 *
 * @author Evandro
 */
public interface funcoesBasicas {

    void sacar(Cliente conta,Double value);

    void depositar(Cliente conta ,Double value);

    void tranferir(Cliente partida, Cliente destino, Double value);

}
