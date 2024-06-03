package org.mywire.temiroapp;

import org.junit.Test;
import org.mywire.temiroapp.model.Train;

public class TestTrain {

    @Test
    public void idValido() {
        Train T = new Train();
        if (T.getId() == 0 ) {
            assert(true);
        } else {
            assert(false);
        }
    }

}
