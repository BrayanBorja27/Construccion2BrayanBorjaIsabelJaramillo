package tdea.construccion2.appVeterinary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tdea.construccion2.appVeterinary.Controller.request.CreateUserRequest;
import tdea.construccion2.appVeterinary.Controller.response.CreateUserResponse;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Service.AdministratorService;
import tdea.construccion2.appVeterinary.Validator.PersonValidator;

@RestController
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private PersonValidator personValidator;


    @PostMapping("/user")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        long id;
        try {
            id = personValidator.idValidator(request.getId());
            personValidator.nameValidador(request.getFullName());
            personValidator.passwordValidator(request.getPassword());
            personValidator.userNameValidador(request.getUserName());
            personValidator.roleValidator(request.getRole());

        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        try {
            PersonDto personDto = new PersonDto(id, request.getFullName(), request.getRole(), request.getUserName(),
                    request.getPassword());
            administratorService.createVeterinarian(personDto);
            response.setMessage("usuario creado ");
            response.setId(request.getId());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(response);

        }
    }

    public AdministratorService getAdministratorService() {
        return administratorService;
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    public PersonValidator getPersonValidator() {
        return personValidator;
    }

    public void setPersonValidator(PersonValidator personValidator) {
        this.personValidator = personValidator;
    }
}
