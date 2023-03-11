package cenglisch.hiring.domain.model.job;

import cenglisch.hiring.domain.job.exception.JobException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    @Test
    public void testCapacities() {
        int capacities = 5;
        final Job job = new Job("Anwendungsentwickler", capacities);
        for (int i = 0; i < capacities; i++) {
            assertTrue(job.isPublished());
            job.reduceCapacities();
        }
        assertFalse(job.isPublished());
    }

    @Test
    public void testPublishJobPosting() {
        Job job = new Job(new JobId("J-123123"), "Anwendungsentwickler", 10, false);
        job.publishJobPosting(1);
        assertTrue(job.isPublished());
        assertEquals(1, job.getNeededCapacities());


        job = new Job(new JobId("J-123123"), "Anwendungsentwickler", 10, false);
        job.publishJobPosting(5);
        assertTrue(job.isPublished());
        assertEquals(5, job.getNeededCapacities());

        job = new Job(new JobId("J-123123"), "Anwendungsentwickler", 10, false);
        Job finalJob = job;
        Exception exception = assertThrows(JobException.class, () -> {
            finalJob.publishJobPosting(0);
        });
        assertEquals(
                "job can not be published if needed capacities are lower than 1",
                exception.getMessage()
        );
    }

    @Test
    public void testSimpleConstructor(){
        Job job = new Job("Anwendungsentwickler", 0);
        assertFalse(job.isPublished());

        job = new Job("Anwendungsentwickler", 2);
        assertTrue(job.isPublished());
    }
}