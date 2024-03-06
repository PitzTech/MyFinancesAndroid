package com.pitztech.myfinances.data.repo

import com.pitztech.myfinances.data.service.CacheService
import com.pitztech.myfinances.domain.repo.CacheRepo
import javax.inject.Inject

/**
 * Use this class to put small values as <key-value> pair. internally it uses {@link #Shared Preference}
 */
class CachedRepoImpl @Inject constructor(private val cacheService: CacheService) : CacheRepo {
}