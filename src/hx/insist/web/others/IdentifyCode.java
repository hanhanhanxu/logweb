package hx.insist.web.others;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class identifyUtils
 */
@WebServlet("/IdentifyCode")
public class IdentifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final int WIDTH = 120;
	public static final int HEIGHT = 25;

    public IdentifyCode() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
		Graphics g =  image.getGraphics();
		
		
		//1.���ñ���ɫ
		setBackGround(g);
		
		//2.���ñ߿�
		setBorder(g);
		
		//3.��������
		drawRandomLine(g);
		
		//4.д�����  ������
		String checkcode2 = drawRandomNum((Graphics2D)g);
		request.getServletContext().setAttribute("checkcode2", checkcode2);
		//5.ͼ��д�������
		response.setContentType("image/jpeg");//Ĭ���ı���ʽ��,�����������ͼƬ��ʽ��
		//��ͷ�����������Ҫ����
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);//ʹ�ô�ͼ�������ĵ����к���ͼ�β�����ʹ�����ָ������ɫ�� 
		g.fillRect(0, 0, WIDTH, HEIGHT);//x���� y���� ��� �߶�
		
	}
	
	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);//�߿����ű�
		
	}
	
	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		
		for(int i=0;i<5;i++) {
			int x1 = new Random().nextInt(WIDTH-2) + 1;//0-120֮������� 0-118 1-119 �����߿�
			int y1 = new Random().nextInt(HEIGHT-2) + 1;
			
			int x2 = new Random().nextInt(WIDTH-2) + 1;
			int y2 = new Random().nextInt(HEIGHT-2) + 1;
			
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private String drawRandomNum(Graphics2D g) {
		StringBuilder me = new StringBuilder();
		
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD,20));// ����ͼ�������ĵ���������Ϊָ�����塣
		
		//��������:[\u4e00-\u9fa5]   \\u��ʱUnicode
		String base = "79884654896465387489964896645618964456132122303789040464";
		int x = 15;
		for(int i=0;i<4;i++) {
			
			int degree = new Random().nextInt(60)-30;//��ת�Ķ���
			
			//�����Ϊ0 ~ legnth-1  
			//charAt :����ָ���������� char ֵ�� ���еĵ�һ�� char ֵλ������ 0 ��
			String ch = base.charAt(new Random().nextInt(base.length()))+"";//���ڶ຺��������ҵ�һ������
			
			g.rotate(degree*Math.PI/180,x,20);//������ת�Ļ���
			
			g.drawString(ch, x, 20);//д��ȥ
			
			g.rotate(-degree*Math.PI/180,x,20);//��ת��ȥ����Ӱ����һ��
			x = x + 25;//�ִ�С��20
			
			//15 + 20 + 5 = 30  *  4  =  120
			//ȷ�����岻��ת��ȥ�������ཻ
			
	
			me.append(ch);//������֤��	
		}
		//System.out.println(me.toString());//��֤��������
		return me.toString();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
