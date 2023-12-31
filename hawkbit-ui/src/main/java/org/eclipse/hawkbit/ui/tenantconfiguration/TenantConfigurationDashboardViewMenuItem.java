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
 * Menu item for system configuration view.
 */
@SpringComponent
@UIScope
@Order(700)
public class TenantConfigurationDashboardViewMenuItem extends AbstractDashboardMenuItemNotification {
    private static final long serialVersionUID = 1L;

    @Autowired
    TenantConfigurationDashboardViewMenuItem(final VaadinMessageSource i18n) {
        super(i18n);
    }

    @Override
    public String getViewName() {
        return TenantConfigurationDashboardView.VIEW_NAME;
    }

    @Override
    public Resource getDashboardIcon() {
        return VaadinIcons.COG;
    }

    @Override
    public String getDashboardCaption() {
        return i18n.getMessage("dashboard.tenantconfig.caption");
    }

    @Override
    public String getDashboardCaptionLong() {
        return i18n.getMessage("dashboard.tenantconfig.caption-long");
    }

    @Override
    public List<String> getPermissions() {
        return Arrays.asList(SpPermission.TENANT_CONFIGURATION);
    }

}
