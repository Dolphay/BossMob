package net.dolphay.indegame.boss.ranged.joystick;

import net.dolphay.indegame.boss.ranged.EntityRanged;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityJoystick extends EntityRanged{

    public EntityJoystick(World worldIn)
    {
        super(worldIn);
    }

    public EntityJoystick(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityJoystick(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
   

}
