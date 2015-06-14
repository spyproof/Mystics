package be.spyproof.mystics.init;

import be.spyproof.mystics.blocks.MythicOre;
import be.spyproof.mystics.fluid.*;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodBlocks
{
    public static final MythicOre LIGHTNING_BLOCK = new MythicOre(Names.Blocks.LIGHTNING_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 0));
    public static final MythicOre FIRE_BLOCK = new MythicOre(Names.Blocks.FIRE_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 1));
    public static final MythicOre WATER_BLOCK = new MythicOre(Names.Blocks.WATER_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 4));

    public static Fluid fluidLightning = new Fluid("fluidLightning");
    public static FluidLightning fluidBlockLightning;

    public static Fluid fluidDragonFire = new Fluid("fluidDragonFire");
    public static FluidFire fluidBlockFire;

    public static Fluid fluidAcid = new Fluid("fluidAcid");
    public static FluidAcid fluidBlockAcid;

    public static Fluid fluidAir = new Fluid("fluidAir");
    public static FluidAir fluidBlockAir;

    public static Fluid fluidLivingWater = new Fluid("fluidLivingWater");
    public static FluidWater fluidBlockWater;

    public RegisterGodBlocks()
    {
        setupFluids();
        setupFluidBlocks();
        setupBlocks();
    }

    private void setupFluids()
    {
        fluidLightning.setLuminosity(0);
        fluidLightning.setViscosity(1000);
        FluidRegistry.registerFluid(fluidLightning);

        fluidDragonFire.setLuminosity(15);
        fluidDragonFire.setViscosity(6000);
        FluidRegistry.registerFluid(fluidDragonFire);

        fluidAcid.setLuminosity(0);
        fluidAcid.setViscosity(2000);
        FluidRegistry.registerFluid(fluidAcid);

        fluidAir.setLuminosity(0);
        fluidAir.setViscosity(500);
        FluidRegistry.registerFluid(fluidAir);

        fluidLivingWater.setLuminosity(8);
        fluidLivingWater.setViscosity(1000);
        FluidRegistry.registerFluid(fluidLivingWater);
    }

    private void setupFluidBlocks()
    {
        fluidBlockLightning = new FluidLightning(fluidLightning);
        fluidBlockFire = new FluidFire(fluidDragonFire);
        fluidBlockAcid = new FluidAcid(fluidAcid);
        fluidBlockAir = new FluidAir(fluidAir);
        fluidBlockWater = new FluidWater(fluidLivingWater);

        GameRegistry.registerBlock(fluidBlockLightning, Names.Blocks.FLUID_LIGHTNING);
        GameRegistry.registerBlock(fluidBlockFire, Names.Blocks.FLUID_DRAGON_FIRE);
        GameRegistry.registerBlock(fluidBlockAcid, Names.Blocks.FLUID_ACID);
        GameRegistry.registerBlock(fluidBlockAir, Names.Blocks.FLUID_AIR);
        GameRegistry.registerBlock(fluidBlockWater, Names.Blocks.FLUID_LIVING_WATER);
    }

    private void setupBlocks()
    {
        GameRegistry.registerBlock(LIGHTNING_BLOCK, Names.Blocks.LIGHTNING_BLOCK);
        GameRegistry.registerBlock(FIRE_BLOCK, Names.Blocks.FIRE_BLOCK);
        GameRegistry.registerBlock(WATER_BLOCK, Names.Blocks.WATER_BLOCK);
    }
}
