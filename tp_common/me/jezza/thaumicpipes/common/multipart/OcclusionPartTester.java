package me.jezza.thaumicpipes.common.multipart;

import java.util.ArrayList;

import me.jezza.thaumicpipes.common.multipart.pipe.PipeProperties;
import me.jezza.thaumicpipes.common.transport.ArmState;
import codechicken.lib.vec.Cuboid6;

public class OcclusionPartTester {
    private ArrayList<Cuboid6> occlusionBoxes;

    public OcclusionPartTester() {
        occlusionBoxes = new ArrayList<Cuboid6>();
    }

    public Iterable<Cuboid6> updateWithArmStates(ArmState[] armStates) {
        occlusionBoxes.clear();
        occlusionBoxes.add(PipeProperties.callDefault());

        if (armStates != null)
            for (ArmState currentState : armStates)
                if (currentState != null && currentState.isValid())
                    occlusionBoxes.add(currentState.getOcclusionBox());

        return occlusionBoxes;
    }

    public ArrayList<Cuboid6> getOcclusionBoxes() {
        return occlusionBoxes;
    }
}