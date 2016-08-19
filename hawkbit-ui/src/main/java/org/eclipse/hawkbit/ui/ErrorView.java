/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.ui;

import org.eclipse.hawkbit.ui.menu.DashboardMenu;
import org.eclipse.hawkbit.ui.menu.DashboardMenuItem;
import org.eclipse.hawkbit.ui.utils.I18N;
import org.eclipse.hawkbit.ui.utils.SPUILabelDefinitions;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * View class that is instantiated when no other view matches the navigation
 * state.
 *
 * @see Navigator#setErrorView(Class)
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
class ErrorView extends VerticalLayout implements View {

    private final Label message;

    @Autowired
    private I18N i18n;

    @Autowired
    private DashboardMenu dashboardMenu;

    /**
     * Constructor.
     */
    public ErrorView() {
        setMargin(true);
        message = new Label();
        addComponent(message);
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
        final DashboardMenuItem view = dashboardMenu.getByViewName(event.getViewName());
        if (view == null) {
            message.setValue(i18n.get("message.error.view", new Object[] { event.getViewName() }));
            return;
        }
        if (dashboardMenu.isAccessDenied(event.getViewName())) {
            final Notification nt = new Notification("Access denied",
                    i18n.get("message.accessdenied.view", new Object[] { event.getViewName() }), Type.ERROR_MESSAGE,
                    false);
            nt.setStyleName(SPUILabelDefinitions.SP_NOTIFICATION_ERROR_MESSAGE_STYLE);
            nt.setPosition(Position.BOTTOM_RIGHT);
            nt.show(UI.getCurrent().getPage());
            message.setValue(i18n.get("message.accessdenied.view", new Object[] { event.getViewName() }));
        }
    }

}
