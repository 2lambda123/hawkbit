/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.management.miscs;

import org.eclipse.hawkbit.repository.model.Action.ActionType;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

/**
 * Action type option group layout for auto assignment.
 */
public class ActionTypeOptionGroupAutoAssignmentLayout extends AbstractActionTypeOptionGroupLayout {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * 
     * @param i18n
     *            VaadinMessageSource
     * @param actionTypeOptionGroupId
     *            Id of action type option group
     */
    public ActionTypeOptionGroupAutoAssignmentLayout(final VaadinMessageSource i18n,
            final String actionTypeOptionGroupId) {
        super(i18n, actionTypeOptionGroupId);
    }

    @Override
    protected void addOptionGroup() {
        actionTypeOptionGroup.setItems(ActionType.FORCED, ActionType.SOFT, ActionType.DOWNLOAD_ONLY);
        addComponent(actionTypeOptionGroup);
    }
}
