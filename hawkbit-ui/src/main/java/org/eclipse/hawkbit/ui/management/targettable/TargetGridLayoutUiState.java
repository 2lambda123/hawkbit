/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.management.targettable;

import org.eclipse.hawkbit.ui.common.data.proxies.ProxyDistributionSetInfo;
import org.eclipse.hawkbit.ui.common.state.GridLayoutUiState;

/**
 * Target grid layout ui state
 */
public class TargetGridLayoutUiState extends GridLayoutUiState {
    private static final long serialVersionUID = 1L;

    private Long pinnedTargetId;
    private String pinnedControllerId;
    private ProxyDistributionSetInfo filterDsInfo;

    /**
     * @return Pinned controller id
     */
    public String getPinnedControllerId() {
        return pinnedControllerId;
    }

    /**
     * Sets the pinned controller id
     *
     * @param pinnedControllerId
     *            Id
     */
    public void setPinnedControllerId(final String pinnedControllerId) {
        this.pinnedControllerId = pinnedControllerId;
    }

    /**
     * @return Pinned target id
     */
    public Long getPinnedTargetId() {
        return pinnedTargetId;
    }

    /**
     * Sets the pinned target id
     *
     * @param pinnedTargetId
     *            Id
     */
    public void setPinnedTargetId(final Long pinnedTargetId) {
        this.pinnedTargetId = pinnedTargetId;
    }

    /**
     * @return filter distribution set id name and version
     */
    public ProxyDistributionSetInfo getFilterDsInfo() {
        return filterDsInfo;
    }

    /**
     * Sets the filter distribution set id name and version
     *
     * @param dsInfo
     *            ProxyDistributionSetInfo
     */
    public void setFilterDsInfo(final ProxyDistributionSetInfo dsInfo) {
        this.filterDsInfo = dsInfo;
    }
}
