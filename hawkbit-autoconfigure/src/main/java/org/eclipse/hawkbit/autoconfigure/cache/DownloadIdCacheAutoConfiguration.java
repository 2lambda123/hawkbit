/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.autoconfigure.cache;

import org.eclipse.hawkbit.cache.DefaultDownloadIdCache;
import org.eclipse.hawkbit.cache.DownloadIdCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A configuration for configuring a cache for the download id's.
 *
 * This is done by providing a named cache.
 */
@Configuration
public class DownloadIdCacheAutoConfiguration {

    /**
     * Bean for the downloadId cache that returns the DefaultDownloadIdCache.
     * The DefaultDownloadIdCache cannot be used within a cluster because the
     * downloadId cache is not shared among notes. This means, a downloadId
     * which is stored on note A for downloading an artifact can only be used
     * for downloading the artifact form node A.
     * 
     * @return the DefaultDownloadIdCache
     */
    @Bean
    @ConditionalOnMissingBean
    public DownloadIdCache downloadIdCache(final CacheManager cacheManager) {
        return new DefaultDownloadIdCache(cacheManager);
    }

}
