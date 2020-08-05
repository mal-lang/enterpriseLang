package org.mal_lang.enterpriselang.test;

import core.Asset;
import core.AttackStep;
import core.Defense;
import org.junit.jupiter.api.AfterEach;

public class EnterpriseLangTest {
  @AfterEach
  public void deleteModel() {
    Asset.allAssets.clear();
    AttackStep.allAttackSteps.clear();
    Defense.allDefenses.clear();
  }
}
