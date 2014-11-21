package sh.calaba.espressobackend.query.ast;

@SuppressWarnings("serial")
public class InvalidUIQueryException extends RuntimeException {

	public InvalidUIQueryException(String query) {
		super(query);
	}

}
