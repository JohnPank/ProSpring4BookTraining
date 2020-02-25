package com.johnpank.prospring4.chapter13.service;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class ServiceTestExecutionListener implements TestExecutionListener {

    private IDatabaseTester iDatabaseTester;

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (iDatabaseTester != null) {
            iDatabaseTester.onTearDown();
        }
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        DataSets dataSetsAnnotation = testContext.getTestMethod().getAnnotation(DataSets.class);
        if (dataSetsAnnotation == null) {
            return;
        }
        String dataSetName = dataSetsAnnotation.setUpDataSet();
        if(!dataSetName.equals("")){
            iDatabaseTester = (IDatabaseTester) testContext.getApplicationContext().getBean("databaseTester");
            XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader) testContext.getApplicationContext().getBean("xlsDataFileLoader");
            IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
            iDatabaseTester.setDataSet(dataSet);
            iDatabaseTester.onSetup();
        }
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
    }

}
