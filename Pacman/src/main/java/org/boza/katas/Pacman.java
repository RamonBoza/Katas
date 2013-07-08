package org.boza.katas;

import org.boza.katas.exceptions.PacmanException;

/**
 * Hello world!
 */
public class Pacman {

    /**
     * @param scene
     */
    public void tick(final Object scene) throws PacmanException {
        // TODO Auto-generated method stub
        if (null == scene) {
            throw new PacmanException("Map has not been initialized!");
        }
    }
}
