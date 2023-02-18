package cenglisch.hiring.port.adapter.secondary.database.candidate;

import cenglisch.hiring.domain.candidate.Candidate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CandidateMapper {
    @Mapping(source = "id", target = "candidateId.id")
    @Mapping(source = "personId", target = "personId.id")
    @Mapping(source = "jobId", target = "jobId.id")
    Candidate mapToCandidate(CandidateEntity candidateEntity);
    @Mapping(source = "candidateId.id", target = "id")
    @Mapping(source = "personId.id", target = "personId")
    @Mapping(source = "jobId.id", target = "jobId")
    CandidateEntity mapToCandidateEntity(Candidate candidate);
}
