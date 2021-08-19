package com.atulps.unsplash.shared.domain.cb

import com.atulps.unsplash.shared.data.model.Image

public interface UnsplashData {

    public fun onNewDataAvailable(items: List<Image>, e: Exception?)
}