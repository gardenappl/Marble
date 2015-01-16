package com.goldenapple.marble.client;

import com.goldenapple.marble.CommonProxy;
import com.goldenapple.marble.client.render.RopeRender;
import com.goldenapple.marble.client.render.TableRender;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderers() {
        RenderingRegistry.registerBlockHandler(new TableRender());
        RenderingRegistry.registerBlockHandler(new RopeRender());
    }
}
