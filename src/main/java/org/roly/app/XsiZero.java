package org.roly.app;

import org.roly.domain.service.AutoGamePlayService;
import org.roly.domain.service.ManualGameService;
import org.roly.domain.service.PlayableGame;

public class XsiZero
{
    public static void main( String[] args ) {

        PlayableGame manualGameService = new ManualGameService();
        PlayableGame autoGamePlayService = new AutoGamePlayService();
//        manualGameService.play();
        autoGamePlayService.setTimeout(1000L);
        autoGamePlayService.play();

    }
}
