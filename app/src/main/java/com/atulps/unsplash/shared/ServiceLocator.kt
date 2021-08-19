package com.atulps.unsplash.shared

import com.atulps.unsplash.shared.domain.GetUnsplashData
import com.atulps.unsplash.shared.presentation.UnsplashPresenter

public object ServiceLocator {

    private val getUnsplash: GetUnsplashData = GetUnsplashData()

    public val getUnsplashPresenter: UnsplashPresenter = UnsplashPresenter(getUnsplash)
}