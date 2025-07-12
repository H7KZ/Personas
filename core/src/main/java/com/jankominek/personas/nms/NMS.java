package com.jankominek.personas.nms;

import com.jankominek.personas.guis.HeadBuilder;
import com.jankominek.personas.plugins.ISupportedPlugin;

import java.util.ArrayList;
import java.util.List;

public interface NMS {
    default List<ISupportedPlugin> getSupportedPlugins() {
        return new ArrayList<>();
    }

    default HeadBuilder setTexture(HeadBuilder headBuilder, String texture) {
        return headBuilder;
    }
}
