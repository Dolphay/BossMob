package net.dolphay.indegame.boss.ranged.controller;

import net.dolphay.indegame.boss.ranged.EntityRanged;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityController extends EntityRanged{

    public EntityController(World worldIn)
    {
        super(worldIn);
    }

    public EntityController(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityController(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

}
