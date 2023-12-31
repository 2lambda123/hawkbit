/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.state;

import java.io.Serializable;

/**
 * Grid layout ui state
 */
public class GridLayoutUiState implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean maximized;
    private String searchFilter;
    private Long selectedEntityId;

    /**
     * @return true if maximize is enabled else false
     */
    public boolean isMaximized() {
        return maximized;
    }

    /**
     * Sets the layout view
     *
     * @param maximized
     *          true if maximize is enabled else false
     */
    public void setMaximized(final boolean maximized) {
        this.maximized = maximized;
    }

    /**
     * @return Search filter
     */
    public String getSearchFilter() {
        return searchFilter;
    }

    /**
     * Sets the search filter
     *
     * @param searchFilter
     *          Search filter
     */
    public void setSearchFilter(final String searchFilter) {
        this.searchFilter = searchFilter;
    }

    /**
     * @return Selected entity id
     */
    public Long getSelectedEntityId() {
        return selectedEntityId;
    }

    /**
     * Sets the selected entity id
     *
     * @param selectedEntityId
     *          Id
     */
    public void setSelectedEntityId(final Long selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }
}
