package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Product;

public class TestProduct {

    @Test
    public void idProductoValido() {
        Product P = new Product();
        if (P.getIdproducto() > 0) {
            assert(true);
        } else {
            assert(false);
        }
    }

}
