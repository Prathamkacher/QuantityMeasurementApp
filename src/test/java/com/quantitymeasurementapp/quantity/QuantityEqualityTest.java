package com.quantitymeasurementapp.quantity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.quantitymeasurementapp.quantity.Quantity;
import com.app.quantitymeasurementapp.unit.LengthUnit;
import com.app.quantitymeasurementapp.unit.TemperatureUnit;
import com.app.quantitymeasurementapp.unit.VolumeUnit;
import com.app.quantitymeasurementapp.unit.WeightUnit;

public class QuantityEqualityTest {

    private static final double EPSILON = 0.0001;

    // 1
    @Test
    void givenSameLengthUnitAndValue_ShouldBeEqual() {

        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    // 2
    @Test
    void givenSameLengthUnitDifferentValue_ShouldNotBeEqual() {

        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    // 3
    @Test
    void givenFeetAndInchesEquivalent_ShouldBeEqual() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    // 4
    @Test
    void givenFeetAndInchesNotEquivalent_ShouldNotBeEqual() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(10.0, LengthUnit.INCHES);

        assertFalse(feet.equals(inches));
    }

    // 5
    @Test
    void givenLitreAndMillilitreEquivalent_ShouldBeEqual() {

        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    // 6
    @Test
    void givenMillilitreAndLitreEquivalent_ShouldBeEqual() {

        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(ml.equals(litre));
    }

    // 7
    @Test
    void givenKilogramAndGramEquivalent_ShouldBeEqual() {

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    // 8
    @Test
    void givenDifferentMeasurementCategories_ShouldNotBeEqual() {

        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertFalse(length.equals(volume));
    }

    // 9
    @Test
    void givenSameReference_ShouldReturnTrue() {

        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

        assertTrue(q.equals(q));
    }

    // 10
    @Test
    void givenNullComparison_ShouldReturnFalse() {

        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

        assertFalse(q.equals(null));
    }

    // 11
    @Test
    void givenZeroValuesAcrossUnits_ShouldBeEqual() {

        Quantity<VolumeUnit> litre = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(0.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    // 12
    @Test
    void givenNegativeValuesAcrossUnits_ShouldBeEqual() {

        Quantity<VolumeUnit> litre = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    // 13
    @Test
    void givenLargeEquivalentValues_ShouldBeEqual() {

        Quantity<VolumeUnit> ml = new Quantity<>(1000000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(1000.0, VolumeUnit.LITRE);

        assertTrue(ml.equals(litre));
    }

    // 14
    @Test
    void givenSmallEquivalentValues_ShouldBeEqual() {

        Quantity<VolumeUnit> litre = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    // 15
    @Test
    void givenTemperatureAndLength_ShouldNotBeEqual() {

        Quantity<TemperatureUnit> temp = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        Quantity<LengthUnit> length = new Quantity<>(25.0, LengthUnit.FEET);

        assertFalse(temp.equals(length));
    }

}