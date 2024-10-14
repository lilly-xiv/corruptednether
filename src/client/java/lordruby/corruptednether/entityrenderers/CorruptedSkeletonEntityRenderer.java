package lordruby.corruptednether.entityrenderers;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.CorruptedNetherClient;
import lordruby.corruptednether.entities.CorruptedSkeleton;
import net.minecraft.client.render.entity.BoggedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.feature.SkeletonOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.BoggedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.mob.BoggedEntity;
import net.minecraft.util.Identifier;

public class CorruptedSkeletonEntityRenderer extends SkeletonEntityRenderer<CorruptedSkeleton> {
    private static final Identifier TEXTURE = Identifier.of(CorruptedNether.MOD_ID, "textures/entity/corruptedskeleton/corrupted_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(CorruptedNether.MOD_ID, "textures/entity/corruptedskeleton/corrupted_skeleton_overlay.png");

    public CorruptedSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.BOGGED_INNER_ARMOR, EntityModelLayers.BOGGED_OUTER_ARMOR, new CorruptedSkeletonEntityModel(context.getPart(CorruptedNetherClient.MODEL_CORRUPTED_SKELETON_LAYER)));
        this.addFeature(new SkeletonOverlayFeatureRenderer<>(this, context.getModelLoader(), EntityModelLayers.BOGGED_OUTER, OVERLAY_TEXTURE));
    }

    public Identifier getTexture(CorruptedSkeleton boggedEntity) {
        return TEXTURE;
    }
}