package com.taupier.deya.toomuchtuna;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {
    private static final String FAKE_PLATE = "5 tuna on the plate.";

    @Mock
    private Context mockContext;

    @Mock
    private Resources mockResources;

    @Mock
    private Plate defaultPlate;

    @Mock
    MainActivity act;

    @Before
    public void setUp() {
        this.act = Robolectric.setupActivity(MainActivity.class);
        this.defaultPlate = new Plate(mockContext);
    }

    @Test
    public void onClick_BadInput() {
        act.findViewById(R.id.scoop_it_btn).performClick();
        assertEquals("Can't do something with nothing.\nWhere's the tuna?",
                ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void onClick_GoodInput() {
        ((EditText) act.findViewById(R.id.eat_in)).setText(50);
        ((EditText) act.findViewById(R.id.scoop_in)).setText(45);
        act.findViewById(R.id.scoop_it_btn).performClick();
        assertEquals("5 tuna on the plate.",
                act.findViewById(R.id.plated));
    }
}