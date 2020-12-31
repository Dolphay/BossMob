package net.dolphay.indegame.boss.pets.ModdedParrot;

import javax.annotation.Nullable;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.ai.PetEntityAIHurtByTarget;
import net.dolphay.indegame.boss.pets.EntityPet;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityModdedParrot extends EntityPet implements EntityFlying
{

    private static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntityModdedParrot.class, DataSerializers.VARINT);
    
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;

	public EntityModdedParrot(World worldIn) {
		super(worldIn);
        this.setSize(0.5F, 0.9F);
        this.moveHelper = new EntityFlyHelper(this);
	}
    
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        this.setVariant(this.rand.nextInt(5));
        
        return super.onInitialSpawn(difficulty, livingdata);
    }
    
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 2.0D, false));
        this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
        this.targetTasks.addTask(1, new PetEntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(300));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13D);
    }

    
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.calculateFlapping();
    }
    
    private void calculateFlapping()
    {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);

        if (!this.onGround && this.flapping < 1.0F)
        {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.flap += this.flapping * 2.0F;
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(VARIANT, Integer.valueOf((int) (Math.random()*5)));
    }
    
    public void setVariant(int p_191997_1_)
    {
        this.dataManager.set(VARIANT, Integer.valueOf(p_191997_1_));
    }

	public boolean isFlying()
    {
        return !this.onGround;
    }

	public int getVariant()
    {
        return MathHelper.clamp(((Integer)this.dataManager.get(VARIANT)).intValue(), 0, 4);
    }
	
	protected PathNavigate createNavigator(World worldIn)
    {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }
	
	public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }

	@Override
	public void removeParrentNode() {
		if(this.parent != null)
			this.parent.removeEntity(Attack.PARROT);
	}
	
}