package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Pruebas;

public class TestPruebas {

    @Test
    public void busquedaPrimerElemento() {
        Pruebas T = new Pruebas(null);
        if (T.buscar(0) && T.getNombre()=="No definido") {
            assert(true);
        } else {
            assert(false);
        }
    }

}
