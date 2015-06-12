package be.spyproof.mystics.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class ContainerFluidCrafting extends BaseContainer
{
    private IInventory inputSlots = new InventoryBasic("FluidCrafting", true, 2);
    private IInventory outputSlot = new InventoryCraftResult();

    public ContainerFluidCrafting(InventoryPlayer inventoryPlayer)
    {
        addPlayerSlots(inventoryPlayer, 8, 84);
        addContainerSlots();
    }

    public ContainerFluidCrafting(InventoryPlayer inventoryPlayer, ItemStack input1, ItemStack input2)
    {
        addPlayerSlots(inventoryPlayer, 8, 84);
        this.inputSlots.setInventorySlotContents(0, input1);
        this.inputSlots.setInventorySlotContents(1, input2);
        addContainerSlots();
    }

    private void addContainerSlots()
    {
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47)
        {
            @Override
            public boolean canTakeStack(EntityPlayer p_82869_1_)
            {
                return true;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                return true;
            }
        });

        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47)
        {
            @Override
            public boolean canTakeStack(EntityPlayer player)
            {
                return true;
            }

            @Override
            public boolean isItemValid(ItemStack itemStack)
            {
                return true;
            }
        });

        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47)
        {
            @Override
            public boolean canTakeStack(EntityPlayer p_82869_1_)
            {
                return true;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                return false;
            }
        });
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        /*if (player.getCurrentEquippedItem().getItem() instanceof BoundTool)
            return true;
        else
            return false;*/
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        return null;//super.transferStackInSlot(player, slot);
    }

    @Override
    public void putStackInSlot(int slot, ItemStack itemStack)
    {
        super.putStackInSlot(slot, itemStack);
        //if (getContainerInputSlots().contains(slot))
        //    updateOutputSlot();
    }

    /*protected void updateOutputSlot()
    {

    }

    protected List<Integer> getContainerInputSlots()
    {
        List<Integer> slots = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) // 2 = amount of slots
        {
            slots.add(this.inventorySlots.size() - 3 - i); // 3 = total amount of container slots
        }

        return slots;
    }*/
}
