package HFMcode;
import java.util.ArrayList;
import java.util.HashMap;

public class HFMTree {
	/**
	 * 根据字符出现次数，得到权值
	 * @param str
	 * @param charArray
	 */
	public void countWeight(String str, int[] charArray) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			charArray[c]++;// 根据字符ASC码，将对应字符权值增加
		}
	}

	/**
	 * 根据权值生成节点，并加入到节点序列中
	 * @param charArray
	 * @param arrayNode
	 */
	public void add(int[] charArray, ArrayList<Node> arrayNode) {
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != 0) {			
				int weight = charArray[i];
				char ch = (char) i;//字符
				Node newnode = new Node(ch, weight);
				arrayNode.add(newnode);
				System.out.println(ch+"      "+weight);
			}
		}
	}
	
	/**
	 * 排序
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
	 * 合并节点，生成新节点，直到只有一个节点
	 */
	public ArrayList<Node> merge(ArrayList<Node> arrayNode) {
		for (int i = 0; arrayNode.size()>1; i++) {	
			//排序
			arrayNode = sort(arrayNode);
			//合并
			String temp = arrayNode.get(0).getData().toString();
			temp = temp + arrayNode.get(1).getData().toString();
			int weight = arrayNode.get(0).getWeight()
					+ arrayNode.get(1).getWeight();
			Node newnode = new Node(temp, weight);
			//设置左右节点
			newnode.setLeft(arrayNode.get(0));
			newnode.setRight(arrayNode.get(1));
			System.out.println(arrayNode.get(0).getData()+"      "+arrayNode.get(1).getData());
			//删除节点
			arrayNode.remove(0);
			arrayNode.remove(0);
			//添加新生成的节点
			arrayNode.add(newnode);
		}
		return arrayNode;
	}

	/**
	 * 前序遍历并进行哈弗曼编码
	 * @param args
	 */
	public void PreOrderTraverse(Node root){
		//防止空指针异常，终止条件
		if(root!=null){
		System.out.println(root.getData().toString());
		PreOrderTraverse(root.getLeft());
		PreOrderTraverse(root.getRight());	
		}
	}
	/**
	 * 进行编码
	 * @param args
	 * @return 
	 */
	public HashMap<Character, String> hfmCode(Node root){
		HashMap<Character, String> map=new HashMap<Character, String>();//存储叶子节点及其编码
		if(root!=null){
		if(root.getLeft()!=null){
			StringBuffer stl=new StringBuffer();//重定义一个stl，防止改变root的code
			stl.append(root.getCode());//保存父节点的编码
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
		//得到叶子节点的编码，用于压缩
		System.out.println(root.getData().toString()+"        "+root.getCode().toString());
		int[] leafArray=new int[255];
		char c=root.getData().toString().charAt(0);
		map.put(c, root.getCode().toString());		
		}
	}
		return map;
}
	/**
	 * 进行哈弗曼压缩
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
		String str = "asfsfwsdcasefwsdcsdaedas";//源字符串
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
