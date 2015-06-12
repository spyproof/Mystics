package be.spyproof.mystics.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by Spyproof.
 */
public abstract class BaseContainer extends Container
{
    protected void addPlayerSlots(InventoryPlayer inventoryPlayer, int x, int y)
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, x + j * 18, y + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, x + i * 18, y + 58));
        }
    }
}
