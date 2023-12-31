/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.layout.listener.support;

import java.util.Collection;

import org.eclipse.hawkbit.ui.common.layout.listener.EntityModifiedListener.EntityModifiedAwareSupport;
import org.eclipse.hawkbit.ui.common.tagdetails.AbstractTagToken;

/**
 * Support for Entity modified with tag token aware
 */
public class EntityModifiedTagTokenAwareSupport implements EntityModifiedAwareSupport {
    private final AbstractTagToken<?> tagToken;

    /**
     * Constructor for EntityModifiedTagTokenAwareSupport
     *
     * @param tagToken
     *            Tag token
     */
    public EntityModifiedTagTokenAwareSupport(final AbstractTagToken<?> tagToken) {
        this.tagToken = tagToken;
    }

    /**
     * Static method for constructor EntityModifiedTagTokenAwareSupport
     *
     * @param tagToken
     *            Tag token
     *
     * @return Support for Entity modified with tag token aware
     */
    public static EntityModifiedTagTokenAwareSupport of(final AbstractTagToken<?> tagToken) {
        return new EntityModifiedTagTokenAwareSupport(tagToken);
    }

    @Override
    public void onEntitiesAdded(final Collection<Long> entityIds) {
        if (shouldHandleEvent()) {
            tagToken.onTagsAdded(entityIds);
        }
    }

    @Override
    public void onEntitiesUpdated(final Collection<Long> entityIds) {
        if (shouldHandleEvent()) {
            tagToken.onTagsUpdated(entityIds);
        }
    }

    @Override
    public void onEntitiesDeleted(final Collection<Long> entityIds) {
        if (shouldHandleEvent()) {
            tagToken.onTagsDeleted(entityIds);
        }
    }

    private boolean shouldHandleEvent() {
        return tagToken.getMasterEntity().isPresent();
    }
}
