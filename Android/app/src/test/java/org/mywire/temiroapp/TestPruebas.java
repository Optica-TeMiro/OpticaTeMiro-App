package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Pruebas;

public class TestPruebas {

    @Test
    public void busquedaPrimerElemento() {
        Pruebas P = new Pruebas(null);
        if (P.buscar(0) && P.getNombre()=="No definido") {
            assert(true);
        } else {
            assert(false);
        }
    }

}
