package HFMcode;
import java.util.ArrayList;
import java.util.HashMap;

public class HFMTree {
	/**
	 * �����ַ����ִ������õ�Ȩֵ
	 * @param str
	 * @param charArray
	 */
	public void countWeight(String str, int[] charArray) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			charArray[c]++;// �����ַ�ASC�룬����Ӧ�ַ�Ȩֵ����
		}
	}

	/**
	 * ����Ȩֵ���ɽڵ㣬�����뵽�ڵ�������
	 * @param charArray
	 * @param arrayNode
	 */
	public void add(int[] charArray, ArrayList<Node> arrayNode) {
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != 0) {			
				int weight = charArray[i];
				char ch = (char) i;//�ַ�
				Node newnode = new Node(ch, weight);
				arrayNode.add(newnode);
				System.out.println(ch+"      "+weight);
			}
		}
	}
	
	/**
	 * ����
	 * @param arrayNode
	 * @return
	 */
	public ArrayList<Node> sort(ArrayList<Node> arrayNode) {
		for (int i = 0; i < arrayNode.size(); i++) {
			for (int j = 0; j < arrayNode.size() - i - 1; j++) {
				if (arrayNode.get(j).getWeight() > arrayNode.get(j + 1)
						.getWeight()) {
					Node temp=arrayNode.get(j+1);
					arrayNode.set(j+1, arrayNode.get(j));
					arrayNode.set(j,temp);
				}
			}
		}
		return arrayNode;
	}

	/**
	 * �ϲ��ڵ㣬�����½ڵ㣬ֱ��ֻ��һ���ڵ�
	 */
	public ArrayList<Node> merge(ArrayList<Node> arrayNode) {
		for (int i = 0; arrayNode.size()>1; i++) {	
			//����
			arrayNode = sort(arrayNode);
			//�ϲ�
			String temp = arrayNode.get(0).getData().toString();
			temp = temp + arrayNode.get(1).getData().toString();
			int weight = arrayNode.get(0).getWeight()
					+ arrayNode.get(1).getWeight();
			Node newnode = new Node(temp, weight);
			//�������ҽڵ�
			newnode.setLeft(arrayNode.get(0));
			newnode.setRight(arrayNode.get(1));
			System.out.println(arrayNode.get(0).getData()+"      "+arrayNode.get(1).getData());
			//ɾ���ڵ�
			arrayNode.remove(0);
			arrayNode.remove(0);
			//��������ɵĽڵ�
			arrayNode.add(newnode);
		}
		return arrayNode;
	}

	/**
	 * ǰ����������й���������
	 * @param args
	 */
	public void PreOrderTraverse(Node root){
		//��ֹ��ָ���쳣����ֹ����
		if(root!=null){
		System.out.println(root.getData().toString());
		PreOrderTraverse(root.getLeft());
		PreOrderTraverse(root.getRight());	
		}
	}
	/**
	 * ���б���
	 * @param args
	 * @return 
	 */
	public HashMap<Character, String> hfmCode(Node root){
		HashMap<Character, String> map=new HashMap<Character, String>();//�洢Ҷ�ӽڵ㼰�����
		if(root!=null){
		if(root.getLeft()!=null){
			StringBuffer stl=new StringBuffer();//�ض���һ��stl����ֹ�ı�root��code
			stl.append(root.getCode());//���游�ڵ�ı���
			root.getLeft().setCode(stl.append(0));
//			System.out.println(root.getLeft().getData().toString());
//			System.out.println(root.getLeft().getCode());
		}
		if(root.getRight()!=null){
			StringBuffer str=new StringBuffer();
			str.append(root.getCode());
			root.getRight().setCode(str.append(1));
//			System.out.println(root.getRight().getData().toString());
//			System.out.println(root.getRight().getCode());
		}
		hfmCode(root.getLeft());
		hfmCode(root.getRight());
		if(root.getLeft()==null&&root.getRight()==null){
		//�õ�Ҷ�ӽڵ�ı��룬����ѹ��
		System.out.println(root.getData().toString()+"        "+root.getCode().toString());
		int[] leafArray=new int[255];
		char c=root.getData().toString().charAt(0);
		map.put(c, root.getCode().toString());		
		}
	}
		return map;
}
	/**
	 * ���й�����ѹ��
	 * @param args
	 */
	public void compress(String str,HashMap<Character, String> map){
		String[] codeStr=new String[200];
		for(int i=0;i<str.length();i++){
			char s=str.charAt(i);
			codeStr[i]=map.get(s);
			System.out.println(codeStr[i]);
		}
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<Node> arrayNode = new ArrayList<Node>();// 
		String str = "asfsfwsdcasefwsdcsdaedas";//Դ�ַ���
		int[] charArray = new int[255];
		HFMTree hfm = new HFMTree();
		hfm.countWeight(str, charArray);
		hfm.add(charArray, arrayNode);
		ArrayList<Node> newNode=hfm.merge(arrayNode);
		Node root=newNode.get(0);
		hfm.PreOrderTraverse(root);
		 HashMap<Character, String> map=hfm.hfmCode(root);
		 hfm.compress(str, map);
		System.out.println(newNode.get(0).getData().toString());	
	}
}
