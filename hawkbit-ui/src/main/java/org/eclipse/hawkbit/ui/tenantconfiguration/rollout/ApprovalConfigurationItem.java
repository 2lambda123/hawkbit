/**
 * Copyright (c) 2018 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.tenantconfiguration.rollout;

import org.eclipse.hawkbit.ui.components.SPUIComponentProvider;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

import com.vaadin.ui.HorizontalLayout;

/**
 * This class represents the UI item for the target security token section in
 * the authentication configuration view.
 */
public class ApprovalConfigurationItem extends HorizontalLayout {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for tenant specific approval mode setting.
     *
     * @param i18n
     *            used to translate labels
     */
    public ApprovalConfigurationItem(final VaadinMessageSource i18n) {
        setSpacing(false);
        setMargin(false);
        addComponent(SPUIComponentProvider.generateLabel(i18n, "configuration.rollout.approval.label"));
    }

}
