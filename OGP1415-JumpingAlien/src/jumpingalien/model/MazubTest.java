package jumpingalien.model;
import static jumpingalien.tests.util.TestUtils.spriteArrayForSize;
import static org.junit.Assert.*;
import jumpingalien.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MazubTest {
	Sprite[] sprites =  spriteArrayForSize(2, 2, 10 + 2 * 10);
	public Mazub newMazub = new Mazub(0,0,sprites); 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Correct_Set_PositionX() {
		newMazub.setCurrentPositionX(5);
		assertTrue (newMazub.getCurrentPositionX() == 5);
	}
	@Test
	public void Boundary_Set_PositionX(){
		newMazub.setCurrentPositionX(0);
		assertTrue (newMazub.getCurrentPositionX() == 0);
	}
	@Test(expected = IllegalPositionXException.class)
	public void Illegal_underflow_Set_positionX() throws Exception{
		newMazub.setCurrentPositionX(-100);
	}
	@Test(expected = IllegalPositionXException.class)
	public void Illegal_overflow_Set_positionX() throws Exception{
		newMazub.setCurrentPositionX(20);
	}
	@Test
	public void Correct_SetpositionY(){
		newMazub.setCurrentPositionY(5);
		assertTrue (newMazub.getCurrentPositionY() == 5);
	}
	@Test
	public void Boundary_SetpositionY(){
		newMazub.setCurrentPositionY(7.67);
		assertTrue (newMazub.getCurrentPositionY() == 7.67);
	}
	@Test (expected = IllegalPositionYException.class)
	public void Illegal_underflow_SetPositionY() throws Exception{
		newMazub.setCurrentPositionY(-.1);
	}
	@Test (expected = IllegalPositionYException.class)
	public void Illegal_overflow_SetPositionY() throws Exception{
		newMazub.setCurrentPositionY(7.68);
	}
	@Test
	public void Correct_setWidth(){
		newMazub.setWidth(200);
		assertEquals (newMazub.getWidth(),200);
	}
	@Test (expected = IllegalLengthException.class)
	public void Illegal_setWidth(){
		newMazub.setWidth(-200);
	}
	@Test
	public void Correct_setHeight(){
		newMazub.setHeight(200);
		assertEquals (newMazub.getHeight(),200);
	}
	@Test (expected = IllegalLengthException.class)
	public void Illegal_setHeight(){
		newMazub.setHeight(-200);
	}
	@Test
	public void CalculateNewSpeedX(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.setCurrentSpeedX((newMazub.getMaxSpeedX() + newMazub.getStartSpeedX())/2);
		newMazub.setCurrentAccelerationX(Mazub.getAccelerationX());
		assertTrue (newMazub.calculateNewSpeedX(0.1)<= (newMazub.getMaxSpeedX() + newMazub.getStartSpeedX())/2 + Mazub.getAccelerationX()+0.1);
	}
	@Test
	public void CalculateNewPositieX(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.setCurrentPositionX(1);
		newMazub.setCurrentSpeedX((newMazub.getMaxSpeedX() + newMazub.getStartSpeedX())/2);
		newMazub.setCurrentAccelerationX(Mazub.getAccelerationX());
		assertTrue(newMazub.calculateNewPositionX(0.1)<= (1 + 0.1*(newMazub.getMaxSpeedX() + newMazub.getStartSpeedX())/2 + 0.5 *Mazub.getAccelerationX() *Math.pow(0.1,2)));
	}
	@Test
	public void startMoveLeft(){
		newMazub.startMove(Direction.LEFT);
		assertTrue (newMazub.isMoving());
		assertEquals (newMazub.getDirection(),Direction.LEFT);
		assertTrue (newMazub.getCurrentSpeedX() == - newMazub.getStartSpeedX());
		assertTrue (newMazub.getCurrentAccelerationX() == - Mazub.getAccelerationX());
	}
	@Test
	public void startMoveRight(){
		newMazub.startMove(Direction.RIGHT);
		assertTrue (newMazub.isMoving());
		assertEquals (newMazub.getDirection(),Direction.RIGHT);
		assertTrue (newMazub.getCurrentSpeedX() == newMazub.getStartSpeedX());
		assertTrue (newMazub.getCurrentAccelerationX() == Mazub.getAccelerationX());
	}
	@Test
	public void EndMove(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.endMove();
		assertFalse (newMazub.isMoving());
		assertEquals (newMazub.getDirection() , null);
		assertTrue (newMazub.getCurrentAccelerationX() == 0);
		assertTrue (newMazub.getCurrentSpeedX() == 0);
		assertEquals (newMazub.getDirectionLastMove(),Direction.RIGHT);
	}
	@Test
	public void setDirectionIsMoving(){
		newMazub.startMove(Direction.RIGHT);
		assertTrue (newMazub.isValidDirection(Direction.LEFT));
		assertFalse (newMazub.isValidDirection(null));
	}
	@Test
	public void setDirectionNotMoving(){
		newMazub.endMove();
		assertTrue (newMazub.isValidDirection(null));
		assertFalse (newMazub.isValidDirection(Direction.LEFT));
		assertFalse (newMazub.isValidDirection(Direction.RIGHT));
	}
	@Test
	public void setCurrentSpeedXNotMoving(){
		newMazub.endMove();
		assertTrue (newMazub.getCurrentSpeedX() == 0);
	}
	@Test
	public void setCurrentSpeedXCorrect(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.setCurrentSpeedX((newMazub.getMaxSpeedX()+newMazub.getStartSpeedX())/2);
		assertTrue (newMazub.getCurrentSpeedX() == (newMazub.getMaxSpeedX()+newMazub.getStartSpeedX())/2); 
	}
	@Test
	public void setCurrentSpeedXOverflow(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.setCurrentSpeedX(newMazub.getMaxSpeedX() +1);
		assertTrue (newMazub.getCurrentSpeedX() == newMazub.getMaxSpeedX());
	}
	@Test
	public void setCurrentSpeedXUnderflow(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.setCurrentSpeedX(newMazub.getStartSpeedX()/2);
		assertTrue (newMazub.getCurrentSpeedX() == newMazub.getStartSpeedX());
	}
	@Test
	public void setStartSpeedX(){
		newMazub.setStartSpeedX(2);
		assertTrue (newMazub.getStartSpeedX() == 2);
		
	}
	@Test
	public void setStartSpeedXFalse(){
		newMazub.setStartSpeedX(0.5);
		assertTrue(newMazub.getStartSpeedX() == 1);
	}
	@Test
	public void setCurrentAccelerationCorrect(){
		newMazub.setCurrentAccelerationX( - Mazub.getAccelerationX());
		assertTrue (newMazub.getCurrentAccelerationX() == - Mazub.getAccelerationX());
	}
	@Test
	public void setCurrentAccelerationCorrectZero(){
		newMazub.setCurrentAccelerationX(0);
		assertTrue (newMazub.getCurrentAccelerationX() == 0);
	}
	@Test
	public void setCurrentAccelerationFalse(){
		newMazub.setCurrentAccelerationX(Mazub.getAccelerationX() + 1);
		assertTrue (newMazub.getCurrentAccelerationX() == Mazub.getAccelerationX());
	}
	@Test
	public void setAccelerationXCorrect(){
		Mazub.setAccelerationX(2);
		assertTrue (Mazub.getAccelerationX()== 2);
	}
	@Test
	public void setAccelerationXFalse(){
		Mazub.setAccelerationX(-2);
		assertTrue (Mazub.getAccelerationX() == 0);
	}
	@Test
	public void setMaxSpeedXCorrect(){
		newMazub.setMaxSpeedX(newMazub.getStartSpeedX() + 1);
		assertTrue (newMazub.getMaxSpeedX() == newMazub.getStartSpeedX() + 1);
	}
	@Test
	public void setMaxSpeedXFalse(){
		newMazub.setMaxSpeedX(newMazub.getStartSpeedX()/2);
		assertTrue (newMazub.getMaxSpeedX() == newMazub.getStartSpeedX());
	}
	@Test
	public void calculateNewSpeedY(){
		newMazub.startJump();
		newMazub.setCurrentSpeedY(3.0);
		newMazub.setCurrentPositionY(1);
		assertTrue (newMazub.calculateNewSpeedY(0.1) <= 3.0 + newMazub.getAccelerationY()*0.1);
	}
	@Test
	public void calculateNewPositionY(){
		newMazub.startJump();
		newMazub.setCurrentPositionY(2);
		newMazub.setCurrentSpeedY(3);
		assertTrue (newMazub.calculateNewPositionY(0.1) <= 2+3*0.1+newMazub.getAccelerationY()*0.5*Math.pow(0.1,2));
	}
	@Test
	public void startJumpCorrect(){
		newMazub.Land();
		newMazub.startJump();
		assertTrue (newMazub.isJumping());
		assertFalse (newMazub.hasLanded());
		assertTrue (newMazub.getCurrentSpeedY() == Mazub.getStartSpeedY());
	}
	@Test
	public void starJumpFalse(){
		newMazub.startJump();
		newMazub.setCurrentSpeedY(Mazub.getStartSpeedY()/2);
		newMazub.startJump();
		assertTrue (newMazub.getCurrentSpeedY() ==Mazub.getStartSpeedY()/2 );
	}
	@Test
	public void endJumpCorrect(){
		newMazub.startJump();
		newMazub.endJump();
		assertFalse (newMazub.isJumping());
		assertTrue(newMazub.getCurrentSpeedY() == 0);
	}
	@Test
	public void endJumpFalse(){
		newMazub.startJump();
		newMazub.setCurrentSpeedY(-3);
		assertTrue(newMazub.getCurrentSpeedY() == -3);
	}
	@Test
	public void setJumpingStateTrueCorrect(){
		newMazub.Land();
		newMazub.setJumpingState(true);
		assertTrue (newMazub.isJumping());
	}
	@Test(expected=IllegalJumpException.class)
	public void setJumpingStateTrueException() throws Exception{
		newMazub.startJump();
		newMazub.setJumpingState(true);
	}
	@Test
	public void setJumpingStateFalseCorrect(){
		newMazub.setCurrentSpeedY(Mazub.getStartSpeedY());
		newMazub.setJumpingState(false);
		assertFalse (newMazub.isJumping());
	}
	@Test(expected =IllegalJumpException.class)
	public void setJumpingStateFalseException() throws Exception{
		newMazub.setCurrentSpeedY(-3);
		newMazub.setJumpingState(false);
	}
	@Test
	public void Landcorrect(){
		newMazub.Land();
		newMazub.startJump();
		newMazub.Land();
		assertTrue (newMazub.hasLanded());
		assertFalse (newMazub.isJumping());
		assertTrue (newMazub.getCurrentSpeedY()==0);
	}
	@Test
	public void getAccelerationYGround(){
		newMazub.setCurrentPositionY(0);
		assertTrue (newMazub.getAccelerationY() == 0);
	}
	@Test
	public void getAccelerationYAir(){
		newMazub.setCurrentPositionY(1);
		assertTrue (newMazub.getAccelerationY() <= 0);
	}
	@Test
	public void startDuck(){
		newMazub.startDuck();
		assertTrue (newMazub.isDucking());
		assertTrue (newMazub.getMaxSpeedX() == Mazub.getMaxSpeedHorizontalWhenDucking());
	}
	public void endDuck(){
		newMazub.startDuck();
		newMazub.endDuck();
		assertFalse (newMazub.isDucking());
		assertTrue (newMazub.getMaxSpeedX() == newMazub.getMaxSpeedHorizontalWhenRunning());
	}
	@Test
	public void setMaxSpeedXWhenRunningCorrect(){
		newMazub.setMaxSpeedHorizontalWhenRunning(newMazub.getStartSpeedX()*2);
		assertTrue (newMazub.getMaxSpeedHorizontalWhenRunning() == newMazub.getStartSpeedX()*2);
		
	}
	@Test
	public void setMaxSpeedXWhenRunningFalse(){
		newMazub.setMaxSpeedHorizontalWhenRunning(newMazub.getStartSpeedX()/2);
		assertTrue (newMazub.getMaxSpeedHorizontalWhenRunning() == newMazub.getStartSpeedX());
	}
	@Test
	public void getSpriteAtIndex0(){
		try{
		newMazub.endMove();
		Thread.sleep(1200);
		assertEquals(newMazub.getCurrentSprite(),newMazub.getImageAtIndex(0));}
		catch (Exception e){}
	}
	@Test
	public void getSpriteAtIndex1(){
		try{
		newMazub.endMove();
		Thread.sleep(1200);
		newMazub.startDuck();
		assertEquals(newMazub.getCurrentSprite(),newMazub.getImageAtIndex(1));}
		catch(Exception e){}
	}
	@Test
	public void getSpriteAtIndex2(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.endMove();
		assertEquals(newMazub.getCurrentSprite(),newMazub.getImageAtIndex(2));
		
	}
	@Test
	public void getSpriteAtIndex3(){
		newMazub.startMove(Direction.LEFT);
		newMazub.endMove();
		assertEquals(newMazub.getCurrentSprite(),newMazub.getImageAtIndex(3));
	}
	@Test
	public void getSpriteAtIndex4(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.startJump();
		newMazub.endDuck();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(4));
	}
	@Test
	public void getSpriteAtIndex5(){
		newMazub.startMove(Direction.LEFT);
		newMazub.endDuck();
		newMazub.startJump();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(5));
	}
	@Test
	public void getSpriteAtIndex6(){
		newMazub.startMove(Direction.RIGHT);
		newMazub.startDuck();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(6));
		newMazub.endMove();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(6));
	}
	@Test
	public void getSpriteAtIndex7(){
		newMazub.startMove(Direction.LEFT);
		newMazub.startDuck();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(7));
		newMazub.endMove();
		assertEquals (newMazub.getCurrentSprite(),newMazub.getImageAtIndex(7));
	}
	@Test
	public void getSpriteAtIndex8_8m(){
		int m = (newMazub.getImages().length - 8 )/2 -1;
		newMazub.endJump();
		newMazub.Land();
		newMazub.endDuck();
		newMazub.startMove(Direction.RIGHT);
		int i = 7;
		boolean result = false;
		Sprite sprite = newMazub.getCurrentSprite();
		
		while (i++ <= 8+m)
			
		{
		
		if (sprite == newMazub.getImageAtIndex(i))
			
			result = true;
			}
		assertTrue (result);			
	}
	
	@Test
	public void getSpriteAtIndex9m_92m(){
		int m = (newMazub.getImages().length - 8 )/2 -1;
		newMazub.endJump();
		newMazub.endDuck();
		newMazub.Land();
		newMazub.startMove(Direction.LEFT);
		int i = 8+m;
		boolean result = false;
		Sprite sprite =  newMazub.getCurrentSprite();
		while (i++ < 9+2*m)
		{	System.out.println(i);
			if (sprite == newMazub.getImageAtIndex(i))
				result = true;
			
		}
		assertTrue (result);
		
			
	}
}
