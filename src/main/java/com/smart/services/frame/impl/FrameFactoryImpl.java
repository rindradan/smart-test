package com.smart.services.frame.impl;

import com.smart.model.Frame;
import com.smart.services.frame.FrameFactory;

import java.util.HashMap;
import java.util.Map;

public class FrameFactoryImpl implements FrameFactory
{
    private Map<Integer,Frame> frameMap = new HashMap<>();

    @Override
    public Map<Integer, Frame> getFrameMap()
    {
        return frameMap;
    }

    public void setFrameMap(Map<Integer, Frame> frameMap)
    {
        this.frameMap = frameMap;
    }
}
