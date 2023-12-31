/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common;

import org.eclipse.hawkbit.repository.model.NamedEntity;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyNamedEntity;

/**
 * Window controller for named entity creations.
 *
 * @param <T>
 *            Type of proxy entity
 * @param <E>
 *            Second type of proxy entity
 * @param <R>
 *            Type of repository entity
 */
public abstract class AbstractAddNamedEntityWindowController<T, E extends ProxyNamedEntity, R extends NamedEntity>
        extends AbstractAddEntityWindowController<T, E, R> {

    /**
     * Constructor
     *
     * @param uiDependencies
     *            {@link CommonUiDependencies}
     */
    protected AbstractAddNamedEntityWindowController(final CommonUiDependencies uiDependencies) {
        super(uiDependencies);
    }

    @Override
    protected String getDisplayableName(final R entity) {
        return entity.getName();
    }

    @Override
    protected String getDisplayableNameForFailedMessage(final E entity) {
        return entity.getName();
    }

    @Override
    protected Long getId(final R entity) {
        return entity.getId();
    }
}
