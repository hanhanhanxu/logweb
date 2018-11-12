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
		
		
		//1.设置背景色
		setBackGround(g);
		
		//2.设置边框
		setBorder(g);
		
		//3.画干扰线
		drawRandomLine(g);
		
		//4.写随机数  并保存
		String checkcode2 = drawRandomNum((Graphics2D)g);
		request.getServletContext().setAttribute("checkcode2", checkcode2);
		//5.图形写给浏览器
		response.setContentType("image/jpeg");//默认文本方式打开,设置浏览器以图片形式打开
		//发头控制浏览器不要缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);//使用此图形上下文的所有后续图形操作均使用这个指定的颜色。 
		g.fillRect(0, 0, WIDTH, HEIGHT);//x坐标 y坐标 宽度 高度
		
	}
	
	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);//边框，沿着边
		
	}
	
	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		
		for(int i=0;i<5;i++) {
			int x1 = new Random().nextInt(WIDTH-2) + 1;//0-120之间随机数 0-118 1-119 不含边框
			int y1 = new Random().nextInt(HEIGHT-2) + 1;
			
			int x2 = new Random().nextInt(WIDTH-2) + 1;
			int y2 = new Random().nextInt(HEIGHT-2) + 1;
			
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private String drawRandomNum(Graphics2D g) {
		StringBuilder me = new StringBuilder();
		
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,20));// 将此图形上下文的字体设置为指定字体。
		
		//汉字区间:[\u4e00-\u9fa5]   \\u表时Unicode
		String base = "79884654896465387489964896645618964456132122303789040464";
		int x = 15;
		for(int i=0;i<4;i++) {
			
			int degree = new Random().nextInt(60)-30;//旋转的度数
			
			//随机数为0 ~ legnth-1  
			//charAt :返回指定索引处的 char 值。 序列的第一个 char 值位于索引 0 处
			String ch = base.charAt(new Random().nextInt(base.length()))+"";//从众多汉字中随机找到一个汉字
			
			g.rotate(degree*Math.PI/180,x,20);//设置旋转的弧度
			
			g.drawString(ch, x, 20);//写上去
			
			g.rotate(-degree*Math.PI/180,x,20);//再转回去，不影响下一个
			x = x + 25;//字大小是20
			
			//15 + 20 + 5 = 30  *  4  =  120
			//确保字体不会转出去。不会相交
			
	
			me.append(ch);//记忆验证码	
		}
		//System.out.println(me.toString());//验证码在这里
		return me.toString();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
