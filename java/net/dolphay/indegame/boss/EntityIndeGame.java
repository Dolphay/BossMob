package net.dolphay.indegame.boss;

import java.util.ArrayList;
import java.util.HashMap;

import net.dolphay.indegame.boss.ai.JoystickAttackAI;
import net.dolphay.indegame.Reference;
import net.dolphay.indegame.boss.ai.BossAIWander;
import net.dolphay.indegame.boss.ai.ParrotSummonAI;
import net.dolphay.indegame.boss.ai.WolfSummonAI;
import net.dolphay.indegame.boss.animations.Animation;
import net.dolphay.indegame.boss.animations.AnimationManager;
import net.dolphay.indegame.boss.pets.ModdedParrot.EntityModdedParrot;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.dolphay.indegame.boss.ranged.EntityRanged;
import net.dolphay.indegame.boss.ranged.controller.EntityController;
import net.dolphay.indegame.boss.ranged.joystick.EntityJoystick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityIndeGame extends EntityMob implements IRangedAttackMob{
	private static final DataParameter<Integer> ATTACK = EntityDataManager.<Integer>createKey(EntityIndeGame.class, DataSerializers.VARINT);
	private Attack curAttack = Attack.NONE;
	private ArrayList<EntityModdedWolf> wolfList;
	private ArrayList<EntityModdedParrot> parrotList;
	
	private HashMap<Attack, Integer> delay;
	
	private int server_attack_time;
	private boolean groundHit;
	
	@SideOnly(Side.CLIENT)
	private int client_attack_time;
	
	public EntityIndeGame(World worldIn) {
		super(worldIn);
		this.setSize(.9F, 2.3F);
		if(!this.world.isRemote) { 
			delay = new HashMap<>();
			wolfList = new ArrayList<>();
			parrotList = new ArrayList<>();
			
		}
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new ParrotSummonAI(this, 200));
		this.tasks.addTask(1, new WolfSummonAI(this, 400));
		this.tasks.addTask(2, new JoystickAttackAI(this, 1.25D, 1, 10.0F, 40));
        this.tasks.addTask(2, new BossAIWander(this, 0.6D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(300));
	}
	
	public void addEntity(Attack attack, EntityMob mob) {
		if(attack == Attack.PARROT) {
			parrotList.add((EntityModdedParrot) mob);
		}
		else if(attack == Attack.WOLF) {
			wolfList.add((EntityModdedWolf) mob);
		}
	}
	
	public int getEntityCount(Attack attack) {
		if(attack == Attack.PARROT) {
			return parrotList.size();
		}
		else if(attack == Attack.WOLF) {
			return wolfList.size();
		}
		
		return 0;
	}
	
	public void removeEntity(Attack attack) {
		if(attack == Attack.PARROT) {
			parrotList.remove(0);
		}
		else if(attack == Attack.WOLF) {
			wolfList.remove(0);
		}
	}
	
	public void setDelay(Attack attack, int delay) {
		this.delay.put(attack, delay);
	}
	
	public Integer getDelay(Attack attack) {
		return this.delay.get(attack);
	}
	
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ATTACK, 0);
	}
	
	public void groundHit() {
		groundHit = !groundHit;
	}
	
	public boolean doGroundHit() {
		return groundHit;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600.0D); 
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
        
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if(this.ticksExisted - this.getAttackTime() == 1) {
			this.playSound(new SoundEvent(getAttack().soundID), 1.0F, 1.0F);
		}
		
		if(curAttack.id != this.dataManager.get(ATTACK)) {
			if (this.world.isRemote) {
				this.client_attack_time = this.ticksExisted;
				this.curAttack = Attack.getFromId(this.dataManager.get(ATTACK));
			}
		}
	}
	
	@Override
	public float getEyeHeight() {
		return 2.1F;
	}
	
	public Attack getAttack() {
		if (this.world.isRemote) 
        {
            return Attack.getFromId(this.dataManager.get(ATTACK));
        }
        else
        {
            return this.curAttack;
        }
	}
	
	public int getAttackTime() {
		if (this.world.isRemote) {
			return client_attack_time;
		}
		else {
			return server_attack_time;
		}
	}
	
	public boolean canDespawn()
    {
        return false;
    }
	
	public void setAttack(Attack attack) {
		this.curAttack = attack;
		this.server_attack_time = this.ticksExisted;
        this.dataManager.set(ATTACK, curAttack.id);
	}
	
	public enum Attack{
		NONE(0, AnimationManager.NormalAnimation, ""), 
		PARROT(1, AnimationManager.ParrotAnimation, "parrots"),
		WOLF(2, AnimationManager.WolfAnimation, "wolves"),
		JOYSTICK(3, AnimationManager.JoystickAnimation, "joystick");
		
		private final int id;
		private final Animation ani;
		private final ResourceLocation soundID;

        private Attack(int idIn, Animation ani, String soundID)
        {
            this.id = idIn;
            this.ani = ani;
            this.soundID = new ResourceLocation(Reference.MODID, soundID);
        }
        
        public Animation getAnimation() {
        	return ani;
        }

        public static Attack getFromId(int idIn)
        {
            for (Attack attackType : values())
            {
                if (idIn == attackType.id)
                {
                    return attackType;
                }
            }

            return NONE;
        }
	}
	
	public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }

    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
    	
        EntityRanged entitysnowball = Math.random() > 0.5F ? new EntityJoystick(this.world, this) : new EntityController(this.world, this);
        double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.posX - this.posX;
        double d2 = d0 - entitysnowball.posY;
        double d3 = target.posZ - this.posZ;
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entitysnowball.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
        this.world.spawnEntity(entitysnowball);
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
	}

}
