/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.management;

import java.util.Arrays;
import java.util.List;

import org.eclipse.hawkbit.im.authentication.SpPermission;
import org.eclipse.hawkbit.ui.menu.AbstractDashboardMenuItemNotification;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * Menu item for deployment.
 */
@SpringComponent
@UIScope
@Order(100)
public class DeploymentViewMenuItem extends AbstractDashboardMenuItemNotification {
    private static final long serialVersionUID = 1L;

    @Autowired
    DeploymentViewMenuItem(final VaadinMessageSource i18n) {
        super(i18n);
    }

    @Override
    public String getViewName() {
        return DeploymentView.VIEW_NAME;
    }

    @Override
    public Resource getDashboardIcon() {
        return VaadinIcons.HOME;
    }

    @Override
    public String getDashboardCaption() {
        return i18n.getMessage("dashboard.deployment.caption");
    }

    @Override
    public String getDashboardCaptionLong() {
        return i18n.getMessage("dashboard.deployment.caption-long");
    }

    @Override
    public List<String> getPermissions() {
        return Arrays.asList(SpPermission.READ_REPOSITORY, SpPermission.READ_TARGET);
    }

}
