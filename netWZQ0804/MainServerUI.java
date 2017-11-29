package netWZQ0804;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainServerUI {
	private Chatserver cserver; // ����������
	private JFrame jf; // �������
	private JTextField jt_msg;// ������Ϣ�����
	private JTextField jt_port;// �������˿ں������
	private JButton jbcontrol;// ��ͣ�������İ�ť
	
	public static void main(String[] args){
		MainServerUI m=new MainServerUI();
		m.showUI();
	}
	
			public void showUI(){
				jf=new JFrame("�������������");
				jf.setSize(300,100);
				FlowLayout fl=new FlowLayout();				//������ϲ��ֹ�����
				jf.setLayout(fl);
				
				JLabel jlport=new JLabel("�������˿�");
				jf.add(jlport);
				jt_port=new JTextField(5);				//�˿�����ˣ�������������������Ϊ�ַ���
				jf.add(jt_port);	
				jbcontrol=new JButton("����������");
				jf.add(jbcontrol);
				jbcontrol.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionServer();
					}
				});
				jf.setVisible(true);
				jf.setDefaultCloseOperation(3);				//����ر�ʱ�������˳�
			}
		
				//��Ӧ������ֹͣ��ť
			private void actionServer(){
				//�õ�������״̬
				if(null==cserver){
					String sPort=jt_port.getText();//�õ�����Ķ˿ں�
					int port=Integer.parseInt(sPort);//��String����ת��Ϊint������port��Ϊ��������
					
					cserver=new Chatserver(port);//��������������Ķ���
					cserver.start();								//����������
					
					jf.setTitle("�����������������������");
					jbcontrol.setText("stop!");				//���ð�ť������
				}
			    	else if(cserver.isruning()){//��������
					cserver.stopChatserver();			//�رշ�����
					cserver=null;
					
					jf.setTitle("���������������ֹͣ");
					
					jbcontrol.setText("start");
				}
			}
}
