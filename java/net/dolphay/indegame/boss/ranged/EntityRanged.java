package net.dolphay.indegame.boss.ranged;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRanged extends EntityThrowable {
	 public EntityRanged(World worldIn)
	    {
	        super(worldIn);
	    }

	    public EntityRanged(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }

	    public EntityRanged(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }

		@Override
		protected void onImpact(RayTraceResult result) {
			if (result.entityHit != null)
	        {
				result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.0F);
	        }
		}
}
