package Runners;

import com.ea.Framework.Config.Settings;
import com.ea.Framework.Utilities.CucumberUtil;
import cucumber.api.CucumberOptions;


import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberTagStatement;
import jxl.read.biff.BiffException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CucumberOptions(features = {"src\\test\\java\\Features\\"},glue = {"Steps"},format = {"json:target/cucumber-json-report.json","html:target/cucumber-report-html"})
public class TestRunner  {
    private TestNGCucumberRunner testNGCucumberRunner;
    public TestRunner() throws IOException, BiffException {
    }

    @BeforeClass(alwaysRun =true)
    public void setUpClass()
    {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }


   @Test(dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) throws IOException, BiffException {
        ArrayList<String> FeatureList= CucumberUtil.getFeaturetoRun("C:\\UdemyCourse_1\\FeatureList.xls");


        List<CucumberTagStatement> elements =  cucumberFeatureWrapper.getCucumberFeature().getFeatureElements();
       for(Iterator<CucumberTagStatement> element = elements.iterator();element.hasNext();)

       {
           CucumberTagStatement scenarioName = element.next();
           for(int i=0;i<FeatureList.size();i++)
           {
               if(scenarioName.getVisualName().equals(FeatureList.get(i)))
               {
                   element.remove();
               }

               Settings.ScenarioContext = scenarioName.getVisualName();

           }
           Settings.FeatureContext= cucumberFeatureWrapper.getCucumberFeature().getGherkinFeature().getName();

           //testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());


       }
       testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());



    }
    @DataProvider
    public Object [][] features()

    {
        return testNGCucumberRunner.provideFeatures();
    }
    @AfterClass(alwaysRun = true)

    public void  afterclass()
    {
        testNGCucumberRunner.finish();
    }

}
