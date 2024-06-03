package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Venta;

public class TestVenta {

    @Test
    public void idVentaValida() {
        Venta V = new Venta();
        if (V.getIdventa() > 0 ) {
            assert(true);
        } else {
            assert(false);
        }
    }

}
