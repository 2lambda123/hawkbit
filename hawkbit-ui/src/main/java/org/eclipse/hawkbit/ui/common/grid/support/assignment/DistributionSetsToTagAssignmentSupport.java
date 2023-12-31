/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.grid.support.assignment;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.hawkbit.im.authentication.SpPermission;
import org.eclipse.hawkbit.repository.DistributionSetManagement;
import org.eclipse.hawkbit.repository.model.AbstractAssignmentResult;
import org.eclipse.hawkbit.repository.model.DistributionSet;
import org.eclipse.hawkbit.ui.SpPermissionChecker;
import org.eclipse.hawkbit.ui.common.CommonUiDependencies;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyDistributionSet;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyIdentifiableEntity;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyTag;
import org.eclipse.hawkbit.ui.common.event.EntityModifiedEventPayload;
import org.eclipse.hawkbit.ui.common.event.EntityModifiedEventPayload.EntityModifiedEventType;
import org.eclipse.hawkbit.ui.common.event.EventTopics;
import org.vaadin.spring.events.EventBus.UIEventBus;

/**
 * Support for assigning the {@link ProxyDistributionSet} items to
 * {@link ProxyTag}.
 *
 */
public class DistributionSetsToTagAssignmentSupport
        extends ToTagAssignmentSupport<ProxyDistributionSet, DistributionSet> {
    private final DistributionSetManagement distributionSetManagement;
    private final UIEventBus eventBus;
    private final SpPermissionChecker permChecker;

    /**
     * Constructor for DistributionSetsToTagAssignmentSupport
     *
     * @param uiDependencies
     *            {@link CommonUiDependencies}
     * @param distributionSetManagement
     *            DistributionSetManagement
     */
    public DistributionSetsToTagAssignmentSupport(final CommonUiDependencies uiDependencies,
            final DistributionSetManagement distributionSetManagement) {
        super(uiDependencies.getUiNotification(), uiDependencies.getI18n());

        this.distributionSetManagement = distributionSetManagement;
        this.eventBus = uiDependencies.getEventBus();
        this.permChecker = uiDependencies.getPermChecker();
    }

    @Override
    public List<String> getMissingPermissionsForDrop() {
        return permChecker.hasUpdateRepositoryPermission() ? Collections.emptyList()
                : Collections.singletonList(SpPermission.UPDATE_REPOSITORY);
    }

    @Override
    protected AbstractAssignmentResult<DistributionSet> toggleTagAssignment(
            final List<ProxyDistributionSet> sourceItems, final String tagName) {
        final Collection<Long> dsIdsToAssign = sourceItems.stream().map(ProxyDistributionSet::getId)
                .collect(Collectors.toList());

        return distributionSetManagement.toggleTagAssignment(dsIdsToAssign, tagName);
    }

    @Override
    protected String getAssignedEntityTypeMsgKey() {
        return "caption.distribution";
    }

    @Override
    protected void publishTagAssignmentEvent(final List<ProxyDistributionSet> sourceItemsToAssign) {
        final List<Long> assignedDsIds = sourceItemsToAssign.stream().map(ProxyIdentifiableEntity::getId)
                .collect(Collectors.toList());
        eventBus.publish(EventTopics.ENTITY_MODIFIED, this, new EntityModifiedEventPayload(
                EntityModifiedEventType.ENTITY_UPDATED, ProxyDistributionSet.class, assignedDsIds));
    }
}
