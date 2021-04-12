package clazz;

import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void exc() {

        var enderecos = List.of(
                new Endereco("casa","Noel rosa", "62", "vir", "10A"),
                new Endereco("trabalho","NNNNN", "10A", "10A", "10A"));

        var cliente = new Cliente("Marcelo", "19989624096", "35",enderecos);

        System.out.println(cliente.getJson());
        System.out.println(cliente.getXml());



    }
}
