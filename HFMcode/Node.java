package HFMcode;

public class Node {

	private Object data;
	private int weight;
	private Node left;
	private Node right;
	private	StringBuffer code=new StringBuffer();

	public StringBuffer getCode() {
		return code;
	}

	public void setCode(StringBuffer code) {
		this.code = code;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(Object data,int weight){
		super();
		this.data=data;
		this.weight=weight;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
}