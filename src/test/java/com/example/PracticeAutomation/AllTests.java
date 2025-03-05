package com.example.PracticeAutomation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BrokenLinks.class, ClickEvents.class, FormFields.class })
public class AllTests {

}
