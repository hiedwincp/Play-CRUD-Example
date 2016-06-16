package controllers;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import models.Computer;
import models.Person;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

/**
 * Manage a database of computers
 */
public class PersonController extends Controller {

	private FormFactory formFactory;

	@Inject
	public PersonController(FormFactory formFactory) {
		this.formFactory = formFactory;
	}

	/**
	 * This result directly redirect to application home.
	 */
	public Result GO_HOME = Results.redirect(routes.PersonController.list(""));

	/**
	 * Handle default path requests, redirect to computers list
	 */
	public Result index() {
		return GO_HOME;
	}

	/**
	 * Display the paginated list of computers.
	 *
	 * @param page
	 *            Current page number (starts from 0)
	 * @param sortBy
	 *            Column to be sorted
	 * @param order
	 *            Sort order (either asc or desc)
	 * @param filter
	 *            Filter applied on computer names
	 */
	public Result list(String filter) {
		return ok(views.html.perslist.render(Person.findAll(filter), filter));
	}

	/**
	 * Display the 'new Person form'.
	 */
	public Result create() {
		Form<Person> persForm = formFactory.form(Person.class);
		return ok(views.html.perscreateForm.render(persForm));
	}

	/**
	 * Handle the 'new Person form' submission
	 */
	public Result save() {
		Form<Person> persForm = formFactory.form(Person.class)
				.bindFromRequest();
		if (persForm.hasErrors()) {
			return badRequest(views.html.perscreateForm.render(persForm));
		}
		persForm.get().save();
		flash("success", "Person : " + persForm.get().name
				+ " has been created");
		return GO_HOME;
	}

	/**
	 * Display the 'edit form' of a existing Person.
	 *
	 * @param id
	 *            Id of the Person to edit
	 */
	public Result edit(Long id) {
		Form<Person> persForm = formFactory.form(Person.class).fill(
				Person.find.byId(id));
		return ok(views.html.perseditForm.render(id, persForm));
	}

	/**
	 * Handle the 'edit form' submission
	 *
	 * @param id
	 *            Id of the Person to edit
	 */
	public Result update(Long id) throws PersistenceException {
		Form<Person> persForm = formFactory.form(Person.class)
				.bindFromRequest();
		if (persForm.hasErrors()) {
			return badRequest(views.html.perseditForm.render(id, persForm));
		}

		Person savedPerson = Person.find.byId(id);
		if (savedPerson != null) {
			Person newPersonData = persForm.get();
			savedPerson.setName(newPersonData.getName());
			savedPerson.setCountry(newPersonData.getCountry());

			savedPerson.save();

			flash("success", "Person : " + persForm.get().name
					+ " has been updated");
		}

		return GO_HOME;
	}

	/**
	 * Handle Person deletion
	 */
	public Result delete(Long id) {
		Person.find.ref(id).delete();
		flash("success", "Person has been deleted");
		return GO_HOME;
	}
}
