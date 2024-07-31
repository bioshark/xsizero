package org.roly.app;

import java.util.Optional;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;
import org.roly.domain.model.Board;
import org.roly.domain.service.GameService;

public class XsiZero
{
    public static void main( String[] args ) {

        GameService service = new GameService();
        service.play();
    }
}
