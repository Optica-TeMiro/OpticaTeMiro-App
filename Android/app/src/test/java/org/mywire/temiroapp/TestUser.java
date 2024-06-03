package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.User;

public class TestUser {

    @Test
    public void idUsuarioValido() {
        User U = new User();
        if (U.getIdusuario() > 0) {
            assert(true);
        } else {
            assert(false);
        }
    }

}
