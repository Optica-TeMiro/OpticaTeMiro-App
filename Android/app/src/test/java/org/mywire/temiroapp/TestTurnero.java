package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Turnero;

public class TestTurnero {

    @Test
    public void confirmadoCancelado() {
        Turnero T = new Turnero("", null);
        if (T.isConfirmado() || T.isCancelado()) {
            assert(false);
        } else {
            assert(true);
        }
    }

}
