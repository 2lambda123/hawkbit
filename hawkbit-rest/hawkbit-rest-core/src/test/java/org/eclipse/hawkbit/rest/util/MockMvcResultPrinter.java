/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.util.CollectionUtils;

public abstract class MockMvcResultPrinter {
    private static final Logger LOG = LoggerFactory.getLogger(MockMvcResultPrinter.class);

    private MockMvcResultPrinter() {
    }

    /**
     * Print {@link MvcResult} details to logger.
     */
    public static ResultHandler print() {
        return new ConsolePrintingResultHandler();
    }

    /**
     * An {@link PrintingResultHandler} that writes to logger
     */
    private static class ConsolePrintingResultHandler extends PrintingResultHandler {

        public ConsolePrintingResultHandler() {
            super(new ResultValuePrinter() {

                @Override
                public void printHeading(final String heading) {
                    LOG.debug(String.format("%20s:", heading));
                }

                @Override
                public void printValue(final String label, final Object v) {
                    Object value = v;

                    if (value != null && value.getClass().isArray()) {
                        value = CollectionUtils.arrayToList(value);
                    }
                    LOG.debug(String.format("%20s = %s", label, value));
                }
            });
        }
    }
}
