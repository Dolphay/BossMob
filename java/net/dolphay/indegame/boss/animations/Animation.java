package net.dolphay.indegame.boss.animations;

import net.dolphay.indegame.boss.EntityIndeGame.Attack;

public class Animation {
	
	private float[][][][] anim;
	private int[][] frameTime;
	private int totalLength;
	private int frame = 0;
	private boolean defaultAnim;
	private int resetFrameTime = 0;
	
	public Animation(int frames) {
		this(frames, false);
	}
	
	public Animation(int frames, boolean defaultAnim) {
		anim = new float[frames][5][2][6];
		frameTime = new int[frames][2];
		this.defaultAnim = defaultAnim;
	}
	
	public void nextFrame() {
		frame++;
	}
	
	public float[] getPart(int frame, Part part) {
		return anim[frame][part.id[0]][part.id[1]];
	}
	
	public float[][][] getFrame(int frame) {
		return anim[frame];
	}
	
	public int[] getFrameTime(int frame) {
		return frameTime[frame];
	}
	
	public void setFrame(Part part, float[] posOffset) {
		anim[frame][part.id[0]][part.id[1]] = posOffset;
	}
	
	public void setFrameTime(int[] length) {
		frameTime[frame] = length;
	}
	
	public void setTotalLength(int length) {
		this.totalLength = length;
	}
	
	public int getTotalTime() {
		return totalLength;
	}
	
	public enum Part{
		
		RightShoulder(0, 0),
		RightArm(0, 1),
		LeftShoulder(1, 0),
		LeftArm(1, 1),
		
		RightLeg(2,0),
		RightFoot(2,1),
		LeftLeg(3,0),
		LeftFoot(3,1),
		
		Body(4,0);
		
		private int[] id;

        private Part(int idXIn, int idYIn)
        {
            this.id = new int[] {idXIn, idYIn};
        }
	}
	
	public int getFrameFromTick(float time) {
		int endFrame = -1;
		for(int i = 0; i < frameTime.length; i++) {
			int[] frame = frameTime[i];
				
			if(time >= frame[0] && (frame[1] == totalLength ? true : time <= frame[1])) {
				endFrame = i;
			}
		}
		
		return endFrame;
	}
	
}
