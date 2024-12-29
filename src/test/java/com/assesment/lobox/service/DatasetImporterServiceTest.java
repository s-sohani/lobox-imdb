package com.assesment.lobox.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatasetImporterServiceTest {

    @Autowired
    private DatasetImporterService datasetImporterService;

    @Test
    public void test_convertToInteger_inputInt_returnOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToInteger", String.class);
        privateMethod.setAccessible(true);
        Integer res = (Integer) privateMethod.invoke(datasetImporterService, "12");
        assertEquals(12, res);
    }

    @Test
    public void test_convertToInteger_InvalidInput_returnNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToInteger", String.class);
        privateMethod.setAccessible(true);
        Integer res = (Integer) privateMethod.invoke(datasetImporterService, "12a");
        assertNull(res);
    }

    @Test
    public void test_convertToBoolean_inputBoolean_returnOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToBoolean", String.class);
        privateMethod.setAccessible(true);
        Boolean res = (Boolean) privateMethod.invoke(datasetImporterService, "false");
        assertFalse(res);
    }

    @Test
    public void test_convertToBoolean_InvalidInput_returnFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToBoolean", String.class);
        privateMethod.setAccessible(true);
        Boolean res = (Boolean) privateMethod.invoke(datasetImporterService, "12a");
        assertFalse(res);
    }

    @Test
    public void test_convertToDouble_inputDouble_returnOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToDouble", String.class);
        privateMethod.setAccessible(true);
        Double res = (Double) privateMethod.invoke(datasetImporterService, "12.23");
        assertEquals(12.23d, res);
    }

    @Test
    public void test_convertToDouble_InvalidInput_returnNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("convertToDouble", String.class);
        privateMethod.setAccessible(true);
        Double res = (Double) privateMethod.invoke(datasetImporterService, "12a");
        assertNull(res);
    }
}