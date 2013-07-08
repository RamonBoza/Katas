package org.boza.katas;

import org.boza.katas.exceptions.PacmanException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class PacmanTest {
    private Pacman _pacman;

    @Rule
    public ExpectedException _expected = ExpectedException.none();

    @Before
    public void before() {
        _pacman = new Pacman();
    }

    @Test
    public void testPacmanWithNoMapInitialized() throws Exception {
        _expected.expect(PacmanException.class);
        _pacman.tick(null);

    }
}
