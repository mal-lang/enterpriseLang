package org.mal_lang.attacklang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestSpearphishingAttachment{

    @Test
    public void testSpearphishingAttachment1() {
        Attacker attacker = new Attacker();
        User user = new User(false);
        Browser browser = new Browser(false);
        Computer computer = new Computer();

        user.addComputer(computer);
        browser.addUser(user);

        attacker.addAttackPoint(user.spearphishingAttachmentDownload);
        attacker.attack();
        
        computer.infectedComputer.assertCompromisedInstantaneously();
    }

    @Test
    public void testSpearphishingAttachment2() {
        Attacker attacker = new Attacker();
        User user = new User(false);
        Browser browser = new Browser(false);
        Computer computer = new Computer();

        user.addComputer(computer);
        browser.addUser(user);

        attacker.addAttackPoint(browser.spearphishingAttachment);  
        attacker.attack();
        
        user.spearphishingAttachmentDownload.assertCompromisedInstantaneously();
        user.userExecution.assertCompromisedInstantaneously();
        computer.infectedComputer.assertCompromisedInstantaneously();
    }

}