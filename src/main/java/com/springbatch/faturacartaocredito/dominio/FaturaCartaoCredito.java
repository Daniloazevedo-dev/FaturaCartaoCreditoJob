package com.springbatch.faturacartaocredito.dominio;

import java.util.ArrayList;
import java.util.List;

public class FaturaCartaoCredito {

    private Cliente cliente;
    private CartaoCredito cartaoCredito;
    private List<Transacao> transacao = new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void setTransacao(List<Transacao> transacao) {
        this.transacao = transacao;
    }

    public Double getTotal() {
        return transacao.stream()
                .mapToDouble(Transacao::getValor)
                .reduce(0.0, Double::sum);
    }
}
