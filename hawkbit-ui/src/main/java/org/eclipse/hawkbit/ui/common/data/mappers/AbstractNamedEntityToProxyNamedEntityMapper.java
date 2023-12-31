/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.data.mappers;

import org.eclipse.hawkbit.repository.model.NamedEntity;
import org.eclipse.hawkbit.ui.common.UserDetailsFormatter;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyNamedEntity;
import org.eclipse.hawkbit.ui.utils.SPDateTimeUtil;
/**
 * Maps named entities, fetched from backend, to the proxy named entities.
 *
 * @param <T>
 *          Generic type of ProxyNamedEntity
 * @param <U>
 *          Generic type of NamedEntity
 */
public abstract class AbstractNamedEntityToProxyNamedEntityMapper<T extends ProxyNamedEntity, U extends NamedEntity>
        implements NamedEntityToProxyNamedEntityMapper<T, U> {

    protected void mapNamedEntityAttributes(final U namedEntity, final T proxyNamedEntity) {
        proxyNamedEntity.setId(namedEntity.getId());
        proxyNamedEntity.setName(namedEntity.getName());
        proxyNamedEntity.setDescription(namedEntity.getDescription());
        proxyNamedEntity.setCreatedAt(namedEntity.getCreatedAt());
        proxyNamedEntity.setCreatedDate(SPDateTimeUtil.getFormattedDate(namedEntity.getCreatedAt()));
        proxyNamedEntity.setLastModifiedAt(namedEntity.getLastModifiedAt());
        proxyNamedEntity.setModifiedDate(SPDateTimeUtil.getFormattedDate(namedEntity.getLastModifiedAt()));
        proxyNamedEntity.setCreatedBy(UserDetailsFormatter.loadAndFormatCreatedBy(namedEntity));
        proxyNamedEntity.setLastModifiedBy(UserDetailsFormatter.loadAndFormatLastModifiedBy(namedEntity));
    }
}
