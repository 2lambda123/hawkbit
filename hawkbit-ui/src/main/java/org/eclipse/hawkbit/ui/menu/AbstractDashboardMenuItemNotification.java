/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.menu;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

import com.vaadin.ui.Label;

/**
 * Contains the menu items' Label for the notification display.
 */
public abstract class AbstractDashboardMenuItemNotification implements DashboardMenuItem {

    private static final long serialVersionUID = 1L;

    private final Label notificationsLabel = new Label();

    protected final VaadinMessageSource i18n;

    protected AbstractDashboardMenuItemNotification(final VaadinMessageSource i18n) {
        this.i18n = i18n;
    }

    @Override
    public void setNotificationUnreadValue(final AtomicInteger notificationUnread) {
        notificationsLabel.setValue(String.valueOf(notificationUnread.get()));
        notificationsLabel.setVisible(notificationUnread.get() > 0);
    }

    @Override
    public Label getNotificationUnreadLabel() {
        return notificationsLabel;
    }
}
