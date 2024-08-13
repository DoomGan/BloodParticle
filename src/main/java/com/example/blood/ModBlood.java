package com.example.blood;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

public class ModBlood {

    public static void registerBloodEffect() {

    }

    public static void spawnBloodParticles(LivingEntity entity) {
        if (!entity.getWorld().isClient() && entity.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) entity.getWorld();
            ParticleEffect particleEffect = new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.REDSTONE_BLOCK.getDefaultState());

            serverWorld.spawnParticles(
                    particleEffect,
                    entity.getX(),
                    entity.getY() + entity.getHeight() / 2.0,
                    entity.getZ(),
                    30,
                    0.3, 0.3, 0.3,
                    0.1
            );
        }
    }
}
