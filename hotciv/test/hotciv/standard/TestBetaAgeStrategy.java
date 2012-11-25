package hotciv.standard;

import hotciv.framework.*;
import hotciv.strategy.AgeStrategy;
import hotciv.strategy.BetaAgeStrategy;

import org.junit.*;
import static org.junit.Assert.*;


public class TestBetaAgeStrategy {
    private AgeStrategy as;

    @Before
    public void setup() {
        as = new BetaAgeStrategy();
    }

    @Test
    public void shouldBe100YearDifferenceUntil100BC() {
        assertEquals("Should go 100 years forward each round, starting with age -4000", -3900, as.calculateNextAge(-4000));
        assertEquals("should still go forward 100 years at age -2500", -2400, as.calculateNextAge(-2500));
        assertEquals("should keep doing it until -200 inserted", -100, as.calculateNextAge(-200));
        assertNotSame("should not do it anymore at age -100 inserted", 0 , as.calculateNextAge(-100));
    }

    @Test
    public void shouldBeYearMinus1Year1Year50AroundChristBirth() {
        assertEquals("should be age -1 if -100 is inserted", -1, as.calculateNextAge(-100));
        assertEquals("should be age 1 if age -1 is inserted", 1, as.calculateNextAge(-1));
        assertEquals("should be age 50 if age 1 is inserted", 50, as.calculateNextAge(1));
    }

    @Test
    public void shouldBe50YearsMoreUntilYear1750(){
        assertEquals("should be age 500 if 450 is inserted", 500, as.calculateNextAge(450));
        assertEquals("should be age 1750 if 1700 is inserted", 1750, as.calculateNextAge(1700));
        assertNotSame("should not be age 1800 if 1750 is inserted", 1800, as.calculateNextAge(1750));

    }

    @Test
    public void shouldBe25YearsMoreUntilYear1900(){
        assertEquals("should be age 1775 if 1750 is inserted", 1775, as.calculateNextAge(1750));
        assertEquals("should be age 1900 if 1875 is inserted", 1900, as.calculateNextAge(1875));
        assertNotSame("should not be age 1925 if 1900 is inserted", 1925, as.calculateNextAge(1900));

    }

    @Test
    public void shouldBe5yearsMoreUntil1970() {
        assertEquals("should be age 1905 if 1900 is inserted", 1905, as.calculateNextAge(1900));
        assertEquals("should be age 1970 if 1965 is inserted", 1970, as.calculateNextAge(1965));
        assertNotSame("should not be age 1975 if 1970 is inserted", 1975, as.calculateNextAge(1970));
    }

    @Test
    public void shouldBe1YearMoreAfter1970() {
        assertEquals("should be age 1971 if 1970 is inserted", 1971, as.calculateNextAge(1970));
        assertEquals("should be age 3000 if 2999 is inserted", 3000, as.calculateNextAge(2999));
        assertNotSame("should not be age 2012 if 2010 is inserted", 2012, as.calculateNextAge(2010));
    }
}
