package douban.frame;
/*
 * ��ѯ�Ի���
 * 
 */


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.JSONException;

import douban.myclass.Book;
import douban.pro.AnalysisData;

public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox jComboBox=null;
	JTextField jTextField=null;
	JButton jButton=null;
	public MainFrame() {
		setLocation(500, 250);
		setSize(500, 250);
		setVisible(true);
		setTitle("����������������������200905070408");
		init();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void init() {
		// TODO Auto-generated method stub
		setLayout(new FlowLayout());
		jComboBox=new JComboBox();
		jComboBox.addItem("�����");
		jComboBox.addItem("ISBN");
		jComboBox.addItem("�ؼ���");
		jTextField=new JTextField(20);
		jButton=new JButton("����");
		add(jComboBox);
		add(jTextField);
		add(jButton);
		
		jButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String url;
		String result;
		if(jComboBox.getSelectedIndex()==0){
				int book_id;
				try {
					book_id=Integer.parseInt(jTextField.getText());
					url="https://api.douban.com/v2/book/"+book_id;
					AnalysisData analysisData=new AnalysisData();
					result=analysisData.getApiData(url);
					Book book=analysisData.GetBookInfo(result);
					JOptionPane.showMessageDialog(this, "������"+book.getTitle()+"\n"+
														"���ߣ�"+book.getAuthor()+"\n"+
														"�۸�"+book.getPrice()+"\n"+
														"ҳ����"+book.getPages()+"\n"+
														"�����磺"+book.getPublisher()+"\n"+
														"10λISBN��"+book.getIsbn10()+"\n"+
														"13λISBN��"+book.getIsbn13()+"\n"+
														"ͼ����ܣ�"+book.getSummary()+"\n"+
														"ͼƬ��ַ:"+book.getImage(), "�鼮��Ϣ��������������200905070408", JOptionPane.DEFAULT_OPTION);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "�����Ƿ�", "����", JOptionPane.WARNING_MESSAGE);
				} 
		}
		else{
			JOptionPane.showMessageDialog(this, "�����Ƿ�", "����", JOptionPane.WARNING_MESSAGE);
		}
	}


}
