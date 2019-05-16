package com.taupier.deya.toomuchtuna;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PlateUnitTest {

    @Mock
    Context mockContext;

    private Plate plate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void plateWithTooMuchTuna() {
        plate = new Plate("50", "3", "Tuna");
        assertThat(plate.getPlate()).isEqualTo("TOO MUCH TUNA!!!!!!");
    }

    @Test
    public void plateWithNoTuna() {
        plate = new Plate("-5", "2", "Tuna");
        assertThat(plate.getPlate()).isEqualTo("Are we out of tuna?");
    }

    @Test
    public void plateWithBadTunaInput() {
        plate = new Plate("scoop", "no thank you", "Tuna");
        assertThat(plate.getPlate()).isEqualTo("We needed non-zero numbers here!!!");
    }

    @Test
    public void eatingWell() {
        plate.eat(6, 3);
        assertThat(plate.getPlate()).isEqualTo(3);
    }

    @Test
    public void notInteger() {
        assertThat(plate.isInteger("not integer")).isFalse();
    }

    @Test
    public void definitelyInteger() {
        assertThat(plate.isInteger("4")).isTrue();
    }



}