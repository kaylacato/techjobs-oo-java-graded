package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void emptyTest() {
        assertEquals(1, 1);
    }

    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();

        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
       Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String expectedOutput = "\nID: " + testJob1.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n" ;
       String actualOutput = testJob1.toString();

       assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringHandlesEmptyField() {
      Job testJob1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedOutput = "\nID: " + testJob1.getId() + "\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n" ;
        String actualOutput = testJob1.toString();

        assertEquals(expectedOutput, actualOutput);
    }
}
