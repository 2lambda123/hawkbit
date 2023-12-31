/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.layout.listener;

import java.util.function.Consumer;

import org.eclipse.hawkbit.ui.common.event.BulkUploadEventPayload;
import org.eclipse.hawkbit.ui.common.event.EventTopics;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.server.VaadinSession;

/**
 * Event change listener for bulk upload
 */
public class BulkUploadChangedListener extends TopicEventListener {
    private final Consumer<BulkUploadEventPayload> bulkUploadCallback;

    /**
     * Constructor for BulkUploadChangedListener
     *
     * @param eventBus
     *            UIEventBus
     * @param bulkUploadCallback
     *            Bulk upload callback event
     */
    public BulkUploadChangedListener(final EventBus eventBus,
            final Consumer<BulkUploadEventPayload> bulkUploadCallback) {
        super(eventBus, EventTopics.BULK_UPLOAD_CHANGED);

        this.bulkUploadCallback = bulkUploadCallback;
    }

    // session scope is used here because the bulk upload handler is running
    // as the background job, started by the ui Executor and survives the UI
    // restart
    @EventBusListenerMethod(scope = EventScope.SESSION)
    private void onBulkUploadEvent(final BulkUploadEventPayload eventPayload) {
        VaadinSession.getCurrent().access(() -> bulkUploadCallback.accept(eventPayload));
    }
}
