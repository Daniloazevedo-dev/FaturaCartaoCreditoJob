package com.springbatch.faturacartaocredito.processor;

import com.springbatch.faturacartaocredito.dominio.Cliente;
import com.springbatch.faturacartaocredito.dominio.FaturaCartaoCredito;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;

@Component
public class CarregarDadosClienteProcessor implements ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> {


    @Override
    public FaturaCartaoCredito process(FaturaCartaoCredito faturaCartaoCredito) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d", faturaCartaoCredito.getCliente().getId());
        ResponseEntity<Cliente> response = restTemplate.getForEntity(uri, Cliente.class);

        if (response.getStatusCode() != HttpStatus.OK)
            throw new ValidationException("Cliente não encontrado!");

        faturaCartaoCredito.setCliente(response.getBody());

        return faturaCartaoCredito;
    }
}
