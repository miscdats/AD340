package com.taupier.deya.toomuchtuna;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Mock
    Context mockContext;

    @Mock
    Resources mockResources;

    @Mock
    Plate defaultPlate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockContext.getString(R.string.default_plate))
                .thenReturn("5 tuna on the plate.");
        when(mockContext.getResources()).thenReturn(mockResources);


        this.defaultPlate = new Plate(mockContext);
    }

    @Test
    public void checkInputEmpty() {
        String empty = "";


    }

    @Test
    public void checkNothingSelection() {
    }

    @Test
    public void displayPlate() {
    }
}