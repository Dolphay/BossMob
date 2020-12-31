package net.dolphay.indegame.boss.animations;

import net.dolphay.indegame.boss.animations.Animation.Part;

public class AnimationManager {
	public static Animation NormalAnimation;
	public static Animation ParrotAnimation;
	public static Animation JoystickAnimation;
	public static Animation WolfAnimation;
	
	public static void setAnimations() {
		parrotAnimation();
		staticAnimation();
		wolfAnimation();
		joystickAnimation();
	}
	
	private static void staticAnimation() {
		NormalAnimation = new Animation(1, true);
		
		NormalAnimation.setFrameTime(new int[] {0, 10});
		
		NormalAnimation.setTotalLength(10);
		
		NormalAnimation.setFrame(Part.Body, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.LeftShoulder, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.RightShoulder, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.LeftArm, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.RightArm, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.LeftLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.RightLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.LeftFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		NormalAnimation.setFrame(Part.RightFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
	}
	
	private static void joystickAnimation() {
		JoystickAnimation = new Animation(2);
		
		JoystickAnimation.setTotalLength(21);
		
		JoystickAnimation.setFrameTime(new int[] {0, 7});
		
		JoystickAnimation.setFrame(Part.Body, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftShoulder, new float[] {
				5, 0, -45, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightShoulder, new float[] {
				-5, 0, 45, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftArm, new float[] {
				0, 0, 10, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightArm, new float[] {
				0, 0, -10, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightLeg, new float[] {
				10, 0, 5, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightFoot, new float[] {
				-15, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.nextFrame();
		
		JoystickAnimation.setFrameTime(new int[] {7, 21});
		
		JoystickAnimation.setFrame(Part.Body, new float[] {
				0, -360, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftShoulder, new float[] {
				-5, 0, -45, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightShoulder, new float[] {
				5, 0, 45, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftArm, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightArm, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightLeg, new float[] {
				20, 0, 5, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.LeftFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		JoystickAnimation.setFrame(Part.RightFoot, new float[] {
				-20, 0, 0, 0, 0, 0
		});
	}
	
	private static void parrotAnimation() {
		ParrotAnimation = new Animation(2);
		
		ParrotAnimation.setTotalLength(16);
		
		ParrotAnimation.setFrameTime(new int[] {0, 10});
		
		ParrotAnimation.setFrame(Part.Body, new float[] {
				15, 0, 0, 0, 1, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftShoulder, new float[] {
				0, 0, -55, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightShoulder, new float[] {
				0, 0, 55, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftArm, new float[] {
				0, 0, -5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightArm, new float[] {
				0, 0, 5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftLeg, new float[] {
				-30, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightLeg, new float[] {
				-30, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftFoot, new float[] {
				15, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightFoot, new float[] {
				15, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.nextFrame();
		
		ParrotAnimation.setFrameTime(new int[] {10, 16});
		
		ParrotAnimation.setFrame(Part.Body, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftShoulder, new float[] {
				0, 0, 5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightShoulder, new float[] {
				0, 0, -5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftArm, new float[] {
				0, 0, -5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightArm, new float[] {
				0, 0, 5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.LeftFoot, new float[] {
				0, 0, 5, 0, 0, 0
		});
		
		ParrotAnimation.setFrame(Part.RightFoot, new float[] {
				0, 0, -5, 0, 0, 0
		});
		
	}
	
	private static void wolfAnimation() {
		WolfAnimation = new Animation(1);
		
		WolfAnimation.setTotalLength(12);
		
		WolfAnimation.setFrameTime(new int[] {0, 12});
		
		WolfAnimation.setFrame(Part.Body, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.LeftShoulder, new float[] {
				-85, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.RightShoulder, new float[] {
				-85, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.LeftArm, new float[] {
				-5, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.RightArm, new float[] {
				-5, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.LeftLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.RightLeg, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.LeftFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
		
		WolfAnimation.setFrame(Part.RightFoot, new float[] {
				0, 0, 0, 0, 0, 0
		});
	}
	
	
}
