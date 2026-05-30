package views.validator;


public interface IValidator<T> {

	public void validate(T input) throws IllegalArgumentException;
}