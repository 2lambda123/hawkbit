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

/*
 * TenantAwareEvent bus events used in Dashboard are listed here as inner classes.
 */
/**
 * Containing all dashboard events.
 *
 */
public final class DashboardEvent {

    /**
     * utility class does not provide public constructor.
     */
    private DashboardEvent() {

    }

    /**
     * Creates a new post view change event ( Added this method to resolve sonar
     * issue ).
     * 
     * @param view
     *            the view which has been changed to
     * @return return new instance of {@link PostViewChangeEvent}
     */
    public static PostViewChangeEvent createPostViewChangeEvent(final DashboardMenuItem view) {
        /*
         * ( Added this method to resolve sonar issue ). Please remove this method in
         * future.
         */
        return new PostViewChangeEvent(view);
    }

    /**
     * TenantAwareEvent to indicate that the current shown view has been changed.
     * 
     *
     *
     *
     */
    public static final class PostViewChangeEvent {
        private final DashboardMenuItem view;

        /**
         * creates a new post view change event.
         * 
         * @param view
         *            the view which has been changed to
         */
        public PostViewChangeEvent(final DashboardMenuItem view) {
            this.view = view;
        }

        /**
         * @return the view type to which view has been changed to
         */
        public DashboardMenuItem getView() {
            return view;
        }
    }
}
