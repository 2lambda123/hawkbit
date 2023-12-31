/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.data.providers;

import org.eclipse.hawkbit.repository.DistributionSetManagement;
import org.eclipse.hawkbit.repository.model.DistributionSetMetadata;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyMetaData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Data provider for {@link DistributionSetMetadata}, which dynamically loads a
 * batch of {@link DistributionSetMetadata} entities from backend and maps them
 * to corresponding {@link ProxyMetaData} entities.
 */
public class DsMetaDataDataProvider extends AbstractMetaDataDataProvider<DistributionSetMetadata, Long> {
    private static final long serialVersionUID = 1L;

    private final transient DistributionSetManagement distributionSetManagement;

    /**
     * Constructor for DsMetaDataDataProvider
     *
     * @param distributionSetManagement
     *            DistributionSetManagement
     */
    public DsMetaDataDataProvider(final DistributionSetManagement distributionSetManagement) {
        super();

        this.distributionSetManagement = distributionSetManagement;
    }

    @Override
    protected Page<DistributionSetMetadata> loadBackendEntities(final PageRequest pageRequest, final Long dsId) {
        if (dsId == null) {
            return Page.empty(pageRequest);
        }

        return distributionSetManagement.findMetaDataByDistributionSetId(pageRequest, dsId);
    }

    @Override
    protected long sizeInBackEnd(final PageRequest pageRequest, final Long dsId) {
        if (dsId == null) {
            return 0L;
        }

        return distributionSetManagement.countMetaDataByDistributionSetId(dsId);
    }
}
