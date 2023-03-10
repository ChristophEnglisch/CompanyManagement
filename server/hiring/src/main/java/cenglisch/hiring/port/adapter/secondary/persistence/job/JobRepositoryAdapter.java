package cenglisch.hiring.port.adapter.secondary.persistence.job;

import cenglisch.hiring.domain.model.job.Job;
import cenglisch.hiring.domain.model.job.JobId;
import cenglisch.hiring.domain.model.job.JobRepository;
import cenglisch.hiring.port.adapter.secondary.persistence.person.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobRepositoryAdapter implements JobRepository {

    @Autowired
    private JobJpaRepository jobJpaRepository;

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Autowired
    private JobMapper jobMapper;


    public Optional<Job> find(JobId id) {
        Optional<JobEntity> optionalJob = jobJpaRepository.findById(id.getId());
        return optionalJob.map(jobEntity -> jobMapper.mapToJob(jobEntity));
    }


    public Job save(Job job) {
        if (job.getJobId() == null){
            job.setJobId(new JobId(generateId()));
        }
        jobJpaRepository.saveAndFlush(
                jobMapper.mapToJobEntity(job, personJpaRepository)
        );
        return job;
    }

    @Override
    public void remove(Job job) {

    }

    public void delete(JobId id) {

    }
}
