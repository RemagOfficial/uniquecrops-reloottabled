package com.remag.ucse.integration.patchouli.processor;

import com.remag.ucse.integration.patchouli.PatchouliUtils;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class CropProcessor implements IComponentProcessor {

    private BlockState state;

    @Override
    public void setup(IVariableProvider var) {

        if (!var.has("blockstate")) {
            state = Blocks.AIR.defaultBlockState();
            return;
        }
        state = PatchouliUtils.deserialize(var.get("blockstate").asString());
    }

    @Override
    public IVariable process(String key) {

        if (key.equals("blockstate"))
            return IVariable.wrap(PatchouliUtils.serialize(state));

        return null;
    }
}
