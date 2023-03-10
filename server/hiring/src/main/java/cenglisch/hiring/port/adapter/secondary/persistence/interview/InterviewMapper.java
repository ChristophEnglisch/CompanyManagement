package cenglisch.hiring.port.adapter.secondary.persistence.interview;

import cenglisch.hiring.domain.model.interview.Interview;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface InterviewMapper {

    @Mapping(source = "id", target = "interviewId.id")
    @Mapping(source = "candidateId", target = "candidateId.id")
    Interview mapToInterview(InterviewEntity interviewEntity);

    @Mapping(source = "interviewId.id", target = "id")
    @Mapping(source = "candidateId.id", target = "candidateId")
    InterviewEntity mapToInterviewEntity(Interview interview);
}
