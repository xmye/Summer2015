package HFMcode;

//�����������ʵ����
public class HffmanCoding {
	private int charsAndWeight[][];// [][0]�� �ַ���[][1]��ŵ����ַ���Ȩֵ��������
	private int hfmcoding[][];// ��Ź�������
	private int i = 0;// ѭ������
	private String hcs[];

	public HffmanCoding(int[][] chars) {
charsAndWeight = new int[chars.length][2];
charsAndWeight = chars;
hfmcoding=new int[2 * chars.length - 1][4];
//Ϊ������������ռ�
}

	public void coding() {
int n = charsAndWeight.length;
if (n == 0)
return;
int m = 2 * n - 1;
// ��ʼ����������
for (i = 0; i < n; i++) {
hfmcoding[i][0] = charsAndWeight[i][1];// ��ʼ������������Ȩֵ
hfmcoding[i][1] = 0;// ��ʼ�����������ĸ��ڵ�
hfmcoding[i][2] = 0;// ��ʼ����������������
hfmcoding[i][3] = 0;// ��ʼ�������������Һ���
}
for (i = n; i < m; i++) {
hfmcoding[i][0] = 0;// ��ʼ������������Ȩֵ
hfmcoding[i][1] = 0;// ��ʼ�����������ĸ��ڵ�
hfmcoding[i][2] = 0;// ��ʼ����������������
hfmcoding[i][3] = 0;// ��ʼ�������������Һ���
}
// ������������
for (i = n; i < m; i++) {
int s1[] = select(i);// �ڹ��������в���˫��Ϊ��� weight��С�Ľڵ�
hfmcoding[s1[0]][1] = i;// Ϊ����������Сֵ��˫��
hfmcoding[s1[1]][1] = i;
hfmcoding[i][2] = s1[0];// �½ڵ������
hfmcoding[i][3] = s1[1];// �½ڵ���Һ���
hfmcoding[i][0] = hfmcoding[s1[0]][0] + hfmcoding[s1[1]][0];// �½ڵ��Ȩֵ�����Һ��ӵ�Ȩֵ֮��
}
}

	// ����˫��Ϊ��� weight��С�Ľڵ�
	private int[] select(int w) {
// TODO Auto-generated method stub
int s[] = { -1, -1 }, j = 0;// s1 ��СȨֵ��˫��Ϊ��Ľڵ����� �� i ��ѭ������
int min1 = 32767, min2 = 32767;
for (j = 0; j < w; j++) {
if (hfmcoding[j][1] == 0) {// ֻ����δ����������Ľ���в��ң�˫��Ϊ��Ľڵ㣩
if (hfmcoding[j][0] < min1) {
min2 = min1;
s[1] = s[0];
min1 = hfmcoding[j][0];
s[0] = j;
} else if (hfmcoding[j][0] < min2) {
min2 = hfmcoding[j][0];
s[1] = j;
}
}
}
return s;
}

	public String[] CreateHCode() {// ���ݹ������������������
int n = charsAndWeight.length;
int i, f, c;
String hcodeString = "";
hcs = new String[n];
for (i = 0; i < n; i++) {// ���ݹ������������������
c = i;
hcodeString = "";
f = hfmcoding[i][1]; // f ���������ĸ��ڵ�
while (f != 0) {// ѭ��ֱ���������
if (hfmcoding[f][2] == c) {// �������ӽ��
hcodeString += "0";
} else {
hcodeString += "1";
}
c = f;
f = hfmcoding[f][1];
}
hcs[i] = new String(new StringBuffer(hcodeString).reverse());
}
return hcs;
}

	public String show(String s) {// ���ַ�����ʾ����
String textString = "";
char c[];
int k = -1;
c = new char[s.length()];
c = s.toCharArray();// ���ַ���ת��Ϊ�ַ�����
for (int i = 0; i < c.length; i++) {
k = c[i];
for (int j = 0; j < charsAndWeight.length; j++)
if (k == charsAndWeight[j][0])
textString += hcs[j];
}
return textString;
}

	// ���������뷴����
	public String reCoding(String s) {
	String text = "";// ��ŷ��������ַ�
int k = 0, m = hfmcoding.length - 1;// �Ӹ��ڵ㿪ʼ��ѯ
char c[];
c = new char[s.length()];
c = s.toCharArray();
k = m;
for (int i = 0; i < c.length; i++) {
if (c[i] == '0') {
k = hfmcoding[k][2];// k��ֵΪ���ڵ����ӵ����
if (hfmcoding[k][2] == 0 && hfmcoding[k][3] == 0)// �ж��ǲ���Ҷ�ӽڵ㣬���������Һ��Ӷ�Ϊ�㣩
{
text += (char) charsAndWeight[k][0];
k = m;
}
}
if (c[i] == '1') {
k = hfmcoding[k][3];// k��ֵΪ���ڵ��Һ��ӵ����
if (hfmcoding[k][2] == 0 && hfmcoding[k][3] == 0)// �ж��ǲ���Ҷ�ӽڵ㣬���������Һ��Ӷ�Ϊ�㣩
{
text += (char) charsAndWeight[k][0];
k = m;
}
}
}
return text;
}
}
