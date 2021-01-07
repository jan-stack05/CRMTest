package com.qa.web.testcases;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunnerClass {


		public static void main(String[] args) {
		    TestListenerAdapter tla = new TestListenerAdapter();
		    TestNG testng = new TestNG();
		    List<String> suites = Lists.newArrayList();
		    suites.add("/home/ankita/eclipse-workspace/CRMTest/testng.xml");//path to xml..
		  //  suites.add("c:/tests/testng2.xml");
		    testng.setTestSuites(suites);
		    testng.run();
		}

}
