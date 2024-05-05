package tdea.construccion2.appVeterinary.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Service.LoginService;
import tdea.construccion2.appVeterinary.Validator.PersonValidator;

@Component
public class LoginController {

	private static Scanner reader = new Scanner(System.in);
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private LoginService loginService;
	@Autowired
	private VeterinarianController veterinarianController;
	@Autowired
	private AdministratorController administratorController;
	@Autowired
	private SellerController sellerController;

	public void login() throws Exception {
		System.out.println("ingrese su usuario");
		String userName = reader.nextLine();
		personValidator.userNameValidador(userName);
		System.out.println("ingrese su contraseña");
		String password = reader.nextLine();
		personValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(userName, password);
		loginService.login(personDto);
		loginRouter(personDto);
		loginService.logout(0);
	}

	private void loginRouter(PersonDto personDto) {
		String option = personDto.getRole();
		switch (option) {
		case "Administrador": {
			administratorController.session();
			break;
		}
		case "Medico Veterinario": {
			veterinarianController.session();
			break;
		}
		case "Vendedor": {
			sellerController.session();
			break;
		}
		default: {
			System.out.println("☠Ingrese una opcion valida");
			break;
		}

		}
	}

	public PersonValidator getPersonValidator() {
		return personValidator;
	}

	public void setPersonValidator(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public VeterinarianController getVeterinarianController() {
		return veterinarianController;
	}

	public void setVeterinarianController(VeterinarianController veterinarianController) {
		this.veterinarianController = veterinarianController;
	}

	public AdministratorController getAdministratorController() {
		return administratorController;
	}

	public void setAdministratorController(AdministratorController administratorController) {
		this.administratorController = administratorController;
	}

	public SellerController getSellerController() {
		return sellerController;
	}

	public void setSellerController(SellerController sellerController) {
		this.sellerController = sellerController;
	}

}
