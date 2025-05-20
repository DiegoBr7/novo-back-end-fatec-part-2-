package br.com.trampuu.trampuu.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Item_Pedido;

    private int id_Pedido;
    private int id_Produto;


}
