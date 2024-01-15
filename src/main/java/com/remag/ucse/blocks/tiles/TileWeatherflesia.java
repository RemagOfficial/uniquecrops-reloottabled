package com.remag.ucse.blocks.tiles;

import com.remag.ucse.init.UCTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class TileWeatherflesia extends BaseTileUC {

    final ItemStackHandler inv = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {

            setChanged();
        }
    };
    int biomeStrength = 0;

    public TileWeatherflesia(BlockPos pos, BlockState state) {

        super(UCTiles.WEATHERFLESIA.get(), pos, state);
    }

    @Override
    public void writeCustomNBT(CompoundTag tag) {

        tag.putInt("UC:biomeStrength", this.biomeStrength);
        tag.put("inventory", inv.serializeNBT());
    }

    @Override
    public void readCustomNBT(CompoundTag tag) {

        this.biomeStrength = tag.getInt("UC:biomeStrength");
        inv.deserializeNBT(tag.getCompound("inventory"));
    }

    public int getBiomeStrength() {

        return this.biomeStrength;
    }

    public void tickBiomeStrength() {

        if (this.biomeStrength < 100)
            this.biomeStrength++;
    }

    public ItemStack getBrush() {

        return inv.getStackInSlot(0);
    }

    public void setBrush(ItemStack stack) {

        inv.setStackInSlot(0, stack);
    }
}
