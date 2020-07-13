package snake2D;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SnakeTest {
	@Test
	void TestgetDirection() {
		Snake testsnake = new Snake();
		assertEquals(testsnake.getDirection(), 3);
	}
	
	@Test
	void TestgetHead() {
		Snake testsnake = new Snake();
		assertEquals(testsnake.getHead().x, 355);
		assertEquals(testsnake.getHead().y, 191);
	}
	
	@Test
	void TestgetLength() {
		Snake testsnake = new Snake();
		assertEquals(testsnake.getLength(), 5);
	}
	
	@Test
	void TestsetDirection() {
		Snake testsnake = new Snake();
		//snake begin with direction==3
		testsnake.setDirection(4);
		assertEquals(testsnake.getDirection(), 3);
		testsnake.setDirection(1);
		
		testsnake.setDirection(2);
		assertEquals(testsnake.getDirection(), 1);
		testsnake.setDirection(4);
		
		testsnake.setDirection(3);
		assertEquals(testsnake.getDirection(), 4);
		testsnake.setDirection(2);
		
		testsnake.setDirection(1);
		assertEquals(testsnake.getDirection(), 2);
	}
	
	@Test
	void Testmove() {
		Snake testsnake = new Snake();
		double[][] arr = new double[5][2];
		ArrayList<Ellipse2D.Double> snakebody;
		snakebody = testsnake.getSnakeBody();
		for (int i=0;i<5;i++) {
			arr[i][0] = snakebody.get(i).x;
			arr[i][1] = snakebody.get(i).y;
		}
		testsnake.move();snakebody = testsnake.getSnakeBody();
		assertEquals(testsnake.getHead().x,355+16);assertEquals(testsnake.getHead().y,191);
		for (int i=1;i<5;i++) {
			assertEquals(snakebody.get(i).x,arr[i-1][0]);assertEquals(snakebody.get(i).y,arr[i-1][1]);
		}
		
		testsnake = new Snake();testsnake.setDirection(1);testsnake.move();
		assertEquals(testsnake.getHead().x,355);assertEquals(testsnake.getHead().y,191-16);
		for (int i=1;i<5;i++) {
			assertEquals(snakebody.get(i).x,arr[i-1][0]);assertEquals(snakebody.get(i).y,arr[i-1][1]);
		}
		testsnake = new Snake();testsnake.setDirection(2);testsnake.move();
		assertEquals(testsnake.getHead().x,355);assertEquals(testsnake.getHead().y,191+16);
		for (int i=1;i<5;i++) {
			assertEquals(snakebody.get(i).x,arr[i-1][0]);assertEquals(snakebody.get(i).y,arr[i-1][1]);
		}
		
		testsnake.setDirection(4);testsnake.move();
		assertEquals(testsnake.getHead().x,355-16);assertEquals(testsnake.getHead().y,191+16);
	}
	
	@Test
	void TesteatShrinker() {
		Snake testsnake = new Snake();
		ArrayList<Ellipse2D.Double> snakebody;
		testsnake.move();testsnake.eatShrinker();
		snakebody = testsnake.getSnakeBody();
		assertEquals(testsnake.getLength(),5-1);
		assertEquals(testsnake.getHead().x,355+16);assertEquals(testsnake.getHead().y,191);
		assertEquals(snakebody.get(1).x,355);assertEquals(snakebody.get(1).y,191);
		assertEquals(snakebody.get(2).x,355-16);assertEquals(snakebody.get(2).y,191);
		assertEquals(snakebody.get(3).x,355-32);assertEquals(snakebody.get(3).y,191);
	}
	
	@Test
	void Testeat() {
		Snake testsnake = new Snake();
		ArrayList<Ellipse2D.Double> snakebody;
		testsnake.move();testsnake.eat();
		snakebody = testsnake.getSnakeBody();
		assertEquals(testsnake.getLength(),5+1);
		assertEquals(testsnake.getHead().x,355+16);assertEquals(testsnake.getHead().y,191);
		assertEquals(snakebody.get(1).x,355);assertEquals(snakebody.get(1).y,191);
		assertEquals(snakebody.get(2).x,355-16);assertEquals(snakebody.get(2).y,191);
		assertEquals(snakebody.get(3).x,355-32);assertEquals(snakebody.get(3).y,191);
		assertEquals(snakebody.get(4).x,355-48);assertEquals(snakebody.get(4).y,191);
	}
}
