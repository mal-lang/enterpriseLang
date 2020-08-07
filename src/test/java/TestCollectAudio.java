package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestCollectAudio extends EnterpriseLangTest{
    /*
      
		OS ---- Computer ---- microphone


        Attacker's entry point: computer.infectedComputer
    */
    
    
    // test no defens aktiv.
    private static class collectAudio{
	public final Computer computer = new Computer("computer");
	public final OS os = new OS("os");
	public final Microphone mictophone = new Microphone("mictophone");
	public final PeripheralDevice pDevice = new PeripheralDevice("pDevice");

	public collectAudio() {
	    computer.addOs(os);
	    pDevice.addComputer(computer);
	    pDevice.addMicrophone(mictophone);
	}
        
    }
    
    @Test
    public void runNoDefensInfectedComputer(){
	var model = new collectAudio();

	Attacker attacker = new Attacker();
	attacker.addAttackPoint(model.computer.infectedComputer);
	attacker.attack();


	model.computer.collectAudio.assertCompromisedInstantaneously();
	model.os.dataCollected.assertCompromisedInstantaneously();
    }

    // test no microphone.
    private static class collectAudio2{
	public final Computer computer = new Computer("computer");
	public final OS os = new OS("os");
	public final Microphone mictophone = new Microphone("mictophone");
	public final PeripheralDevice pDevice = new PeripheralDevice("pDevice");

	public collectAudio2() {
	    computer.addOs(os);
	}
        
    }
    
    @Test
    public void noMicrophone(){
	var model = new collectAudio2();

	Attacker attacker = new Attacker();
	attacker.addAttackPoint(model.computer.infectedComputer);
	attacker.attack();


	//model.computer.collectAudio.assertUncompromised();
	//model.os.dataCollected.assertUncompromised();
    }
  		
    // test with defens aktiv.
    private static class collectAudio3{
	public final Computer computer = new Computer("computer");
        public final OS os = new OS("os",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
	public final Microphone mictophone = new Microphone("mictophone");
	public final PeripheralDevice pDevice = new PeripheralDevice("pDevice");

	public collectAudio3() {
	    computer.addOs(os);
	    pDevice.addComputer(computer);
	    pDevice.addMicrophone(mictophone);
	}
        
    }
    
    @Test
    public void Defens(){
	var model = new collectAudio3();

	Attacker attacker = new Attacker();
	attacker.addAttackPoint(model.computer.infectedComputer);
	attacker.attack();


	model.computer.collectAudio.assertUncompromised();
	model.os.dataCollected.assertUncompromisedFrom(model.computer.collectAudio);
    }

}
