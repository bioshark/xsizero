package org.roly.app;

import org.roly.domain.service.AutoGamePlayService;
import org.roly.domain.service.ManualGameService;

public class XsiZero
{
    public static void main( String[] args ) {

        ManualGameService manualGameService = new ManualGameService();
        AutoGamePlayService autoGamePlayService = new AutoGamePlayService();
        manualGameService.play();
//        autoGamePlayService.play();

    }
}
