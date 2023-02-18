import PersonalInformationDto from "@/person/PersonalInformationDto";

class PersonalInformationService {

    public deposePersonalInformation(personalInformation: PersonalInformationDto) : void {
        console.log(personalInformation.email)
    }

}export default new PersonalInformationService()