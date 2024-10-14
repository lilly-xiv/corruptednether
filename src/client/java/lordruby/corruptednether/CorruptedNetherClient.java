package lordruby.corruptednether;

import lordruby.corruptednether.entities.CorruptedSkeleton;
import lordruby.corruptednether.entityrenderers.CorruptedSkeletonEntityModel;
import lordruby.corruptednether.entityrenderers.CorruptedSkeletonEntityRenderer;
import lordruby.corruptednether.factory.CorruptedParticleFactory;
import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.BoatInit;
import lordruby.corruptednether.init.EntityInit;
import lordruby.corruptednether.init.ParticleInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.RenderLayer;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.minecraft.client.render.entity.model.BoggedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.Identifier;

public class CorruptedNetherClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_CORRUPTED_SKELETON_LAYER = new EntityModelLayer(Identifier.of(CorruptedNether.MOD_ID, "corrupted_skeleton"), "main");
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.VISCIOUS_FUNGUS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.VISCIOUS_VINES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.VISCIOUS_ROOTS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_FIRE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_TORCH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_TORCH_WALL, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CORRUPTED_CAMPFIRE, RenderLayer.getCutout());
		TerraformBoatClientHelper.registerModelLayers(BoatInit.CORRUPTED_BOAT_ID, false);
		ParticleFactoryRegistry.getInstance().register(ParticleInit.CORRUPTED_FIRE_FLAME, FlameParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ParticleInit.CORRUPTED_SPORE, CorruptedParticleFactory::new);
		EntityRendererRegistry.register(EntityInit.CORRUPTED_SKELETON, CorruptedSkeletonEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_CORRUPTED_SKELETON_LAYER, CorruptedSkeletonEntityModel::getTexturedModelData);
	}
}