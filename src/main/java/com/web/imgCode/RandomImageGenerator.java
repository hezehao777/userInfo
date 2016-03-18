package com.web.imgCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang.RandomStringUtils;


public class RandomImageGenerator {
	private RandomImageGenerator() {
		initCalculation();//初始化四则运算
	}

	public static RandomImageGenerator getInstance() {
		return new RandomImageGenerator();
	}

	private ByteArrayInputStream image;// 图像
	
	private	byte[] images;
	
	private String str;// 验证码
		

	public String getStr() {
		return str;
	}

	public ByteArrayInputStream getImage() {
		return image;
	}

	public void setImage(ByteArrayInputStream image) {
		this.image = image;
	}

	public String random() {
		// 因为o和0,l和1很难区分,所以,去掉大小写的o和l

		String str = "";
		// str = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";//
		// 初始化种子
		str = "1234567890";
		return RandomStringUtils.random(5, str);// 返回6位的字符串
	}

	public void init() {
		// if (num.getBytes().length > 6) {
		// throw new IllegalArgumentException(
		// "The length of param num cannot exceed 6.");
		// }
		// 设定宽度和高度
		int width = 80;// 130;

		int height = 30;
		// 在内存中创建图象
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics2D g = (Graphics2D) bi.getGraphics();
		// 画边框
		java.util.Random random = new java.util.Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		// 设置字体
		Font mFont = new Font("Tahoma", Font.BOLD, 14);// 16);
		g.setFont(mFont);
		g.setColor(Color.BLACK);// 设置字体颜色

		// 画认证码,每个认证码在不同的水平位置
		String str1[] = new String[5];// 6];
		String num = random();
		this.str = num;
		for (int i = 0; i < str1.length; i++) {
			str1[i] = num.substring(i, i + 1);
			int w = 0;
			int x = (i + 1) % 3;

			// 随即生成验证码字符的水平偏移量
			if (x == random.nextInt(3)) {
				w = 15 - random.nextInt(7);// 19 - random.nextInt(7);
			} else {
				w = 15 + random.nextInt(7);// 19 + random.nextInt(7);
			}

			// 随即生成颜色
			Color color1 = new Color(random.nextInt(180), random.nextInt(180), random.nextInt(180));
			g.setColor(color1);
			g.drawString(str1[i], 11 * i + 10, w);
		}

		// 随机产生干扰点,并用不同的颜色表示，使图象中的认证码不易被其它程序探测到
		// for (int i = 0; i < 100; i++) {
		// int x = random.nextInt(width);
		// int y = random.nextInt(height);
		// Color color1 = new Color(random.nextInt(255), random.nextInt(255),
		// random.nextInt(255));
		// g.setColor(color1); // 随即画各种颜色的点
		// g.drawOval(x, y, 0, 0);
		// }
		// // 画干扰线
		// for (int i = 0; i < 5; i++) {
		// int x = random.nextInt(width);
		// int y = random.nextInt(height);
		// int x1 = random.nextInt(width);
		// int y1 = random.nextInt(height);
		// Color color1 = new Color(random.nextInt(255), random.nextInt(255),
		// random.nextInt(255));
		//
		// g.setColor(color1); // 随即画各种颜色的线
		// g.drawLine(x, y, x1, y1);
		// }
		// 图像生效
		g.dispose();
		// 输出页面
		// ImageIO.write(bi, "jpg", out);
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
			ImageIO.write(bi, "JPEG", imageOut);
			imageOut.close();
			input = new ByteArrayInputStream(output.toByteArray());
			images=output.toByteArray();
		} catch (Exception e) {
			System.out.println("验证码图片产生出现错误：" + e.toString());
		}
		this.image = input;/* 赋值图像 */
	}

	private String createRandomCalculation(){
		String op = "+-x";		
		 
		java.util.Random random = new java.util.Random();
		int operand1 = random.nextInt(10);
		int operand2 = random.nextInt(10);
		String operator = "";
		
		operator = RandomStringUtils.random(1, op);
//		while(true){
//			if(operand2 == 0 && operator.equals("%")){
//				operand2 = random.nextInt(10);
//			}else{
//				break;
//			}
//		}
		
		int operat = op.indexOf(operator);
		switch(operat){
		case 0:
			this.str = String.valueOf(operand1 + operand2);
			break;
			
		case 1:
			int tmp;
			if(operand1 < operand2){
				tmp = operand1;
				operand1 = operand2;
				operand2 = tmp;
			}
			this.str = String.valueOf(operand1 - operand2);
			break;
			
		case 2:
			this.str = String.valueOf(operand1 * operand2);
			break;		
		}
		
		return String.valueOf(operand1) +  operator + String.valueOf(operand2) + "=?";
	}
	  
	/**
	 * 四则运算
	 */
	public void initCalculation() {
		
		// 设定宽度和高度
		int width = 80;// 130;

		int height = 30;
		// 在内存中创建图象
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics2D g = (Graphics2D) bi.getGraphics();
		// 画边框
		java.util.Random random = new java.util.Random();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		// 设置字体
		Font mFont = new Font("Tahoma", Font.BOLD, 14);// 16);
		g.setFont(mFont);
		g.setColor(Color.BLACK);// 设置字体颜色
		
		
		// 画认证码,每个认证码在不同的水平位置
		String str1[] = new String[5];//  
		String num = createRandomCalculation();;
		 
		for (int i = 0; i < str1.length; i++) {
			str1[i] = num.substring(i, i + 1);
			int w = 0;
			int x = (i + 1) % 3;

			// 随即生成验证码字符的水平偏移量
			if (x == random.nextInt(3)) {
				w = 15 - random.nextInt(7);// 19 - random.nextInt(7);
			} else {
				w = 15 + random.nextInt(7);// 19 + random.nextInt(7);
			}

			// 随即生成颜色
			Color color1 = new Color(random.nextInt(180), random.nextInt(180), random.nextInt(180));
			g.setColor(color1);
			g.drawString(str1[i], 11 * i + 10, w);
		}

		g.dispose();
		// 输出页面
		// ImageIO.write(bi, "jpg", out);
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
			ImageIO.write(bi, "JPEG", imageOut);
			imageOut.close();
			input = new ByteArrayInputStream(output.toByteArray());
			this.images=output.toByteArray();
		} catch (Exception e) {
			System.out.println("验证码图片产生出现错误：" + e.toString());
		}

		this.image = input;/* 赋值图像 */
	}

	
	public byte[] getImages() {
		return images;
	}


	public static void main(String[] args) throws IOException {
		// String num = random();
		// System.out.println(num);
		// render(num, new FileOutputStream("e:\\test.jpg"));
		// System.out.println("Image generated.");
	}

}