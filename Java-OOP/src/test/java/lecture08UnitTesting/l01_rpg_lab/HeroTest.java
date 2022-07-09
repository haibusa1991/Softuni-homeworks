package lecture08UnitTesting.l01_rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class HeroTest {
    private Weapon weapon;
    private Target target;
    private Hero hero;

    private final int TARGET_XP = 100;

    @Before
    public void setUp() {
        weapon = Mockito.mock(Weapon.class);

        target = Mockito.mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(TARGET_XP);

        hero = new Hero("Ivan", weapon);
    }

    @Test
    public void testHeroGainsXpWhenTargetIsKilled() {
        hero.attack(target);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }

    @Test
    public void testHeroGetsLootAfterKillingTarget() {
        target = Mockito.mock(Dummy.class);
        when(target.isDead()).thenReturn(true);
        Loot mockAxe = LootFactory.getRandomAxe();
        when(target.dropLoot()).thenReturn(mockAxe);


        List<Loot> expectedInventory = new ArrayList<>() {{
            add(mockAxe);
        }};

        hero.takeLoot(target.dropLoot());
        Assert.assertEquals(expectedInventory, hero.getInventory());
    }


}
