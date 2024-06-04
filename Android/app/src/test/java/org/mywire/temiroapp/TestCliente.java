package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Cliente;

public class TestCliente {

    @Test
    public void idClienteValido() {
        Cliente C = new Cliente();
        if (C.getIdcliente() == 0) {
            assert(true);
        } else {
            assert(false);
        }
    }

}
