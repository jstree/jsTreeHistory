package egovframework.com.ext.jstree.springiBatis.core.constant;

public enum ExecutionOrder {
	BEFORE("executeBefore"), AFTER("executeAfter"), AROUND("executeAround");
	private final String value;

	private ExecutionOrder(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
