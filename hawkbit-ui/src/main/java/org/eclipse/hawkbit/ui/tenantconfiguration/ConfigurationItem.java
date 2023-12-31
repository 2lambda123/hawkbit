/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.tenantconfiguration;

import java.io.Serializable;

/**
 * Represents an configurationItem, which can be modified by the user
 */
public interface ConfigurationItem {

    /**
     * called to verify that the Input done by the user is valid
     * 
     * @return true when the data is valid, false otherwise
     */
    boolean isUserInputValid();

    /**
     * Adds a configuration change listener to notify about configuration
     * changes.
     * 
     * @param listener
     *            the listener to be notified in case the item changes some
     *            configuration
     */
    void addChangeListener(final ConfigurationItemChangeListener listener);

    /**
     * Configuration Change Listener to be notified about configuration changes
     * in configuration group.
     *
     */
    @FunctionalInterface
    interface ConfigurationItemChangeListener extends Serializable {
        /**
         * called to notify about configuration has been changed.
         */
        void configurationHasChanged();
    }
}
