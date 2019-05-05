package project.junit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Class running all the available jUnit test in the application
 * @author a.vulchev
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	   TestUserMethods.class ,TestForumMethods.class
	})
public class SuitTestWholeApplication {
	//tests all classes
}
