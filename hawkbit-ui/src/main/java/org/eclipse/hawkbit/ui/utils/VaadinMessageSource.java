/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.utils;

import java.io.Serializable;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.vaadin.ui.UI;

/**
 * Utility class leveraging Spring Boot auto configuration of
 * {@link MessageSource} and with Vaadins {@link UI#getLocale()}.
 *
 */
public class VaadinMessageSource implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(VaadinMessageSource.class);

    private final transient MessageSource source;

    /**
     * Constructor for VaadinMessageSource
     *
     * @param source
     *            from Spring to resolve messages
     */
    public VaadinMessageSource(final MessageSource source) {
        this.source = source;
    }

    /**
     * Tries to resolve the message based on
     * {@link HawkbitCommonUtil#getCurrentLocale()}. Returns message code if fitting
     * message could not be found.
     *
     * @param code
     *            the code to lookup up.
     * @param args
     *            Array of arguments that will be filled in for params within
     *            the message.
     *
     * @return the resolved message, or the message code if the lookup fails.
     *
     * @see MessageSource#getMessage(String, Object[], Locale)
     * @see HawkbitCommonUtil#getCurrentLocale()
     */
    public String getMessage(final String code, final Object... args) {
        return getMessage(HawkbitCommonUtil.getCurrentLocale(), code, args);
    }

    /**
     * Tries to resolve the message based on the provided Local. Returns message
     * code if fitting message could not be found.
     * 
     * @param local
     *            to determinate the Language.
     * @param code
     *            the code to lookup up.
     * @param args
     *            Array of arguments that will be filled in for params within
     *            the message.
     * 
     * @return the resolved message, or the message code if the lookup fails.
     */
    public String getMessage(final Locale local, final String code, final Object... args) {
        try {
            return source.getMessage(code, args, local);
        } catch (final NoSuchMessageException ex) {
            LOG.error("Failed to retrieve message!", ex);
            return code;
        }
    }
}
