package lordruby.corruptednether.entityrenderers;

import lordruby.corruptednether.entities.CorruptedSkeleton;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;

public class CorruptedSkeletonEntityModel extends SkeletonEntityModel<CorruptedSkeleton> {
    private final ModelPart mushrooms;

    public CorruptedSkeletonEntityModel(ModelPart modelPart) {
        super(modelPart);
        this.mushrooms = modelPart.getChild(EntityModelPartNames.HEAD).getChild(EntityModelPartNames.MUSHROOMS);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0.0F);
        ModelPartData modelPartData = modelData.getRoot();
        SkeletonEntityModel.addLimbs(modelPartData);
        ModelPartData modelPartData2 = modelPartData.getChild(EntityModelPartNames.HEAD)
                .addChild(EntityModelPartNames.MUSHROOMS, ModelPartBuilder.create(), ModelTransform.NONE);
        modelPartData2.addChild(
                "red_mushroom_1",
                ModelPartBuilder.create().uv(50, 16).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(3.0F, -8.0F, 3.0F, 0.0F, (float) (Math.PI / 4), 0.0F)
        );
        modelPartData2.addChild(
                "red_mushroom_2",
                ModelPartBuilder.create().uv(50, 16).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(3.0F, -8.0F, 3.0F, 0.0F, (float) (Math.PI * 3.0 / 4.0), 0.0F)
        );
        modelPartData2.addChild(
                "brown_mushroom_1",
                ModelPartBuilder.create().uv(50, 22).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(-3.0F, -8.0F, -3.0F, 0.0F, (float) (Math.PI / 4), 0.0F)
        );
        modelPartData2.addChild(
                "brown_mushroom_2",
                ModelPartBuilder.create().uv(50, 22).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(-3.0F, -8.0F, -3.0F, 0.0F, (float) (Math.PI * 3.0 / 4.0), 0.0F)
        );
        modelPartData2.addChild(
                "brown_mushroom_3",
                ModelPartBuilder.create().uv(50, 28).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(-2.0F, -1.0F, 4.0F, (float) (-Math.PI / 2), 0.0F, (float) (Math.PI / 4))
        );
        modelPartData2.addChild(
                "brown_mushroom_4",
                ModelPartBuilder.create().uv(50, 28).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 4.0F, 0.0F),
                ModelTransform.of(-2.0F, -1.0F, 4.0F, (float) (-Math.PI / 2), 0.0F, (float) (Math.PI * 3.0 / 4.0))
        );
        return TexturedModelData.of(modelData, 64, 32);
    }

    public void animateModel(CorruptedSkeleton boggedEntity, float f, float g, float h) {
        this.mushrooms.visible = !boggedEntity.isSheared();
        super.animateModel(boggedEntity, f, g, h);
    }
}
