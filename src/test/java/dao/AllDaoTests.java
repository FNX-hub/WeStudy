package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ParentDaoTest.class, ProfessorDaoTest.class, StudentDaoTest.class})
public class AllDaoTests {

}
