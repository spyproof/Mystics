package be.spyproof.mystics.init;

import be.spyproof.mystics.blocks.ChargedBlock;
import be.spyproof.mystics.fluid.FluidAcid;
import be.spyproof.mystics.fluid.FluidDragonFire;
import be.spyproof.mystics.fluid.FluidLightning;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodBlocks
{
    public static final ChargedBlock chargedBlock = new ChargedBlock();

    public static Fluid fluidLightning = new Fluid("fluidLightning");
    public static FluidLightning fluidBlockLightning;

    public static Fluid fluidDragonFire = new Fluid("fluidDragonFire");
    public static FluidDragonFire fluidBlockDragonFire;

    public static Fluid fluidAcid = new Fluid("fluidAcid");
    public static FluidAcid fluidBlockAcid;

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
    }

    private void setupFluidBlocks()
    {
        fluidBlockLightning = new FluidLightning(fluidLightning);
        fluidBlockDragonFire = new FluidDragonFire(fluidDragonFire);
        fluidBlockAcid = new FluidAcid(fluidAcid);

        GameRegistry.registerBlock(fluidBlockLightning, Names.Blocks.FLUID_LIGHTNING);
        GameRegistry.registerBlock(fluidBlockDragonFire, Names.Blocks.FLUID_DRAGON_FIRE);
        GameRegistry.registerBlock(fluidBlockAcid, Names.Blocks.FLUID_ACID);
    }

    private void setupBlocks()
    {
        GameRegistry.registerBlock(chargedBlock, Names.Blocks.CHARGED_BLOCK);
    }
}
