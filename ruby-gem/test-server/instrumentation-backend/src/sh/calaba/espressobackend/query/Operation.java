package sh.calaba.espressobackend.query;

public interface Operation {

	public Object apply(Object o) throws Exception;
	public String getName();
}
