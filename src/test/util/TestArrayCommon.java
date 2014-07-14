package test.util;

import static org.junit.Assert.fail;
import main.util.ArrayCommon;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayCommon {
    ArrayCommon test = new  ArrayCommon();

    @Test
    public void testAddArrayIntArrayInt() {
        int[] array = {1,2,3,4};
        int[] res = {1,2,3,4,0};
        Assert.assertArrayEquals(test.addArray(array, 0),  res);

        
//        fail("Not yet implemented");

    }

    @Test
    public void testAddArrayIntArrayIntArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testSwapArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testMaltipuleMatrixIntArrayArrayIntArrayArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testMaltipuleMatrixLongArrayArrayLongArrayArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testPrintMatrix() {
        fail("Not yet implemented");
    }

    @Test
    public void testPrintArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeepEqualsCharArrayCharArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeepEqualsIntArrayIntArray() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvIntArray() {
        fail("Not yet implemented");
    }

}
