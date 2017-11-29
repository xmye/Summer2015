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
	private Chatserver cserver; // 服务器对象
	private JFrame jf; // 管理界面
	private JTextField jt_msg;// 发送消息输入框
	private JTextField jt_port;// 服务器端口号输入框
	private JButton jbcontrol;// 启停服务器的按钮
	
	public static void main(String[] args){
		MainServerUI m=new MainServerUI();
		m.showUI();
	}
	
			public void showUI(){
				jf=new JFrame("服务器界面管理");
				jf.setSize(300,100);
				FlowLayout fl=new FlowLayout();				//界面加上布局管理器
				jf.setLayout(fl);
				
				JLabel jlport=new JLabel("服务器端口");
				jf.add(jlport);
				jt_port=new JTextField(5);				//端口输入端，传入列数，输入类型为字符串
				jf.add(jt_port);	
				jbcontrol=new JButton("启动服务器");
				jf.add(jbcontrol);
				jbcontrol.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionServer();
					}
				});
				jf.setVisible(true);
				jf.setDefaultCloseOperation(3);				//界面关闭时，程序退出
			}
		
				//响应启动，停止按钮
			private void actionServer(){
				//得到服务器状态
				if(null==cserver){
					String sPort=jt_port.getText();//得到输入的端口号
					int port=Integer.parseInt(sPort);//将String类型转化为int，便于port作为参数传入
					
					cserver=new Chatserver(port);//创建管理服务器的对象
					cserver.start();								//创建服务器
					
					jf.setTitle("服务器管理程序：正在运行中");
					jbcontrol.setText("stop!");				//重置按钮的内容
				}
			    	else if(cserver.isruning()){//正在运行
					cserver.stopChatserver();			//关闭服务器
					cserver=null;
					
					jf.setTitle("服务器管理程序：已停止");
					
					jbcontrol.setText("start");
				}
			}
}
